package ua.university.tax.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IncomeTest {

    @Test
    void testNegativeAmountThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new StandardRateIncome("Test", -100, 0.1);
        });
        assertEquals("Income amount cannot be negative", exception.getMessage());
    }

    @Test
    void testToStringFormat() {
        Income income = new StandardRateIncome("Test", 1000, 0.1);
        assertEquals("Test: Income = 1000.00, Tax = 100.00", income.toString());
    }
}