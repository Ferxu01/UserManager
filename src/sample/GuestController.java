package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class GuestController implements Initializable {
    public Button exitBtn;
    public TextField tSearch;
    public ListView guestList;
    LoginController login;
    ObservableList<String> items;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        login = new LoginController();
    }

    @FXML
    private void readSearch() throws IOException {
        List<Person> users = login.loadUsers();
        items = FXCollections.observableArrayList();

        String find = tSearch.getText();

        if(find.length() != 0) {

            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getName().toLowerCase().contains(find.toLowerCase())) {
                    items.add(users.get(i).toString());
                }
            }

            guestList.setItems(items);
        }
        else{
            guestList.setItems(null);
        }
    }

    @FXML
    private void optionExit() {
        LoginController.StageClose();
    }
}
