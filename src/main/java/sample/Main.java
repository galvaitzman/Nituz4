package sample;

import javafx.application.Application;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        new MainController();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
