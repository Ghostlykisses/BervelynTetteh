import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AlcoholTestStudent {

	 @Test
	    public void testAlcoholConstructorAndCalcPrice() {
	        Alcohol alcohol = new Alcohol("Wine", Size.MEDIUM, true);
	        assertEquals(Size.MEDIUM, alcohol.getSize());
	        assertTrue(alcohol.calcPrice() > 0);
	    }

	    @Test
	    public void testAlcoholWeekendPrice() {
	        Alcohol alcoholWeekend = new Alcohol("Whiskey", Size.LARGE, true);
	        Alcohol alcoholWeekday = new Alcohol("Whiskey", Size.LARGE, false);

	        assertTrue(alcoholWeekend.calcPrice() > alcoholWeekday.calcPrice());
	    }

	    @Test
	    public void testAlcoholToStringContainsWeekendInfo() {
	        Alcohol alcohol = new Alcohol("Beer", Size.SMALL, true);
	        assertTrue(alcohol.toString().contains("Weekend: Yes"));
	    }
}
