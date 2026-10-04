package ua.university.tax.main;

import ua.university.tax.model.Income;
import ua.university.tax.model.TaxDeclaration;
import ua.university.tax.model.Taxpayer;
import ua.university.tax.service.DataReader;
import ua.university.tax.service.TaxCalculator;

import java.io.IOException;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        try { 
            Taxpayer taxpayer = DataReader.loadTaxpayerData("incomes.csv");
            TaxCalculator calculator = new TaxCalculator();
            TaxDeclaration declaration = calculator.createDeclaration(taxpayer);
            
            printDeclaration(declaration);
            
        } catch (IOException | IllegalArgumentException e) {
            System.err.printf(Locale.US, "Error processing tax data: %s%n", e.getMessage());
        }
    }

    private static void printDeclaration(TaxDeclaration declaration) {
        System.out.printf(Locale.US, "=== Tax Declaration ===%n");
        System.out.printf(Locale.US, "Taxpayer: %s%n", declaration.getTaxpayer().getName());
        System.out.printf(Locale.US, "Children count: %d%n", declaration.getTaxpayer().getChildrenCount());
        System.out.printf(Locale.US, "-----------------------%n");
        for (Income income : declaration.getSortedIncomes()) {
            System.out.println(income);
        }
        System.out.printf(Locale.US, "-----------------------%n");
        System.out.printf(Locale.US, "Total tax to pay: %.2f UAH%n", declaration.getTotalTax());
        System.out.printf(Locale.US, "=======================%n");
    }
}