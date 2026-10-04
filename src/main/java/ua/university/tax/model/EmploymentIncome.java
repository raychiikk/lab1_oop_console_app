package ua.university.tax.model;

/**
 * дохід від трудової діяльності з урахуванням допомоги на дітей
 */
public class EmploymentIncome extends Income {
    private int appliedChildrenBenefits;

    public EmploymentIncome(String description, double amount, int appliedChildrenBenefits) {
        super(description, amount);
        this.appliedChildrenBenefits = appliedChildrenBenefits;
    }

    @Override
    public double calculateTax() {
        double taxableBase = getAmount() - (appliedChildrenBenefits * TaxConstants.CHILD_BENEFIT_AMOUNT);
        return Math.max(0, taxableBase) * TaxConstants.BASE_TAX_RATE;
    }
}
