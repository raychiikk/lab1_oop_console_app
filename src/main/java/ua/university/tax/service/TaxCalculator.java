package ua.university.tax.service;

import ua.university.tax.model.Income;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TaxCalculator {

    /**
     * повертає загальну суму податків для заданого списку доходів
     */
    public double calculateTotalTax(List<Income> incomes) {
        return incomes.stream()
                .mapToDouble(Income::calculateTax)
                .sum();
    }

    /**
     * сортує список доходів за сумою податку (від меншого до більшого)
     */
    public List<Income> sortTaxesByAmount(List<Income> incomes) {
        return incomes.stream()
                .sorted(Comparator.comparingDouble(Income::calculateTax))
                .collect(Collectors.toList());
    }
}
