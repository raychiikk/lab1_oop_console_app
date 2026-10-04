package ua.university.tax.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GiftIncomeTest {

    @Test
    void testGiftIncomeTaxCalculationCash() {
        GiftIncome income = new GiftIncome("Cash Gift", 10000, GiftType.CASH, 0.05);
        assertEquals(500.0, income.calculateTax(), 0.01);
        assertEquals(GiftType.CASH, income.getGiftType());
    }

    @Test
    void testGiftIncomeTaxCalculationProperty() {
        GiftIncome income = new GiftIncome("Apartment Gift", 1000000, GiftType.PROPERTY, 0.05);
        assertEquals(50000.0, income.calculateTax(), 0.01);
        assertEquals(GiftType.PROPERTY, income.getGiftType());
    }
}