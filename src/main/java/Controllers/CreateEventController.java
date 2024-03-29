package Controllers;

import Model.EventModel;
import Views.CreateEventView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import Model.User;


public class CreateEventController extends Controller {
    private CreateEventView createEventView;
    public CreateEventController(){
        super("CreateEvent.fxml");
        createEventView = fxmlLoader.getController();
        createEventView.start(new ButtonCreateEvent(), new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                String organization = createEventView.organizations.getItems().get((Integer) number2).toString();
                List<User> organizationUsers = userModel.getAllUsersFromOrganization(organization);
                System.out.println(organization);
                if (organizationUsers!=null) createEventView.setUsersFromOrganization(getOrganizationUsersByName(organizationUsers));
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
        createEventView.setOrganizations(eventModel.getAllOrganization());
        createEventView.setCategories(eventModel.getAllCategories());
        window.setTitle("Create Event");
        window.show();
    }


    public class ButtonCreateEvent implements EventHandler {
        @Override
        public void handle(Event event) {
            List<String>allCategories = new ArrayList<>();
            for (int i=0; i<createEventView.selectedItems.getItems().size(); i++){
                allCategories.add(createEventView.selectedItems.getItems().get(i));
            }

            if (createEventView.isAllFieldsFull()){
                eventModel.makeNewEvent(new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z").format(Calendar.getInstance().getTime()),
                        createEventView.title.getText(),
                        createEventView.firstUpdate.getText(),
                        "open",
                        createEventView.organizations.getValue().toString(),
                        createEventView.users.getValue().toString(),
                        allCategories);
                window.close();
                mainController.goBackToPreviousController();
            }
            else{
                alert("all fields are required");
            }

        }
    }








}
