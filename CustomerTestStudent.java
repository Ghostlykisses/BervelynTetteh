import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomerTestStudent {

	@Test
    public void testCustomerConstructorAndGetters() {
        Customer customer = new Customer("Sarah", 20);
        assertEquals("Sarah", customer.getName());
        assertEquals(20, customer.getAge());
    }

    @Test
    public void testCustomerCopyConstructor() {
        Customer original = new Customer("Tom", 18);
        Customer copy = new Customer(original);

        assertEquals(original.getName(), copy.getName());
        assertEquals(original.getAge(), copy.getAge());
    }
}
