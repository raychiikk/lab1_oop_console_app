package ua.university.tax.model;

public class GiftIncome extends Income {
    private String giftType; // "cash" or "property"
    private double taxRate;

    public GiftIncome(String description, double amount, String giftType, double taxRate) {
        super(description, amount);
        this.giftType = giftType;
        this.taxRate = taxRate;
    }

    public String getGiftType() {
        return giftType;
    }

    @Override
    public double calculateTax() {
        return getAmount() * taxRate;
    }
}
