import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CoffeeTestStudent {

	 @Test
	    public void testCoffeeConstructorAndCalcPrice() {
	        Coffee coffee = new Coffee("Latte", Size.SMALL, true, true);
	        assertTrue(coffee.calcPrice() > 2.0);
	    }

	    @Test
	    public void testExtraShotAndSyrupAffectsPrice() {
	        Coffee coffeeNoExtras = new Coffee("Americano", Size.SMALL, false, false);
	        Coffee coffeeWithExtras = new Coffee("Americano", Size.SMALL, true, true);

	        assertTrue(coffeeWithExtras.calcPrice() > coffeeNoExtras.calcPrice());
	    }

	    @Test
	    public void testCoffeeToStringContainsExtras() {
	        Coffee coffee = new Coffee("Mocha", Size.MEDIUM, true, true);
	        assertTrue(coffee.toString().contains("Extra Shot: Yes"));
	        assertTrue(coffee.toString().contains("Extra Syrup: Yes"));
	    }

}
