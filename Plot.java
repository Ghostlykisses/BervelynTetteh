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

public class Plot {
    private int x, y, width, depth;

    public Plot() {
        this(0, 0, 1, 1);
    }

    public Plot(Plot otherPlot) {
        this(otherPlot.x, otherPlot.y, otherPlot.width, otherPlot.depth);
    }

    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }

    public boolean overlaps(Plot plot) {
        return !(x + width <= plot.x || plot.x + plot.width <= x ||
                 y + depth <= plot.y || plot.y + plot.depth <= y);
    }

    public boolean encompasses(Plot plot) {
        return x <= plot.x && y <= plot.y &&
               (x + width) >= (plot.x + plot.width) &&
               (y + depth) >= (plot.y + plot.depth);
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getWidth() { return width; }
    public int getDepth() { return depth; }

    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public void setWidth(int width) { this.width = width; }
    public void setDepth(int depth) { this.depth = depth; }

    public String toString() {
        return x + "," + y + "," + width + "," + depth;
    }
}
