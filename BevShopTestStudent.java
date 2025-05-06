import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BevShopTestStudent {

	@Test
    public void testStartNewOrderAndGetCurrentOrder() {
        BevShop shop = new BevShop();
        shop.startNewOrder(10, Day.MONDAY, "John", 25);

        assertNotNull(shop.getCurrentOrder());
        assertEquals("John", shop.getCurrentOrder().getCustomer().getName());
    }

    @Test
    public void testProcessOrders() {
        BevShop shop = new BevShop();
        shop.startNewOrder(10, Day.FRIDAY, "Alice", 30);

        shop.processCoffeeOrder("Latte", Size.SMALL, false, false);
        shop.processSmoothieOrder("Banana Smoothie", Size.MEDIUM, 2, true);
        shop.processAlcoholOrder("Wine", Size.LARGE);

        assertEquals(3, shop.getCurrentOrder().getBeverages().size());
    }

    @Test
    public void testTotalMonthlySale() {
        BevShop shop = new BevShop();
        shop.startNewOrder(12, Day.SATURDAY, "Jake", 22);
        shop.processCoffeeOrder("Espresso", Size.SMALL, true, false);
        double total = shop.totalMonthlySale();

        assertTrue(total > 0);
    }

}
