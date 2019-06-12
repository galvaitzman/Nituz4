package Views;

import Controllers.ButtonBack;
import Controllers.SignInSuccessfulyController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SignInSuccessfulyView{

    @FXML
    public Button createEvent;
    public Button addUpdate;
    public Button addSecurityForce;




    public void start(SignInSuccessfulyController.ButtonCreateEvent buttonCreateEvent,
                      SignInSuccessfulyController.ButtonAddUpdate buttonAddUpdate,
                      SignInSuccessfulyController.ButtonAddSecurityForce buttonAddSecurityForce){
        createEvent.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,buttonCreateEvent);
        addUpdate.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,buttonAddUpdate);
        addSecurityForce.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,buttonAddSecurityForce);
//        approvalButton.setVisible(false);
//        requestButton.setVisible(false);
//        moneyRecievedButton.setVisible(false);

    }
}
