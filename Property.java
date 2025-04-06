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

public class Property {
    private String propertyName;
    private String city;
    private double rentAmount;
    private String owner;
    private Plot plot;

    public Property() {
        this("", "", 0.0, "", 0, 0, 1, 1);
    }

    public Property(String name, String city, double rent, String owner) {
        this(name, city, rent, owner, 0, 0, 1, 1);
    }

    public Property(String name, String city, double rent, String owner,
                    int x, int y, int width, int depth) {
        this.propertyName = name;
        this.city = city;
        this.rentAmount = rent;
        this.owner = owner;
        this.plot = new Plot(x, y, width, depth);
    }

    public Property(Property otherProperty) {
        this(otherProperty.propertyName, otherProperty.city,
             otherProperty.rentAmount, otherProperty.owner,
             otherProperty.plot.getX(), otherProperty.plot.getY(),
             otherProperty.plot.getWidth(), otherProperty.plot.getDepth());
    }

    public String getPropertyName() { return propertyName; }
    public String getCity() { return city; }
    public double getRentAmount() { return rentAmount; }
    public String getOwner() { return owner; }
    public Plot getPlot() { return plot; }

    public void setPropertyName(String name) { propertyName = name; }
    public void setCity(String city) { this.city = city; }
    public void setRentAmount(double rent) { rentAmount = rent; }
    public void setOwner(String owner) { this.owner = owner; }
    public void setPlot(int x, int y, int width, int depth) {
        this.plot = new Plot(x, y, width, depth);
    }

    public String toString() {
        return propertyName + "," + city + "," + owner + "," + rentAmount;
    }
}
