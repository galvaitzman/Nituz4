package sample;
import Controllers.*;
import Model.EventModel;

import java.util.List;
import java.util.Stack;


public class MainController {
    Controller initialController = new InitialController();
    Controller currentController = initialController;
    Controller signInSuccessfulyController = new SignInSuccessfulyController();
    Controller createEventController = new CreateEventController();
    Controller addUpdateController = new AddUpdateController();
    Controller addSecurityForceController = new AddSecurityForceController();
    Stack<Controller> controllers = new Stack<Controller>();


    private static MainController mainController=null;

    public static MainController getInstance(){
        if (mainController == null){
            mainController = new MainController();
        }
        return mainController;
    }

    private MainController () {
        Controller.setMainController(this);
        Controller.setMainUserModel();
        Controller.setMainEventModel();
        ButtonBack.setMainConroller(this);
        initialController.start();
    }

    public void activeSignInSuccessfuly(){
        controllers.push(currentController);
        currentController = signInSuccessfulyController;
        currentController.start();
    }

    public void activateCreateEvent() {
        controllers.push(currentController);
        currentController = createEventController;
        currentController.start();
    }

    public void activeAddUpdate(){
        controllers.push(currentController);
        currentController = addUpdateController;
        currentController.start();
    }

    public void activateAddSecurityForce(){
        controllers.push(currentController);
        currentController = addSecurityForceController;
        currentController.start();
    }

    public void closeWindow(){
        currentController.window.close();
    }
    public void goBackToPreviousController(){
        currentController = controllers.pop();
        currentController.start();
    }
}
