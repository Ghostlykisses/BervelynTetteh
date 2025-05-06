import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SmoothieTestStudent {

	@Test
    public void testSmoothieConstructorAndCalcPrice() {
        Smoothie smoothie = new Smoothie("Berry Blast", Size.LARGE, 3, true);
        assertTrue(smoothie.calcPrice() > 2.0);
    }

    @Test
    public void testFruitAndProteinAffectsPrice() {
        Smoothie smoothieFewFruits = new Smoothie("Mango", Size.MEDIUM, 1, false);
        Smoothie smoothieManyFruitsProtein = new Smoothie("Mango", Size.MEDIUM, 5, true);

        assertTrue(smoothieManyFruitsProtein.calcPrice() > smoothieFewFruits.calcPrice());
    }

    @Test
    public void testSmoothieToStringContainsInfo() {
        Smoothie smoothie = new Smoothie("Green Power", Size.SMALL, 2, true);
        assertTrue(smoothie.toString().contains("Number Of Fruits: 2"));
        assertTrue(smoothie.toString().contains("Protein Powder: Yes"));
    }

}
