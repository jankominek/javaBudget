package sample.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.helpers.CreateExampleData;
import sample.model.Habitant;
import sample.model.Model;

public class GenerateDataController {

    Habitant habitant = new Habitant();

    @FXML TextField dataRangeBtn, yearRangeBtn, incomeRangeBtn, expenseRangeBtn;
    @FXML Button backBtn;


    public void generate() throws Exception{
        System.out.println("generate button");
        CreateExampleData createExampleData = new CreateExampleData();
        createExampleData.createData(
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
