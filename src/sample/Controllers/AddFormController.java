package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.model.Habitant;
import sample.model.Model;
import sample.model.ObjectToAdd;

import java.net.URL;
import java.util.ResourceBundle;

public class AddFormController {

    @FXML Button addBtn, backBtn;
    @FXML TextField day, month, year, income, expense;

    public void add() throws Exception{
        System.out.println("add button");
        ObjectToAdd obj = new ObjectToAdd(
                Integer.parseInt(day.getText()),
                Integer.parseInt(month.getText()),
                Integer.parseInt(year.getText()),
                Integer.parseInt(income.getText()),
                Integer.parseInt(expense.getText()));
        Model.getInstance().addObjectToList(obj);

    }

    public void back() throws Exception {
        BackToMainWindowController backToMainWindowController = new BackToMainWindowController();
        backToMainWindowController.backToMainWindow(backBtn);
    }


}
