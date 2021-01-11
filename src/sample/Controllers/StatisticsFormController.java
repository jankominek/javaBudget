package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import sample.model.Habitant;
import sample.model.Model;
import sample.model.ObjectToAdd;
import sample.model.Service;

import java.net.ServerSocket;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class StatisticsFormController implements Initializable {

    @FXML
    Button consoleBtn, backBtn;
    @FXML
    LineChart lineChart, monthLineChart;
    @FXML private PieChart pieChart;
    @FXML
    BarChart barChartIncome, barChartExpense;

    Service service = new Service();
    static Integer currentMonth = Model.getInstance().getCurrentMonth();
    static Integer currentYear = Model.getInstance().getCurrentYear();

    public void showConsole() throws Exception{

        Model.getInstance().showCurrentUserList();
        //service.getMonthList(currentMonth, currentYear);
//        List<ObjectToAdd> monthList = new ArrayList<>();
//        int currentMonth  = Model.getInstance().getCurrentMonth();
//        int currentYear  = Model.getInstance().getCurrentYear();
//        monthList = Model.getInstance().getCurrentMonthData(currentMonth, currentYear);
//
//        XYChart.Series series1 = new XYChart.Series();
//        XYChart.Series series2 = new XYChart.Series();
//        for(ObjectToAdd objectToAdd : monthList){
//            series1.getData().add(new XYChart.Data(String.valueOf(objectToAdd.getDay()), objectToAdd.getIncome()));
//            series2.getData().add(new XYChart.Data(String.valueOf(objectToAdd.getDay()), objectToAdd.getExpense()));
//        }
//        monthLineChart.getData().addAll(series1, series2);
//
//        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
//        pieChartData.add(new PieChart.Data("month income", Model.getInstance().getGeneralMonthIncome(currentMonth, currentYear)));
//        pieChartData.add(new PieChart.Data("mobnth expense", Model.getInstance().getGeneralMonthExpense(currentMonth, currentYear)));
//
//        pieChart.setData(pieChartData);



    }
    public void back() throws Exception {
        BackToMainWindowController backToMainWindowController = new BackToMainWindowController();
        backToMainWindowController.backToMainWindow(backBtn);
    }
    public void sort(){
        //Model.getInstance().sortByYearMonth();
    }

    public void createGeneralDataLineChart(){
        Map<String, ObjectToAdd> generalList = service.getGeneralData();
        XYChart.Series series1 = new XYChart.Series();
        XYChart.Series series2 = new XYChart.Series();
        for(Map.Entry<String, ObjectToAdd> map : generalList.entrySet() ){
            series1.getData().add(new XYChart.Data(map.getKey(), map.getValue().getIncome()));
            series2.getData().add(new XYChart.Data(map.getKey(), map.getValue().getIncome()));
        }
        lineChart.getData().addAll(series1, series2);
        lineChart.setCreateSymbols(false);
    }
    public void createMonthDataLineChart() throws ParseException {
        XYChart.Series series1 = new XYChart.Series();
        XYChart.Series series2 = new XYChart.Series();
        for(ObjectToAdd objectToAdd : service.getMonthList(currentMonth, currentYear) ){
            series1.getData().add(new XYChart.Data(String.valueOf(objectToAdd.getDay()), objectToAdd.getIncome()));
            series2.getData().add(new XYChart.Data(String.valueOf(objectToAdd.getDay()), objectToAdd.getExpense()));
        }
        monthLineChart.getData().addAll(series1, series2);
        monthLineChart.setCreateSymbols(false);
    }
    public void createTotalMonthPieChart() throws ParseException {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        pieChartData.add(new PieChart.Data("month income", service.getTotalMonthIncome(currentMonth, currentYear)));
        pieChartData.add(new PieChart.Data("month expense", service.getTotalMonthExpense(currentMonth, currentYear)));

        pieChart.setData(pieChartData);
    }

    public void createFivePrevYearIncomeBarChart() throws ParseException {            //// DO POPRAWY
        List<Integer> incomeEachYearList = new ArrayList<Integer>();
        for(int i = 0; i<5; i++) {
            Integer value = service.getTotalYearIncome(currentYear - i);
            incomeEachYearList.add(value);
        }
        XYChart.Series series1 = new XYChart.Series();
        for(int i = 0; i<incomeEachYearList.size(); i++){
            series1.getData().add(new XYChart.Data(String.valueOf(currentYear - i), incomeEachYearList.get(i)));
        }
        barChartIncome.getData().addAll(series1);
        //monthLineChart.setCreateSymbols(false);
    }

    public void createFivePrevYearExpenseBarChart() throws ParseException {            //// DO POPRAWY
        List<Integer> expenseEachYearList = new ArrayList<Integer>();
        for(int i = 0; i<5; i++) {
            Integer value = service.getTotalYearExpense(currentYear - i);
            expenseEachYearList.add(value);
        }
        XYChart.Series series1 = new XYChart.Series();
        for(int i = 0; i<expenseEachYearList.size(); i++){
            series1.getData().add(new XYChart.Data(String.valueOf(currentYear - i), expenseEachYearList.get(i)));
        }
        barChartExpense.getData().addAll(series1);
        //monthLineChart.setCreateSymbols(false);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            createMonthDataLineChart();
            createGeneralDataLineChart();
            createFivePrevYearIncomeBarChart();
            createFivePrevYearExpenseBarChart();
            createTotalMonthPieChart();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
