package Controllers;

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
                else{
                    List<String> organizationUsersByName = new ArrayList<>();
                    organizationUsersByName.add("Mor");
                    organizationUsersByName.add("Goni");
                    organizationUsersByName.add("Itay");
                    organizationUsersByName.add("Gal");
                    createEventView.setUsersFromOrganization(organizationUsersByName);
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
        window.setTitle("Create Vacation");
        window.show();
    }


    public class ButtonCreateEvent implements EventHandler {
        @Override
        public void handle(Event event) {
            for (int i=0; i<createEventView.selectedItems.getItems().size(); i++){
                System.out.println(createEventView.selectedItems.getItems().get(i));
            }
            if (createEventView.isAllFieldsFull()){
                eventModel.insertEventToDB(createEventView.title.getText(),
                        new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()).toString(),
                        createEventView.firstUpdate.getText(),
                        "open",
                        "",
                        createEventView.selectedItems.getItems());
                window.close();
                mainController.goBackToPreviousController();
            }

        }
    }








}
