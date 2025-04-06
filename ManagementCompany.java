/**
 * Class: CMSC203 31843
 * Instructor: Ashique Tanveer
 * Description: An application that lets the user create a management company and add the properties managed by the company to its list.
 * Due: April 8,2025 
 * Platform/Compiler:Eclipse
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name Here: Bervelyn Tetteh
 */

package propperties;

/**
 * Manages properties for a real estate company
 */
public class ManagementCompany {
    private static final int MAX_PROPERTY = 5;
    private static final int MGMT_WIDTH = 10;
    private static final int MGMT_DEPTH = 10;

    private String name;
    private String taxID;
    private double mgmFee;
    private Property[] properties;
    private Plot plot;

    public ManagementCompany() {
        this("", "", 0);
    }

    public ManagementCompany(String name, String taxID, double mgmFee) {
        this(name, taxID, mgmFee, 0, 0, MGMT_WIDTH, MGMT_DEPTH);
    }

    public ManagementCompany(String name, String taxID, double mgmFee,
                             int x, int y, int width, int depth) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFee = mgmFee;
        this.plot = new Plot(x, y, width, depth);
        this.properties = new Property[MAX_PROPERTY];
    }

    public int addProperty(Property property) {
        if (property == null) return -2;

        for (int i = 0; i < MAX_PROPERTY; i++) {
            if (properties[i] != null && properties[i].getPlot().overlaps(property.getPlot())) {
                return -4;
            }
        }

        if (!plot.encompasses(property.getPlot())) return -3;

        for (int i = 0; i < MAX_PROPERTY; i++) {
            if (properties[i] == null) {
                properties[i] = new Property(property);
                return i;
            }
        }
        return -1; // Array full
    }

    public int addProperty(String name, String city, double rent, String owner,
                           int x, int y, int width, int depth) {
        return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
    }

    public Property getHighestRentProperty() {
        double maxRent = 0;
        Property maxProp = null;
        for (Property p : properties) {
            if (p != null && p.getRentAmount() > maxRent) {
                maxRent = p.getRentAmount();
                maxProp = p;
            }
        }
        return maxProp;
    }

    public String maxRentPropInfo() {
        Property max = getHighestRentProperty();
        return max != null ? max.toString() : "No properties available";
    }

    public double totalRent() {
        double total = 0;
        for (Property p : properties) {
            if (p != null) total += p.getRentAmount();
        }
        return total;
    }

    public String getName() { return name; }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("List of the properties for ").append(name).append(", taxID: ").append(taxID).append("\n");
        for (Property p : properties) {
            if (p != null) sb.append(p.toString()).append("\n");
        }
        sb.append("Total management Fee: ").append((mgmFee / 100) * totalRent());
        return sb.toString();
    }
}
