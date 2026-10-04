package ua.university.tax.service;

import ua.university.tax.model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataReader {

    public static Taxpayer loadTaxpayerData(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // перший рядок: ім'я; кількість_дітей
            String[] taxpayerInfo = reader.readLine().split(";");
            Taxpayer taxpayer = new Taxpayer(taxpayerInfo[0], Integer.parseInt(taxpayerInfo[1]));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                String type = parts[0];
                String desc = parts[1];
                double amount = Double.parseDouble(parts[2]);

                switch (type) {
                    case "EMPLOYMENT":
                        boolean isPrimary = Boolean.parseBoolean(parts[3]);
                        // пільга застосовується лише до основного місця роботи
                        int appliedChildren = isPrimary ? taxpayer.getChildrenCount() : 0;
                        taxpayer.addIncome(new EmploymentIncome(desc, amount, appliedChildren));
                        break;
                    case "GIFT":
                        taxpayer.addIncome(new GiftIncome(desc, amount, parts[3], Double.parseDouble(parts[4])));
                        break;
                    case "STANDARD":
                        taxpayer.addIncome(new StandardRateIncome(desc, amount, Double.parseDouble(parts[3])));
                        break;
                    case "AID":
                        taxpayer.addIncome(new MaterialAidIncome(desc, amount, Double.parseDouble(parts[3])));
                        break;
                }
            }
            return taxpayer;
        }
    }
}