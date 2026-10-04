package ua.university.tax.model;

import java.util.List;

public class TaxDeclaration {
    private Taxpayer taxpayer;
    private List<Income> sortedIncomes;
    private double totalTax;

    public TaxDeclaration(Taxpayer taxpayer, List<Income> sortedIncomes, double totalTax) {
        this.taxpayer = taxpayer;
        this.sortedIncomes = sortedIncomes;
        this.totalTax = totalTax;
    }

    public double getTotalTax() {
        return totalTax;
    }

    public List<Income> getSortedIncomes() {
        return sortedIncomes;
    }

    public void printDeclaration() {
        System.out.println("=== Tax Declaration ===");
        System.out.println("Taxpayer: " + taxpayer.getName());
        System.out.println("Children count: " + taxpayer.getChildrenCount());
        System.out.println("-----------------------");
        for (Income income : sortedIncomes) {
            System.out.println(income);
        }
        System.out.println("-----------------------");
        System.out.printf("Total tax to pay: %.2f UAH\n", totalTax);
        System.out.println("=======================");
    }
}
