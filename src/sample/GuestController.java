package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.TextField;

public class GuestController implements Initializable {
    public Button exitBtn;
    public TextField tSearch;

    @FXML
    Label labelGuest;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelGuest.setText("Se ha ejecutado el controlador del invitado");
    }

    @FXML
    private void readSearch()
    {
        String find;
        find = tSearch.getText();

        System.out.println(find);
    }
}
