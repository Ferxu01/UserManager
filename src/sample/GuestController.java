package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.control.TextField;

public class GuestController implements Initializable {
    public Button exitBtn;
    public TextField tSearch;
    LoginController login;

    @FXML
    Label labelGuest;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelGuest.setText("Se ha ejecutado el controlador del invitado");
        login = new LoginController();
    }

    @FXML
    private void readSearch() throws IOException {
        List<Person> users = login.loadUsers();
        String find;
        find = tSearch.getText();

        for(int i=0; i<users.size(); i++)
        {
            if(find.contains(users.get(i).getUsername()))
            {
                //Falta añadir el resto de elementos Nombre, DNI, Direccion...
                System.out.println(users.get(i).getUsername());
            }
        }
    }
    @FXML
    private void optionExit() {
        LoginController.StageClose();
    }
}
