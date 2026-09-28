package ua.university.tax.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.university.tax.model.Income;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TaxCalculatorTest {

    private TaxCalculator taxCalculator;

    // створюємо заглушки (моки) для абстрактного класу Income
    @Mock
    private Income lowTaxIncome;

    @Mock
    private Income highTaxIncome;

    @BeforeEach
    void setUp() {
        taxCalculator = new TaxCalculator();
    }

    @Test
    void testCalculateTotalTax() {
        // налаштовуємо поведінку моків: вказуємо, що вони мають повертати при виклику calculateTax()
        when(lowTaxIncome.calculateTax()).thenReturn(500.0);
        when(highTaxIncome.calculateTax()).thenReturn(1500.0);

        List<Income> incomes = Arrays.asList(lowTaxIncome, highTaxIncome);
        
        double total = taxCalculator.calculateTotalTax(incomes);

        assertEquals(2000.0, total, 0.01, "Total tax should be correct");
    }

    @Test
    void testSortTaxesByAmount() {
        when(lowTaxIncome.calculateTax()).thenReturn(500.0);
        when(highTaxIncome.calculateTax()).thenReturn(1500.0);

        // передаємо список у невідсортованому (зворотному) порядку
        List<Income> incomes = Arrays.asList(highTaxIncome, lowTaxIncome);
        
        List<Income> sorted = taxCalculator.sortTaxesByAmount(incomes);

        // перевіряємо, чи елементи відсортовані від меншого податку до більшого
        assertEquals(lowTaxIncome, sorted.get(0), "Lowest tax should be first");
        assertEquals(highTaxIncome, sorted.get(1), "Highest tax should be last");
    }
}