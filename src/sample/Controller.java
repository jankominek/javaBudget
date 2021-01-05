package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class Controller {
    @FXML
    Button loginBtn, registerBtn;

    public void pressLoginBtn(ActionEvent event) throws Exception{
        System.out.println("clicked log in!");
        Parent loginFormRoot = FXMLLoader.load(getClass().getResource("resources/loginForm.fxml"));

        Stage window = (Stage) loginBtn.getScene().getWindow();
        window.setScene(new Scene(loginFormRoot));
    }
    public void pressRegisterBtn(ActionEvent event) throws Exception{
        System.out.println("clicked register!");
        Parent registerFormRoot = FXMLLoader.load(getClass().getResource("resources/registerForm.fxml"));

        Stage window = (Stage) registerBtn.getScene().getWindow();
        window.setScene(new Scene(registerFormRoot));
    }
    public void pressBtn(ActionEvent event){
        System.out.println("btn pressed!");
    }
    public void checkedBox(ActionEvent event){
        System.out.println("box checked");
    }
}

