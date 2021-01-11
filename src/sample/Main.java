package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.model.Model;
import sample.model.ObjectToAdd;

import java.io.IOException;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Hello World");
        initApp();
        Parent mainWindowRoot = FXMLLoader.load(getClass().getResource("resources/startWindow.fxml"));
        Scene mainWindow = new Scene(mainWindowRoot);
        primaryStage.setScene(mainWindow);
        primaryStage.show();
    }

    private void initApp() throws IOException {
        Model.getInstance().readDataFromFile();
    }


    public static void main(String[] args) throws ParseException {

        launch(args);



    }

}
