package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    TextField usernameField, passwordField;
    private static Stage stage;

    final String USERS_FILE_PATH = "files\\users.txt";

    @FXML
    public void checkLogin() throws Exception {
        String username = usernameField.getText();
        String password = passwordField.getText();

        for (Person currentUser : loadLoginUsers()) {
            if (username.equals(currentUser.getUsername()) && password.equals(currentUser.getPassword())) {
                setScene(currentUser);
            }
        }
        loadUsers();
    }

    public void setScene(Person currentUser) throws Exception{

        stage = new Stage();
        Parent root = null;

        if(currentUser.getType().contains("Administrator")){
            root = FXMLLoader.load(getClass().getResource("administrator.fxml"));
            stage.setTitle("User manager - Administrator");
        }
        else if(currentUser.getType().contains("Guest")){
            root = FXMLLoader.load(getClass().getResource("guest.fxml"));
            stage.setTitle("User manager - Guest");
        }

        stage.setScene(new Scene(root, 600, 463));
        Main.primaryStageClose();
        stage.show();
    }

    public List<Person> loadLoginUsers() throws IOException {

        BufferedReader usersFile = new BufferedReader(new FileReader(USERS_FILE_PATH));
        List<Person> usersList = new ArrayList();
        Person user = null;
        String line = "";
        String[] splitUser;

        do {
            line = usersFile.readLine();

            if (line != null) {
                splitUser = line.split(";");
                String username = splitUser[0];
                String password = splitUser[1];
                String type = splitUser[2];

                if(type.contains("Guest")){
                    user = new Guest(username, password);
                }
                else if(type.contains("Administrator")){
                    user = new Administrator(username, password);
                }

                usersList.add(user);
            }
        } while(line != null);

        usersFile.close();

        return usersList;
    }

    public List<Person> loadUsers() throws IOException {
        BufferedReader usersFile = new BufferedReader(new FileReader(USERS_FILE_PATH));
        List<Person> usersData = new ArrayList<>();
        Person user = null;
        String line = "";
        String[] splitUser;

        do {
            line = usersFile.readLine();

            if (line != null) {
                splitUser = line.split(";");
                String type = splitUser[2];
                String dni = splitUser[3];
                String name = splitUser[4];
                String surname = splitUser[5];
                String address = splitUser[6];
                int age = Integer.parseInt(splitUser[7]);
                String gender = splitUser[8];

                if(type.contains("Guest")){
                    user = new Guest(dni,name,surname,address,age,gender);
                }
                else if(type.contains("Administrator")){
                    user = new Administrator(dni,name,surname,address,age,gender);
                }

                usersData.add(user);
            }
        } while(line != null);

        usersFile.close();

        return usersData;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    public static void StageClose(){
        stage.close();
    }
}
