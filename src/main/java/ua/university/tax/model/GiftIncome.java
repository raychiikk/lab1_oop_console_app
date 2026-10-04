package ua.university.tax.model;

/**
 * дохід, отриманий як подарунок (cash or property)
 */
public class GiftIncome extends StandardRateIncome {
    private GiftType giftType;

    public GiftIncome(String description, double amount, GiftType giftType, double taxRate) {
        super(description, amount, taxRate);
        this.giftType = giftType;
    }

    public GiftType getGiftType() {
        return giftType;
    }
}
