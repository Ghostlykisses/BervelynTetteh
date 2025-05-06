import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SizeTestStudent {

	@Test
    public void testSizeEnumValues() {
        assertEquals(Size.SMALL.name(), "SMALL");
        assertEquals(Size.MEDIUM.name(), "MEDIUM");
        assertEquals(Size.LARGE.name(), "LARGE");
    }

    @Test
    public void testSizeEnumOrdinal() {
        assertEquals(Size.SMALL.ordinal(), 0);
        assertEquals(Size.LARGE.ordinal(), 2);
    }

    @Test
    public void testSizeEnumValueOf() {
        assertEquals(Size.valueOf("MEDIUM"), Size.MEDIUM);
        assertEquals(Size.valueOf("SMALL"), Size.SMALL);
    }

}
