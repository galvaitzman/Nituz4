package Views;

import Controllers.AddUpdateController;
import Controllers.ButtonBack;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;

public class AddUpdateView extends AView{
    @FXML
    public ChoiceBox events;
    public Button back;
    public TextArea update;
    public Button addUpdate;



    public void start(AddUpdateController.ButtonAddUpdate  buttonCreateEvent) {
        addUpdate.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, buttonCreateEvent);
        back.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,new ButtonBack());
    }

    public void setEvents(List<String> allOrganizations){
        ObservableList<String> organizationsList = FXCollections.observableArrayList();
        events.setItems(organizationsList);
        for(int i=0; i<allOrganizations.size();i++){
            if (!allOrganizations.get(i).equals("DISPACH")) {
                organizationsList.add(allOrganizations.get(i));
            }
        }
    }






    public boolean isAllFieldsFull() {

        if (update.getText().equals("") || events.getValue()==null) {
            alert("all fields are required");
            return false;
        }
        return true;
    }


}
