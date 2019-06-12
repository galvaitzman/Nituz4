package Views;

import javafx.scene.control.Alert;

public abstract class AView {
    public void alert(String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
