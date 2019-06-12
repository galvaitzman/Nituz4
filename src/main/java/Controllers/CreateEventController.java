package Controllers;

import Views.CreateEventView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;

import java.util.ArrayList;
import java.util.List;
import Model.User;


public class CreateEventController extends Controller {
    private CreateEventView createEventView;
    public CreateEventController(){
        super("CreateVacation.fxml");
        createEventView = fxmlLoader.getController();
        createEventView.start(new ButtonCreateEvent(), new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                String organization = createEventView.organizations.getItems().get((Integer) number2).toString();
                List<User> organizationUsers = userModel.getAllUsersFromOrganization(organization);
                System.out.println(organization);
                createEventView.setUsersFromOrganization(getOrganizationUsersByName(organizationUsers));
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
            window.close();
            mainController.goBackToPreviousController();
        }
    }








}
