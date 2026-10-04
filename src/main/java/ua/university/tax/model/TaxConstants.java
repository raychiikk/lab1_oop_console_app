package ua.university.tax.model;

/**
 * константи для розрахунку податків
 */
public final class TaxConstants {
    private TaxConstants() {
        // приватний конструктор для запобігання створенню екземплярів
    }
    
    public static final double BASE_TAX_RATE = 0.18; //18%
    public static final double CHILD_BENEFIT_AMOUNT = 2000.0;
}
