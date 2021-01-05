package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Hello World");
        Parent mainWindowRoot = FXMLLoader.load(getClass().getResource("resources/mainWindow.fxml"));
        Scene mainWindow = new Scene(mainWindowRoot);



        //Parent startWindowRoot = FXMLLoader.load(getClass().getResource("resources/startWindow.fxml"));
        //Scene startWindow = new Scene(startWindowRoot);

        primaryStage.setScene(mainWindow);
        primaryStage.show();
    }


    public static void main(String[] args) {

        launch(args);
        Habitant habitant = new Habitant("A", "B", 20, 'C');


    }
}
