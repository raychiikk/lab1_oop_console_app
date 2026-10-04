package ua.university.tax.service;

import ua.university.tax.model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Service for reading taxpayer data from a CSV file.
 */
public class DataReader {

    public static Taxpayer loadTaxpayerData(String filePath) throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath), StandardCharsets.UTF_8)) {
            String firstLine = reader.readLine();
            if (firstLine == null || firstLine.trim().isEmpty()) {
                throw new IllegalArgumentException("File is empty");
            }
            
            String[] taxpayerInfo = firstLine.split(";");
            Taxpayer taxpayer = new Taxpayer(taxpayerInfo[0], Integer.parseInt(taxpayerInfo[1]));

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                
                String[] parts = line.split(";");
                if (parts.length < 3) {
                    throw new IllegalArgumentException("Invalid line format: " + line);
                }
                
                String type = parts[0];
                String desc = parts[1];
                double amount = Double.parseDouble(parts[2]);

                switch (type) {
                    case "EMPLOYMENT":
                        boolean isPrimary = Boolean.parseBoolean(parts[3]);
                        taxpayer.addEmploymentIncome(desc, amount, isPrimary);
                        break;
                    case "GIFT":
                        GiftType giftType = GiftType.valueOf(parts[3].toUpperCase());
                        taxpayer.addIncome(new GiftIncome(desc, amount, giftType, Double.parseDouble(parts[4])));
                        break;
                    case "STANDARD":
                        taxpayer.addIncome(new StandardRateIncome(desc, amount, Double.parseDouble(parts[3])));
                        break;
                    case "AID":
                        taxpayer.addIncome(new MaterialAidIncome(desc, amount, Double.parseDouble(parts[3])));
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown income type: " + type);
                }
            }
            return taxpayer;
        }
    }
}