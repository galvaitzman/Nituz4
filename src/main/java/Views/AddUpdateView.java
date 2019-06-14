package Views;

import Controllers.AddUpdateController;
import Controllers.ButtonBack;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;

public class AddUpdateView {
    @FXML
    public ChoiceBox events;
    public Button back;
    public TextArea update;
    public Button addUpdate;



    public void start(AddUpdateController.ButtonAddUpdate  buttonAddUpdate) {
        addUpdate.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, buttonAddUpdate);
        back.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,new ButtonBack());
    }

    public void setEvents(List<String> allEvents){
        ObservableList<String> eventsList = FXCollections.observableArrayList();
        events.setItems(eventsList);
        for(int i=0; i<allEvents.size();i++){
            eventsList.add(allEvents.get(i));
        }
    }






    public boolean isAllFieldsFull() {

        if (update.getText().equals("") || events.getValue()==null) {
            return false;
        }
        return true;
    }


}
