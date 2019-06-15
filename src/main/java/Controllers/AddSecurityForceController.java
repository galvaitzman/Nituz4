package Controllers;

import Model.User;
import Views.AddSecurityForceView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;

import java.text.SimpleDateFormat;
import java.util.*;


public class AddSecurityForceController extends Controller {
    private AddSecurityForceView addSecurityForceView;
    private Map<Integer, String> eventsIDandTitle = new HashMap<>();
    private int chosenEventID;
    public AddSecurityForceController(){
        super("AddSecurityForce.fxml");
        addSecurityForceView = fxmlLoader.getController();
        addSecurityForceView.start(new ButtonAddSecurityForce(), new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                int index = (Integer) number2;
                chosenEventID = Integer.parseInt(eventsIDandTitle.get(index));
                List<String> allOrganizations = eventModel.getSecurityForceToAdd(chosenEventID);
                if (allOrganizations != null){
                    addSecurityForceView.setOrganizations(allOrganizations);
                }
                else{
                    alert("all Security Forces are in this event. please choose another event");
                    addSecurityForceView.setOrganizations(new ArrayList<>());
                    addSecurityForceView.setUsersFromOrganization(new ArrayList<>());
                }

            }
        }
        ,new ChangeListener<Number>(){

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if ((Integer)newValue != -1){
                    String organization = addSecurityForceView.organizations.getItems().get((Integer) newValue).toString();
                    List<User> organizationUsers = userModel.getAllUsersFromOrganization(organization);
                    System.out.println(organization);
                    if (organizationUsers!=null) addSecurityForceView.setUsersFromOrganization(getOrganizationUsersByName(organizationUsers));
                }
                else {
                    addSecurityForceView.setUsersFromOrganization(new ArrayList<>());
                }

            }
        });
    }

    private List<String> getOrganizationUsersByName(List<User>organizationUsers ){
        List<String> organizationUsersByName = new ArrayList<>();
        for (int i=0; i<organizationUsers.size(); i++){
            organizationUsersByName.add(organizationUsers.get(i).getuserName());
        }
        return organizationUsersByName;
    }

    @Override
    public void start() {
        setEvents();
        window.setTitle("Add Security Force");
        window.show();
    }

    public void setEvents(){
        List<String > allEvents = eventModel.getAllEvents();
        if (allEvents != null){
            List<String> onlyTitles = new ArrayList<>();
            int currentKey = 0;
            for (int i=0; i<allEvents.size(); i+=2){
                onlyTitles.add(allEvents.get(i+1));
                eventsIDandTitle.put(currentKey,allEvents.get(i));
                currentKey++;
            }
            addSecurityForceView.setEvents(onlyTitles);
            window.setTitle("Add update");
            window.show();
        }
        else{
            alert("no available events");
            mainController.goBackToPreviousController();
        }
    }


    public class ButtonAddSecurityForce implements EventHandler {
        @Override
        public void handle(Event event) {
            if (addSecurityForceView.isAllFieldsFull()){
                eventModel.makeNewEventAlarm(chosenEventID,
                        addSecurityForceView.organizations.getValue().toString(),
                        addSecurityForceView.users.getValue().toString(),
                        addSecurityForceView.firstUpdate.getText());
                window.close();
                mainController.goBackToPreviousController();
            }
            else{
                alert("all fields are required");
            }

        }
    }
}
