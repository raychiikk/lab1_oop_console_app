package ua.university.tax.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EmploymentIncomeTest {

    @Test
    void testTaxableBaseIsZero() {
        // дохід рівно дорівнює сумі пільг (2 діти * 2000 = 4000)
        EmploymentIncome income = new EmploymentIncome("Job", 4000, 2);
        assertEquals(0.0, income.calculateTax(), 0.01);
    }

    @Test
    void testTaxableBaseBelowZero() {
        // пільги більші за дохід
        EmploymentIncome income = new EmploymentIncome("Job", 2000, 2);
        assertEquals(0.0, income.calculateTax(), 0.01);
    }
    
    @Test
    void testNormalTaxCalculation() {
        EmploymentIncome income = new EmploymentIncome("Job", 10000, 2);
        assertEquals(1080.0, income.calculateTax(), 0.01); // (10000 - 4000) * 0.18
    }
}