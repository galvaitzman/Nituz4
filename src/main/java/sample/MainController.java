package sample;
import Controllers.*;

import java.util.Stack;


public class MainController {
    Controller initialController = new InitialController();
    Controller currentController = initialController;
    Controller signInSuccessfulyController = new SignInSuccessfulyController();
    Controller createEventController = new CreateEventController();
    //Controller addUpdateController = new AddUpdateController();
    //Controller addSecurityForceController = new AddSecurityForce();
    Stack<Controller> controllers = new Stack<Controller>();
    public MainController () {
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
        //currentController = addUpdateController;
        currentController.start();
    }

    public void activateAddSecurityForce(){
        controllers.push(currentController);
        //currentController = addSecurityForceController;
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
