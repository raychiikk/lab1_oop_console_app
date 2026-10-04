package ua.university.tax.model;

/**
 * дохід з основного або додаткового місця роботи з урахуванням пільг на дітей
 */
public class EmploymentIncome extends Income {
    private int appliedChildrenBenefits;

    public EmploymentIncome(String description, double amount, int appliedChildrenBenefits) {
        super(description, amount);
        this.appliedChildrenBenefits = appliedChildrenBenefits;
    }

@Override
    public double calculateTax() {
              // віднімаємо пільги на дітей від бази оподаткування
        double taxableBase = getAmount() - (appliedChildrenBenefits * TaxConstants.CHILD_BENEFIT_AMOUNT);
        return Math.max(0, taxableBase) * TaxConstants.BASE_TAX_RATE;
    }
}
