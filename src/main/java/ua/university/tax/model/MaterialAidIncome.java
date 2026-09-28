package ua.university.tax.model;

/**
 * Матеріальна допомога (не оподатковується до певної суми).
 */
public class MaterialAidIncome extends Income {
    private static final double TAX_RATE = 0.18;
    private double taxFreeLimit;

    public MaterialAidIncome(String description, double amount, double taxFreeLimit) {
        super(description, amount);
        this.taxFreeLimit = taxFreeLimit;
    }

    @Override
    public double calculateTax() {
        double taxableBase = getAmount() - taxFreeLimit;
        return taxableBase > 0 ? taxableBase * TAX_RATE : 0.0;
    }
}
