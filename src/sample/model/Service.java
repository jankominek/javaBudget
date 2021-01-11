package sample.model;

import javax.swing.*;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Service {
    Map<String, ObjectToAdd> generalList = Model.getInstance().getCurrentUserList();

    SimpleDateFormat toDate = new SimpleDateFormat("yyyy-MM-dd");
    Format dayFormater = new SimpleDateFormat("dd");
    Format monthFormater = new SimpleDateFormat("MM");
    Format yearFormater = new SimpleDateFormat("yyyy");

    public Map<String, ObjectToAdd> getGeneralData(){
        return generalList;
    }
    public List<ObjectToAdd> getMonthList(Integer month, Integer year) throws ParseException {
        List<ObjectToAdd> monthList = new ArrayList<>();
        for(Map.Entry<String, ObjectToAdd> map : generalList.entrySet()){
            if(findYear(map.getKey()).equals(year) && findMonth(map.getKey()).equals(month)){
                monthList.add(map.getValue());
            }
        }
//        for(ObjectToAdd objectToAdd : monthList){
//            System.out.println("year: " + objectToAdd.getYear() + "  " + "month : " +objectToAdd.getMonth() + "  " + "day : " + objectToAdd.getDay());
//            System.out.println("income : " + objectToAdd.getIncome());
//        }
        return monthList;
    }
    public List<ObjectToAdd> getYearList(Integer year) throws ParseException {
        List<ObjectToAdd> yearList = new ArrayList<>();
        for(Map.Entry<String, ObjectToAdd> map : generalList.entrySet()){
            if(findYear(map.getKey()).equals(year)){
                yearList.add(map.getValue());
            }
        }
        System.out.println("yearList size : " + yearList.size());
        return yearList;
    }
    
    public Integer getTotalMonthIncome(Integer month, Integer year) throws ParseException {
        Integer totalIncome = 0;
        for(ObjectToAdd objectToAdd : this.getMonthList(month, year)){
            totalIncome += objectToAdd.getIncome();
        }
        System.out.println("totalIncome"+totalIncome);
        return totalIncome;
    }
    public Integer getTotalMonthExpense(Integer month, Integer year) throws ParseException {
        Integer totalExpense = 0;
        for(ObjectToAdd objectToAdd : this.getMonthList(month, year)){
            totalExpense += objectToAdd.getExpense();
        }
        System.out.println("totalExpense"+totalExpense);
        return totalExpense;
    }
    public Integer getTotalYearIncome(Integer year) throws ParseException {
        Integer totalYearIncome = 0;
        for(ObjectToAdd objectToAdd : this.getYearList(year)){
            totalYearIncome += objectToAdd.getIncome();
        }
        System.out.println("totalYearIncome : " + totalYearIncome);
        return totalYearIncome;
    }

    public Integer getTotalYearExpense(Integer year) throws ParseException {
        Integer totalYearExpense = 0;
        for(ObjectToAdd objectToAdd : this.getYearList(year)){
            totalYearExpense += objectToAdd.getExpense();
        }
        System.out.println("totalYearExpense : " + totalYearExpense);
        return totalYearExpense;
    }

    public Integer findDay(String date) throws ParseException {
        Date newDate = toDate.parse(date);
        Integer day = Integer.parseInt(yearFormater.format(newDate));
        return day;
    }
    public Integer findMonth(String date) throws ParseException {
        Date newDate = toDate.parse(date);
        Integer month = Integer.parseInt(monthFormater.format(newDate));
        return month;
    }
    public Integer findYear(String date) throws ParseException {
        Date newDate = toDate.parse(date);
        Integer year = Integer.parseInt(yearFormater.format(newDate));
        return year;
    }
}
