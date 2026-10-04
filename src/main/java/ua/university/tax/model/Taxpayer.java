package ua.university.tax.model;

import java.util.ArrayList;
import java.util.List;

public class Taxpayer {
    private String name;
    private int childrenCount;
    private List<Income> incomes;

    public Taxpayer(String name, int childrenCount) {
        this.name = name;
        this.childrenCount = childrenCount;
        this.incomes = new ArrayList<>();
    }

    public void addIncome(Income income) {
        incomes.add(income);
    }

    public String getName() { return name; }
    public int getChildrenCount() { return childrenCount; }
    public List<Income> getIncomes() { return incomes; }
}
