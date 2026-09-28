package ua.university.tax.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StandardRateIncomeTest {

    @Test
    void testCalculateTax() {
        // дохід 10000, ставка 5% (0.05). податок: 10000 * 0.05 = 500
        StandardRateIncome income = new StandardRateIncome("Property Sale", 10000, 0.05);
        assertEquals(500.0, income.calculateTax(), 0.01);
    }
}