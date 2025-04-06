package propperties;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PlotTestStudent {

    @Test
    void testDefaultConstructor() {
        Plot plot = new Plot();
        assertEquals(0, plot.getX());
        assertEquals(0, plot.getY());
        assertEquals(1, plot.getWidth());
        assertEquals(1, plot.getDepth());
    }

    @Test
    void testCopyConstructor() {
        Plot original = new Plot(2, 3, 5, 5);
        Plot copy = new Plot(original);
        assertEquals(2, copy.getX());
        assertEquals(3, copy.getY());
        assertEquals(5, copy.getWidth());
        assertEquals(5, copy.getDepth());
    }

    @Test
    void testParameterizedConstructor() {
        Plot plot = new Plot(1, 2, 3, 4);
        assertEquals(1, plot.getX());
        assertEquals(2, plot.getY());
        assertEquals(3, plot.getWidth());
        assertEquals(4, plot.getDepth());
    }

    @Test
    void testOverlaps() {
        Plot plot1 = new Plot(1, 1, 3, 3);
        Plot plot2 = new Plot(2, 2, 3, 3);
        assertTrue(plot1.overlaps(plot2));
    }

    @Test
    void testNoOverlap() {
        Plot plot1 = new Plot(1, 1, 2, 2);
        Plot plot2 = new Plot(4, 4, 2, 2);
        assertFalse(plot1.overlaps(plot2));
    }

    @Test
    void testEncompasses() {
        Plot plot1 = new Plot(0, 0, 5, 5);
        Plot plot2 = new Plot(1, 1, 3, 3);
        assertTrue(plot1.encompasses(plot2));
    }

    @Test
    void testToString() {
        Plot plot = new Plot(1, 2, 3, 4);
        assertEquals("1,2,3,4", plot.toString());
    }
}