package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.model.Database;
import sample.model.Model;

import java.io.IOException;

public class registerFormController {
    @FXML TextField usernameField, passwordField;
    @FXML Button registerBtn;

    public void register(ActionEvent actionEvent) throws IOException {

        Model.getInstance().modelRegister(usernameField.getText(), passwordField.getText(), null);
    }
}
