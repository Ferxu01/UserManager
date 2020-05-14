package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class GuestController implements Initializable {
    @FXML
    Label labelGuest;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelGuest.setText("Se ha ejecutado el controlador del invitado");
    }
}
