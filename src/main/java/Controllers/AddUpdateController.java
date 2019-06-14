package Controllers;

import Model.User;
import Views.AddUpdateView;
import Views.CreateEventView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;

import java.text.SimpleDateFormat;
import java.util.*;


public class AddUpdateController extends Controller {
    private AddUpdateView addUpdateView;
    Map<Integer, String> eventsIDandTitle = new HashMap<>();

    public AddUpdateController(){
        super("AddUpdate.fxml");
        addUpdateView = fxmlLoader.getController();
        addUpdateView.start(new ButtonAddUpdate());
    }

    @Override
    public void start() {
        List<String > allEvents = eventModel.getAllEvents();
        if (allEvents != null){
            List<String> onlyTitles = new ArrayList<>();
            int currentKey = 0;
            for (int i=0; i<allEvents.size(); i+=2){
                onlyTitles.add(allEvents.get(i+1));
                eventsIDandTitle.put(currentKey,allEvents.get(i));
                currentKey++;
            }
            addUpdateView.setEvents(onlyTitles);
            window.setTitle("Add update");
            window.show();
        }
        else{
            alert("no available events");
            mainController.goBackToPreviousController();
        }

    }


    public class ButtonAddUpdate implements EventHandler {
        @Override
        public void handle(Event event) {

            if (addUpdateView.isAllFieldsFull()){
                if (addUpdateView.isAllFieldsFull()){
                    eventModel.insertUpdateToDB(Integer.parseInt(eventsIDandTitle.get(addUpdateView.events.getSelectionModel().getSelectedIndex())),addUpdateView.update.getText(),addUpdateView.update.getText());
                }
                window.close();
                mainController.goBackToPreviousController();
            }
            else{
                alert("all fields are required");
            }

        }
    }








}
