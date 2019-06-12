package Controllers;

import javafx.event.Event;
import javafx.event.EventHandler;
import sample.MainController;

public class ButtonBack implements EventHandler {
    private static MainController mainController;
    public static void setMainConroller(MainController other){
        mainController = other;
    }
    @Override
    public void handle(Event event) {
        mainController.closeWindow();//
        mainController.goBackToPreviousController();
    }
}
