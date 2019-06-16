package sample;

import Model.EventModel;
import javafx.application.Application;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        MainController.getInstance();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
