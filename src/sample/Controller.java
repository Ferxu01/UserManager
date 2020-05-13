package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    @FXML
    TextField usernameField, passwordField;

    final String USERS_FILE_PATH = "files\\users.txt";

    @FXML
    Label labelCorrect;

    @FXML
    public boolean checkLogin() throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();
        boolean correct = false;

        //Devuelve la lista de usuarios
        loadUsers();

        for (User currentUser : loadUsers()) {
            if (username.equals(currentUser.getUsername()) && password.equals(currentUser.getPassword())) {
                correct = true;
                labelCorrect.setText("The user is correct");
            }
        }

        return correct;
    }

    public List<User> loadUsers() throws IOException {
        BufferedReader usersFile = new BufferedReader(new FileReader(USERS_FILE_PATH));
        List<User> usersList = new ArrayList();
        User user;
        String line = "";
        String[] splitUser;

        do {
            line = usersFile.readLine();

            if (line != null) {
                splitUser = line.split(";");
                String username = splitUser[0];
                String password = splitUser[1];
                user = new User(username,password);
                usersList.add(user);
            }
        } while(line != null);

        usersFile.close();

        return usersList;
    }
}
