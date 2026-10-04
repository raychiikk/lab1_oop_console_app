package ua.university.tax.model;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TaxDeclarationTest {
    
    @Test
    void testGetters() {
        Taxpayer taxpayer = new Taxpayer("Oleg", 1);
        TaxDeclaration declaration = new TaxDeclaration(taxpayer, List.of(), 500.0);
        
        assertEquals("Oleg", declaration.getTaxpayer().getName());
        assertEquals(500.0, declaration.getTotalTax());
        assertNotNull(declaration.getSortedIncomes());
    }
    
    @Test
    void testUnmodifiableList() {
        Taxpayer taxpayer = new Taxpayer("Oleg", 1);
        TaxDeclaration declaration = new TaxDeclaration(taxpayer, List.of(), 500.0);
        
        // перевіряємо інкапсуляцію: спроба змінити список має викликати помилку
        assertThrows(UnsupportedOperationException.class, () -> {
            declaration.getSortedIncomes().add(new StandardRateIncome("Test", 100, 0.1));
        });
    }
}