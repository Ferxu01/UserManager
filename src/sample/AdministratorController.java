package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class AdministratorController implements Initializable {
    @FXML
    Label labelAdmin;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelAdmin.setText("Se ha ejecutado el controlador del administrador");
    }
}
