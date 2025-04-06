package propperties;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PropertyTestStudent {

    @Test
    void testDefaultConstructor() {
        Property property = new Property();
        assertEquals("", property.getPropertyName());
        assertEquals("", property.getCity());
        assertEquals(0.0, property.getRentAmount(), 0.001);
        assertEquals("", property.getOwner());
        assertNotNull(property.getPlot());
    }

    @Test
    void testParameterizedConstructor() {
        Property property = new Property("Beach House", "Malibu", 5000.0, "Owner");
        assertEquals("Beach House", property.getPropertyName());
        assertEquals("Malibu", property.getCity());
        assertEquals(5000.0, property.getRentAmount(), 0.001);
        assertEquals("Owner", property.getOwner());
    }

    @Test
    void testCopyConstructor() {
        Property original = new Property("Condo", "Miami", 3000.0, "Investor", 1, 1, 2, 2);
        Property copy = new Property(original);
        assertEquals("Condo", copy.getPropertyName());
        assertEquals(3000.0, copy.getRentAmount(), 0.001);
        assertEquals(2, copy.getPlot().getWidth());
    }

    @Test
    void testToString() {
        Property property = new Property("Apartment", "NYC", 4000.0, "Manager");
        assertEquals("Apartment,NYC,Manager,4000.0", property.toString());
    }

    @Test
    void testSetters() {
        Property property = new Property();
        property.setPropertyName("Villa");
        property.setCity("Beverly Hills");
        property.setRentAmount(6000.0);
        property.setOwner("New Owner");
        
        assertEquals("Villa", property.getPropertyName());
        assertEquals("Beverly Hills", property.getCity());
        assertEquals(6000.0, property.getRentAmount(), 0.001);
        assertEquals("New Owner", property.getOwner());
    }

    @Test
    void testPlotSetter() {
        Property property = new Property();
        property.setPlot(1, 2, 3, 4);
        assertEquals(1, property.getPlot().getX());
        assertEquals(2, property.getPlot().getY());
        assertEquals(3, property.getPlot().getWidth());
        assertEquals(4, property.getPlot().getDepth());
    }
}
