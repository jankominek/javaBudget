package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.model.Habitant;
import sample.model.Model;

import java.io.IOException;

public class MainWindowController {

    @FXML
    Button statisticsBtn, addBtn, generateDataBtn, tableBtn;


    public void showStatisticsField(ActionEvent event) throws Exception{

        Model.getInstance().readDataFromFile();
        //Model.getInstance().getList();

        Parent statisticsRoot = FXMLLoader.load(getClass().getResource("../resources/statisticsForm.fxml"));
        Stage window = (Stage) statisticsBtn.getScene().getWindow();
        window.setScene(new Scene(statisticsRoot));
    }
    public void showTable() throws IOException {
        Parent tableViewRoot = FXMLLoader.load(getClass().getResource("../resources/databaseTableWindow.fxml"));
        Stage window = (Stage) tableBtn.getScene().getWindow();
        window.setScene(new Scene(tableViewRoot));
    }
    public void showAddField(ActionEvent event) throws Exception{
        Parent addRoot = FXMLLoader.load(getClass().getResource("../resources/addForm.fxml"));

        Stage window = (Stage) addBtn.getScene().getWindow();
        window.setScene(new Scene(addRoot));
    }

    public void showGenerateField(ActionEvent event) throws Exception{
        Parent generateRoot = FXMLLoader.load(getClass().getResource("../resources/generateData.fxml"));
        Stage window = (Stage) generateDataBtn.getScene().getWindow();
        window.setScene(new Scene(generateRoot));
    }

}
