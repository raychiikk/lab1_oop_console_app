package ua.university.tax.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a taxpayer physical person.
 */
public class Taxpayer {
    private String name;
    private int childrenCount;
    private List<Income> incomes;
    private boolean primaryBenefitApplied = false;

    public Taxpayer(String name, int childrenCount) {
        if (childrenCount < 0) {
            throw new IllegalArgumentException("Children count cannot be negative");
        }
        this.name = name;
        this.childrenCount = childrenCount;
        this.incomes = new ArrayList<>();
    }

    /**
     * Adds employment income and applies benefits only for the first primary job.
     */
    public void addEmploymentIncome(String description, double amount, boolean isPrimary) {
        int benefits = 0;
        if (isPrimary && !primaryBenefitApplied) {
            benefits = this.childrenCount;
            this.primaryBenefitApplied = true;
        }
        incomes.add(new EmploymentIncome(description, amount, benefits));
    }

    public void addIncome(Income income) {
        if (income == null) {
            throw new IllegalArgumentException("Income cannot be null");
        }
        incomes.add(income);
    }

    public String getName() { 
        return name; 
    }
    
    public int getChildrenCount() { 
        return childrenCount; 
    }
    
    public List<Income> getIncomes() { 
        return Collections.unmodifiableList(incomes); 
    }
}
