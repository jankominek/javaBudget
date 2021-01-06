package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BackToMainWindowController {
    @FXML Button backBtn;
    public void backToMainWindow(Button backBtn) throws Exception{

        Parent mainWindowRoot = FXMLLoader.load(getClass().getResource("../resources/mainWindow.fxml"));
        Stage window = (Stage) backBtn.getScene().getWindow();
        window.setScene(new Scene(mainWindowRoot));
    }
}
