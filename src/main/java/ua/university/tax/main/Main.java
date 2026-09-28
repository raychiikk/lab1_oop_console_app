package ua.university.tax.main;

import ua.university.tax.model.*;
import ua.university.tax.service.TaxCalculator;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // ініціалізація даних 
        List<Income> personIncomes = Arrays.asList(
            new EmploymentIncome("Primary Job", 150000, 2, 2000),
            new EmploymentIncome("Additional Job", 40000, 0, 0),
            new StandardRateIncome("Royalties", 12000, 0.05),
            new StandardRateIncome("Property Sale", 300000, 0.05),
            new StandardRateIncome("Foreign Transfer", 50000, 0.18),
            new StandardRateIncome("Cash Gift", 10000, 0.05),
            new MaterialAidIncome("Financial Aid", 5000, 3000)
        );

        TaxCalculator calculator = new TaxCalculator();
        double totalTax = calculator.calculateTotalTax(personIncomes);
        List<Income> sortedIncomes = calculator.sortTaxesByAmount(personIncomes);

        System.out.println("All tax payments (sorted by tax amount)");
        for (Income income : sortedIncomes) {
            System.out.println(income);
        }

        System.out.printf("\nTotal tax to pay for the year: %.2f UAH\n", totalTax);
    }
}
