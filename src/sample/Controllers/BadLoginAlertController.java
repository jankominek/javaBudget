package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class BadLoginAlertController {
    @FXML
    Button okButton;

    public void backToLoginForm() throws IOException {
        Parent loginFieldRoot = FXMLLoader.load(getClass().getResource("../resources/loginForm.fxml"));
        Stage window = (Stage) okButton.getScene().getWindow();
        window.setScene(new Scene(loginFieldRoot));
    }
}
