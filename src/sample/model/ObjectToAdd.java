package sample.model;

import javafx.scene.chart.LineChart;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ObjectToAdd {

    private int day;
    private int month;
    private int year;
    private int income;
    private int expense;
    private String dateAdded;

    public ObjectToAdd(int day, int month, int year, int income, int expense){
        this.day = day;
        this.month = month;
        this.year = year;
        this.income = income;
        this.expense = expense;
        this.dateAdded = getCurrentDate();
    }


    public String getCurrentDate(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD");
        String date = simpleDateFormat.format(new Date());
        return date;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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
