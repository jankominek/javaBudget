package sample.helpers;

public class TableViewObject {

    private String date;
    private int income;
    private int expense;
    private String dateAdded;

    public TableViewObject(String date, int income, int expense, String dateAdded) {
        this.date = date;
        this.income = income;
        this.expense = expense;
        this.dateAdded = dateAdded;
    }

    public TableViewObject() {

    }

    public String getDateAdded() {
        return dateAdded;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getExpense() {
        return expense;
    }

    public void setExpense(int expense) {
        this.expense = expense;
    }
}
