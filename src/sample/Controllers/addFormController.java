package sample.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Habitant;
import sample.ObjectToAdd;

import java.util.List;

public class addFormController {

    @FXML Button addBtn, backBtn;
    @FXML TextField day, month, year, income, expense;

    Habitant habitant = new Habitant();

    public void add() throws Exception{
        System.out.println("add button");
        ObjectToAdd obj = new ObjectToAdd(
                Integer.parseInt(day.getText()),
                Integer.parseInt(month.getText()),
                Integer.parseInt(year.getText()),
                Integer.parseInt(income.getText()),
                Integer.parseInt(expense.getText()));

        habitant.addToList(obj);
    }

    public void back(){

    }
}
