package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class StartWindowController {

    @FXML Button loginBtn, registerBtn;

    public void pressLoginBtn(ActionEvent actionEvent) throws IOException {
        Parent loginFieldRoot = FXMLLoader.load(getClass().getResource("../resources/loginForm.fxml"));
        Stage window = (Stage) loginBtn.getScene().getWindow();
        window.setScene(new Scene(loginFieldRoot));
    }

    public void pressRegisterBtn(ActionEvent actionEvent) throws IOException {
        Parent registerFieldRoot = FXMLLoader.load(getClass().getResource("../resources/registerForm.fxml"));
        Stage window = (Stage) loginBtn.getScene().getWindow();
        window.setScene(new Scene(registerFieldRoot));
    }
}
