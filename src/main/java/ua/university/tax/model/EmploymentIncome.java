package ua.university.tax.model;

/**
 * Дохід з основного або додаткового місця роботи з урахуванням пільг на дітей.
 */
public class EmploymentIncome extends Income {
    private static final double TAX_RATE = 0.18; // 18% податок
    private int childrenCount;
    private double childBenefitAmount;

    public EmploymentIncome(String description, double amount, int childrenCount, double childBenefitAmount) {
        super(description, amount);
        this.childrenCount = childrenCount;
        this.childBenefitAmount = childBenefitAmount;
    }

    @Override
    public double calculateTax() {
        // Віднімаємо пільги на дітей від бази оподаткування
        double taxableBase = getAmount() - (childrenCount * childBenefitAmount);
        if (taxableBase < 0) {
            taxableBase = 0;
        }
        return taxableBase * TAX_RATE;
    }
}
