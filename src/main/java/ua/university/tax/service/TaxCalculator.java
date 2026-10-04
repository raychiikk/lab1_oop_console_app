package ua.university.tax.service;

import ua.university.tax.model.Income;
import ua.university.tax.model.TaxDeclaration;
import ua.university.tax.model.Taxpayer;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TaxCalculator {

    public TaxDeclaration createDeclaration(Taxpayer taxpayer) {
        List<Income> incomes = taxpayer.getIncomes();
        
        if (incomes.isEmpty()) {
            return new TaxDeclaration(taxpayer, List.of(), 0.0);
        }

        double totalTax = incomes.stream().mapToDouble(Income::calculateTax).sum();
        
        List<Income> sorted = incomes.stream()
                .sorted(Comparator.comparingDouble(Income::calculateTax))
                .collect(Collectors.toList());

        return new TaxDeclaration(taxpayer, sorted, totalTax);
    }
}
