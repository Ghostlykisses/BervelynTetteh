package propperties;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ManagementCompanyTester {
    private ManagementCompany mgmt;

    @BeforeEach
    public void setUp() {
        mgmt = new ManagementCompany("RealCo", "12345", 10.0);
    }

    @Test
    public void testAddPropertySuccessfully() {
        int result = mgmt.addProperty("P1", "City", 1000, "Owner", 1, 1, 2, 2);
        assertEquals(0, result);
    }

    @Test
    public void testAddPropertyExceedingLimit() {
        assertEquals(0, mgmt.addProperty("P1", "City", 1000, "Owner", 0, 0, 1, 1));
        assertEquals(1, mgmt.addProperty("P2", "City", 1000, "Owner", 1, 0, 1, 1));
        assertEquals(2, mgmt.addProperty("P3", "City", 1000, "Owner", 2, 0, 1, 1));
        assertEquals(3, mgmt.addProperty("P4", "City", 1000, "Owner", 3, 0, 1, 1));
        assertEquals(4, mgmt.addProperty("P5", "City", 1000, "Owner", 4, 0, 1, 1));
        assertEquals(-1, mgmt.addProperty("P6", "City", 1000, "Owner", 5, 0, 1, 1));
    }

    @Test
    public void testAddNullProperty() {
        assertEquals(-2, mgmt.addProperty(null));
    }

    @Test
    public void testAddPropertyOutOfBounds() {
        int result = mgmt.addProperty("P1", "City", 1000, "Owner", 9, 9, 5, 5);
        assertEquals(-3, result);
    }

    @Test
    public void testAddPropertyOverlapping() {
        mgmt.addProperty("P1", "City", 1000, "Owner", 0, 0, 2, 2);
        int result = mgmt.addProperty("P2", "City", 1000, "Owner", 1, 1, 2, 2);
        assertEquals(-4, result);
    }

    @Test
    public void testTotalRent() {
        mgmt.addProperty("P1", "City", 1000, "Owner", 1, 1, 2, 2);
        mgmt.addProperty("P2", "City", 500, "Owner", 3, 3, 2, 2);
        assertEquals(1500.0, mgmt.totalRent());
    }

    @Test
    public void testMaxRentPropInfo() {
        mgmt.addProperty("Cheap", "City", 500, "Owner", 1, 1, 2, 2);
        mgmt.addProperty("Expensive", "City", 2500, "Owner", 4, 4, 2, 2);
        assertTrue(mgmt.maxRentPropInfo().contains("Expensive"));
    }
}
