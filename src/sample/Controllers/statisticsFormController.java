package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.Habitant;
import sample.ObjectToAdd;

import java.util.List;

public class statisticsFormController {

    @FXML
    Button showdataBtn;

    Habitant habitant = new Habitant();

    public void showData() throws Exception{
        System.out.println("show button");
        habitant.createList();
        habitant.getList();
//        Parent showdataRoot = FXMLLoader.load(getClass().getResource("../resources/statisticsForm.fxml"));
//
//        Stage window = (Stage) showdataBtn.getScene().getWindow();
//        window.setScene(new Scene(showdataRoot));
    }
}
