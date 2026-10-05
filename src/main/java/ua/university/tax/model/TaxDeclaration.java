package ua.university.tax.model;

import java.util.Collections;
import java.util.List;

/**
 * представляє остаточну податкову декларацію, що містить розподілені за категоріями доходи та загальну суму податку
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
