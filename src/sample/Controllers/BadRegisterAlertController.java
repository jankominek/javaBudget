package sample.Controllers;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class BadRegisterAlertController {
    @FXML
    Button okButton;

    public void backToRegisterForm(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent registerFieldRoot = FXMLLoader.load(getClass().getResource("../resources/registerForm.fxml"));
        Stage window = (Stage) okButton.getScene().getWindow();
        window.setScene(new Scene(registerFieldRoot));
    }
}
