package ua.university.tax.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MaterialAidIncomeTest {

    @Test
    void testCalculateTaxAboveFreeLimit() {
        // дохід 5000, неоподатковуваний ліміт 3000
        // база: 5000 - 3000 = 2000. податок: 2000 * 0.18 = 360
        MaterialAidIncome income = new MaterialAidIncome("Financial Aid", 5000, 3000);
        assertEquals(360.0, income.calculateTax(), 0.01);
    }

    @Test
    void testCalculateTaxBelowFreeLimit() {
        // дохід менший за неоподатковуваний ліміт. податок має бути 0
        MaterialAidIncome income = new MaterialAidIncome("Small Aid", 2000, 3000);
        assertEquals(0.0, income.calculateTax(), 0.01);
    }
}
