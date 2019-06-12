package Controllers;

import Model.User;
import Views.AddUpdateView;
import Views.CreateEventView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class AddUpdateController extends Controller {
    private AddUpdateView addUpdateView;
    public AddUpdateController(){
        super("AddUpdate.fxml");
        addUpdateView = fxmlLoader.getController();
    }

    @Override
    public void start() {
        window.setTitle("Add update");
        window.show();
    }


    public class ButtonAddUpdate implements EventHandler {
        @Override
        public void handle(Event event) {

            if (addUpdateView.isAllFieldsFull()){

                window.close();
                mainController.goBackToPreviousController();
            }

        }
    }








}
