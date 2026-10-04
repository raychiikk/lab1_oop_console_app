package ua.university.tax.model;

import java.util.Collections;
import java.util.List;

/**
 * Represents a final tax declaration containing sorted incomes and total tax.
 */
public class TaxDeclaration {
    private Taxpayer taxpayer;
    private List<Income> sortedIncomes;
    private double totalTax;

    public TaxDeclaration(Taxpayer taxpayer, List<Income> sortedIncomes, double totalTax) {
        this.taxpayer = taxpayer;
        this.sortedIncomes = sortedIncomes;
        this.totalTax = totalTax;
    }

    public Taxpayer getTaxpayer() {
        return taxpayer;
    }

    public double getTotalTax() {
        return totalTax;
    }

    public List<Income> getSortedIncomes() {
        return Collections.unmodifiableList(sortedIncomes);
    }
}
