package ua.university.tax.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EmploymentIncomeTest {

    @Test
    void testCalculateTaxWithChildBenefits() {
        // дохід 10000, 2 дитини, пільга 1000 на кожну
        // база оподаткування: 10000 - (2 * 1000) = 8000
        // податок: 8000 * 0.18 = 1440
        EmploymentIncome income = new EmploymentIncome("Developer Job", 10000, 2, 1000);
        assertEquals(1440.0, income.calculateTax(), 0.01);
    }

    @Test
    void testCalculateTaxWithBenefitsExceedingIncome() {
        // пільги більші за дохід. податок має дорівнювати 0, а не бути від'ємним
        EmploymentIncome income = new EmploymentIncome("Part-time Job", 5000, 2, 3000);
        assertEquals(0.0, income.calculateTax(), 0.01);
    }
}
