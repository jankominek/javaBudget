package sample.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Habitant;

public class GenerateDataController {

    Habitant habitant = new Habitant();

    @FXML TextField dataRangeBtn, yearRangeBtn, incomeRangeBtn, expenseRangeBtn;
    @FXML Button backBtn;


    public void generate() throws Exception{
        System.out.println("generate button");

        habitant.createExampleData(
                Integer.parseInt(dataRangeBtn.getText()),
                Integer.parseInt(yearRangeBtn.getText()),
                Integer.parseInt(incomeRangeBtn.getText()),
                Integer.parseInt(expenseRangeBtn.getText())
        );

    }
    public void back() throws Exception {
        BackToMainWindowController backToMainWindowController = new BackToMainWindowController();
        backToMainWindowController.backToMainWindow(backBtn);
    }
}
