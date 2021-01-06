package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainWindowController {

    @FXML
    Button statisticsBtn, addBtn;

    public void showStatisticsField(ActionEvent event) throws Exception{
        Parent statisticsRoot = FXMLLoader.load(getClass().getResource("../resources/statisticsForm.fxml"));

        Stage window = (Stage) statisticsBtn.getScene().getWindow();
        window.setScene(new Scene(statisticsRoot));
    }
    public void showAddField(ActionEvent event) throws Exception{
        Parent addRoot = FXMLLoader.load(getClass().getResource("../resources/addForm.fxml"));

        Stage window = (Stage) addBtn.getScene().getWindow();
        window.setScene(new Scene(addRoot));
    }

}
