package ua.university.tax.model;

/**
 * Дохід від продажу майна, авторських винагород, переказів тощо (фіксована ставка).
 */
public class StandardRateIncome extends Income {
    private double taxRate;

    public StandardRateIncome(String description, double amount, double taxRate) {
        super(description, amount);
        this.taxRate = taxRate;
    }

    @Override
    public double calculateTax() {
        return getAmount() * taxRate;
    }
}