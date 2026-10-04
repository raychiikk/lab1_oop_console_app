package ua.university.tax.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.university.tax.model.Income;
import ua.university.tax.model.TaxDeclaration;
import ua.university.tax.model.Taxpayer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TaxCalculatorTest {

    private TaxCalculator calculator;

    @Mock private Income income1;
    @Mock private Income income2;
    @Mock private Income income3;

    @BeforeEach
    void setUp() {
        calculator = new TaxCalculator();
    }

    @Test
    void testEmptyIncomeList() {
        Taxpayer taxpayer = new Taxpayer("Test", 0);
        TaxDeclaration declaration = calculator.createDeclaration(taxpayer);
        assertEquals(0.0, declaration.getTotalTax());
    }

    @Test
    void testSortingThreeElementsWithDuplicates() {
        Taxpayer taxpayer = new Taxpayer("Test", 0);
        taxpayer.addIncome(income1);
        taxpayer.addIncome(income2);
        taxpayer.addIncome(income3);

        // налаштовуємо моки (два однакових податки)
        when(income1.calculateTax()).thenReturn(1500.0);
        when(income2.calculateTax()).thenReturn(500.0);
        when(income3.calculateTax()).thenReturn(500.0);

        TaxDeclaration declaration = calculator.createDeclaration(taxpayer);
        
        // перевіряємо загальну суму
        assertEquals(2500.0, declaration.getTotalTax(), 0.01);
        
        // перевіряємо сортування (перші два мають бути по 500, останній 1500)
        assertEquals(500.0, declaration.getSortedIncomes().get(0).calculateTax(), 0.01);
        assertEquals(500.0, declaration.getSortedIncomes().get(1).calculateTax(), 0.01);
        assertEquals(1500.0, declaration.getSortedIncomes().get(2).calculateTax(), 0.01);
    }
}