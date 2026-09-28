package ua.university.tax.model;

/**
 * Базовий абстрактний клас для будь-якого виду доходу.
 */
public abstract class Income {
    private String description;
    private double amount;

    public Income(String description, double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Income amount cannot be negative");
        }
        this.description = description;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    /**
     * Поліморфний метод для розрахунку податку.
     */
    public abstract double calculateTax();

    @Override
    public String toString() {
        return String.format("%s: Income = %.2f, Tax = %.2f", 
                description, amount, calculateTax());
    }
}
