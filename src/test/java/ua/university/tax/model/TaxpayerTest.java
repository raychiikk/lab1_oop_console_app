package ua.university.tax.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TaxpayerTest {

    @Test
    void testNegativeChildrenThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new Taxpayer("Oleg", -1));
    }

    @Test
    void testAddNullIncomeThrowsException() {
        Taxpayer taxpayer = new Taxpayer("Oleg", 2);
        assertThrows(IllegalArgumentException.class, () -> taxpayer.addIncome(null));
    }

    @Test
    void testPrimaryBenefitAppliedOnlyOnce() {
        Taxpayer taxpayer = new Taxpayer("Oleg", 2); // 2 діти = 4000 пільга
        
        taxpayer.addEmploymentIncome("Primary Job", 10000, true); // база 6000 -> податок 1080
        taxpayer.addEmploymentIncome("Secondary Job", 10000, true); // пільга вже застосована! база 10000 -> податок 1800
        
        assertEquals(1080.0, taxpayer.getIncomes().get(0).calculateTax(), 0.01);
        assertEquals(1800.0, taxpayer.getIncomes().get(1).calculateTax(), 0.01);
    }
    
    @Test
    void testGetters() {
        Taxpayer taxpayer = new Taxpayer("Ivan", 3);
        assertEquals("Ivan", taxpayer.getName());
        assertEquals(3, taxpayer.getChildrenCount());
        assertEquals(0, taxpayer.getIncomes().size());
    }
}
