package Views;

import Controllers.AddSecurityForceController;
import Controllers.ButtonBack;
import Controllers.CreateEventController;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;

public class AddSecurityForceView {
    @FXML
    public ChoiceBox organizations;
    public ChoiceBox users;
    public ChoiceBox events;
    public Button back;
    public Button addSecurityForce;
    public TextArea firstUpdate;


    public void start(
            AddSecurityForceController.ButtonAddSecurityForce buttonAddSecurityForce,
            ChangeListener changeListenerForEvents,
            ChangeListener changeListenerForOrganization) {
        events.getSelectionModel().selectedIndexProperty().addListener(changeListenerForEvents);
        organizations.getSelectionModel().selectedIndexProperty().addListener(changeListenerForOrganization);
        addSecurityForce.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, buttonAddSecurityForce);
        back.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,new ButtonBack());
    }

    public void setEvents(List<String> allEvents){
        ObservableList<String> eventsList = FXCollections.observableArrayList();
        events.setItems(eventsList);
        for(int i=0; i<allEvents.size();i++){
            eventsList.add(allEvents.get(i));
        }
    }

    public void setOrganizations(List<String> allOrganizations){
        ObservableList<String> organizationsList = FXCollections.observableArrayList();
        organizations.setItems(organizationsList);
        for(int i=0; i<allOrganizations.size();i++){
            organizationsList.add(allOrganizations.get(i));
        }
    }

    public void setUsersFromOrganization(List<String> organizationUsersByName){
        ObservableList<String> usersList = FXCollections.observableArrayList();
        users.setItems(usersList);
        for (int i=0; i<organizationUsersByName.size(); i++){
            usersList.add(organizationUsersByName.get(i));
        }
    }



    public boolean isAllFieldsFull() {

        if (events.getValue() == null ||
                users.getValue() == null ||
                organizations.getValue()==null ||
                firstUpdate.getText().equals("")) {
            return false;
        }
        return true;
    }


}
