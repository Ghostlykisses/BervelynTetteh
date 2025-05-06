import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OrderTestStudent {

	 @Test
	    public void testOrderConstructorAndGetCustomer() {
	        Customer customer = new Customer("Emily", 21);
	        Order order = new Order(15, Day.WEDNESDAY, customer);

	        assertEquals("Emily", order.getCustomer().getName());
	    }

	    @Test
	    public void testAddNewBeverageAndTotal() {
	        Customer customer = new Customer("Lucas", 19);
	        Order order = new Order(14, Day.THURSDAY, customer);

	        order.addNewBeverage("Espresso", Size.SMALL, false, true);
	        order.addNewBeverage("Smoothie", Size.LARGE, 4, true);

	        assertEquals(2, order.getBeverages().size());
	        assertTrue(order.calcOrderTotal() > 2.0);
	    }

	    @Test
	    public void testCompareToOrders() {
	        Customer c1 = new Customer("Anna", 20);
	        Customer c2 = new Customer("Mike", 22);

	        Order order1 = new Order(10, Day.FRIDAY, c1);
	        Order order2 = new Order(12, Day.FRIDAY, c2);

	        assertNotEquals(0, order1.compareTo(order2));
	    }

}
