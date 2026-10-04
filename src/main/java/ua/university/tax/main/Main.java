package ua.university.tax.main;

import ua.university.tax.model.TaxDeclaration;
import ua.university.tax.model.Taxpayer;
import ua.university.tax.service.DataReader;
import ua.university.tax.service.TaxCalculator;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            // читання параметрів ініціалізації з файлу (вимога 7)
            Taxpayer taxpayer = DataReader.loadTaxpayerData("incomes.csv");
            
            TaxCalculator calculator = new TaxCalculator();
            TaxDeclaration declaration = calculator.createDeclaration(taxpayer);
            
            declaration.printDeclaration();
            
        } catch (IOException e) {
            System.err.println("Error reading data file: " + e.getMessage());
        }
    }
}