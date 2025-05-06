import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DayTestStudent {

	 @Test
	    public void testDayEnumValues() {
	        assertEquals(Day.MONDAY.name(), "MONDAY");
	        assertEquals(Day.TUESDAY.name(), "TUESDAY");
	        assertEquals(Day.WEDNESDAY.name(), "WEDNESDAY");
	        assertEquals(Day.THURSDAY.name(), "THURSDAY");
	        assertEquals(Day.FRIDAY.name(), "FRIDAY");
	        assertEquals(Day.SATURDAY.name(), "SATURDAY");
	        assertEquals(Day.SUNDAY.name(), "SUNDAY");
	    }

	    @Test
	    public void testDayEnumOrdinal() {
	        assertEquals(Day.MONDAY.ordinal(), 0);
	        assertEquals(Day.SUNDAY.ordinal(), 6);
	    }

	    @Test
	    public void testDayEnumValueOf() {
	        assertEquals(Day.valueOf("MONDAY"), Day.MONDAY);
	        assertEquals(Day.valueOf("FRIDAY"), Day.FRIDAY);
	    }

}
