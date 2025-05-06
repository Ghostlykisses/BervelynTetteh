import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TypeTestStudent {

	@Test
    public void testTypeEnumValues() {
        assertEquals(Type.COFFEE.name(), "COFFEE");
        assertEquals(Type.SMOOTHIE.name(), "SMOOTHIE");
        assertEquals(Type.ALCOHOL.name(), "ALCOHOL");
    }

    @Test
    public void testTypeEnumOrdinal() {
        assertEquals(Type.COFFEE.ordinal(), 0);
        assertEquals(Type.ALCOHOL.ordinal(), 2);
    }

    @Test
    public void testTypeEnumValueOf() {
        assertEquals(Type.valueOf("COFFEE"), Type.COFFEE);
        assertEquals(Type.valueOf("ALCOHOL"), Type.ALCOHOL);
    }

}
