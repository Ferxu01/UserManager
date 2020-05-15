package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
    public ListView guestList;
    LoginController login;
    ObservableList<String> items;

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
            if(find.toLowerCase().contains(users.get(i).getUsername().toLowerCase()))
            {
                items=FXCollections.observableArrayList(users.get(i).toString());
                guestList.setItems(items);
                //System.out.println(users.get(i));
            }
        }
    }
    @FXML
    private void optionExit() {
        LoginController.StageClose();
    }
}
