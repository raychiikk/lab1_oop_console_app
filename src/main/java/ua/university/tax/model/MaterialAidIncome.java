package ua.university.tax.model;

/**
 * матеріальна допомога (не оподатковується до певної суми)
 */
public class MaterialAidIncome extends Income {
    private double taxFreeLimit;

    public MaterialAidIncome(String description, double amount, double taxFreeLimit) {
        super(description, amount);
        this.taxFreeLimit = taxFreeLimit;
    }

    @Override
    public double calculateTax() {
        double taxableBase = getAmount() - taxFreeLimit;
        return taxableBase > 0 ? taxableBase * TaxConstants.BASE_TAX_RATE : 0.0;
    }
}
