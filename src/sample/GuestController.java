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
    int fontSize;
    LoginController login;
    ObservableList<String> items;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        login = new LoginController();
    }

    @FXML
    private void readSearch() throws IOException {
        List<Person> users = login.loadUsers();

        //TESTING
        /*for(Person person:users)
        {
            System.out.println(person.getUsername());
        }*/

        String find = tSearch.getText();

        for(int i=0; i<login.loadUsers().size(); i++)
        {
            if(login.loadUsers().get(i).getName().toLowerCase().contains(find.toLowerCase()))
            {
                items=FXCollections.observableArrayList(login.loadUsers().get(i).toString());

            }

        }
        guestList.setItems(items);
    }
    @FXML
    private void optionExit() {
        LoginController.StageClose();
    }
    @FXML
    private void optionIncrease(){
    }
    @FXML
    private void optionDecrease(){

    }
}
