package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.model.Database;
import sample.model.Model;

import java.io.IOException;

public class registerFormController {
    @FXML TextField usernameField, passwordField;
    @FXML Button registerBtn;
    @FXML Button backBtn;

    public void backToStartWindow(ActionEvent event) throws IOException {
        Parent startWindowRoot = FXMLLoader.load(getClass().getResource("../resources/startWindow.fxml"));
        Stage window = (Stage) backBtn.getScene().getWindow();
        window.setScene(new Scene(startWindowRoot));
    }

    public void register(ActionEvent actionEvent) throws IOException {

        if(!Model.getInstance().modelRegister(usernameField.getText(), passwordField.getText(), null)){
            Parent registerFieldRoot = FXMLLoader.load(getClass().getResource("../resources/badRegisterAlert.fxml"));
            Stage window = (Stage) registerBtn.getScene().getWindow();
            window.setScene(new Scene(registerFieldRoot));
        }
    }
}
