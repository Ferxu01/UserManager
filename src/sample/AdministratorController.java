package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AdministratorController implements Initializable {

    public ListView listUsers;
    public Button btnRemove;
    public Button btnEdit;
    public Button btnSave;
    public TextField usernameField;
    public TextField passField;
    LoginController lc;
    List<Person> userList;

    String username;
    String password;
    String dni;
    String name;
    String surname;
    String address;
    String age;
    String gender;
    int userTypeIndex;

    @FXML
    ComboBox dropDownUserType;

    @FXML
    Button btnAdd;

    @FXML
    TextField dniField, nameField, surnameField, addressField, ageField;

    @FXML
    RadioButton btnRadioGenderMale, btnRadioGenderFemale;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        lc = new LoginController();

        try {
            userList = lc.loadUsers();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ObservableList userTypesList = FXCollections.observableArrayList();
        userTypesList.addAll("Administrator","Guest");
        dropDownUserType.setItems(userTypesList);
        dropDownUserType.getSelectionModel().select(1);
        updateList();

        listUsers.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Person>()
                {
                    @Override
                    public void changed(ObservableValue<? extends Person> observable,
                                        Person oldValue, Person newValue) {
                        if (newValue != null)
                        {
                            passField.setText(newValue.getPassword());
                            usernameField.setText(newValue.getUsername());
                            nameField.setText(newValue.getName());
                            dniField.setText(newValue.getDni());
                            surnameField.setText(newValue.getSurname());
                            addressField.setText(newValue.getAddress());
                            ageField.setText(newValue.getAge());

                            if (newValue.getGender().equals("Male")) {
                                btnRadioGenderMale.fire();
                            } else if (newValue.getGender().equals("Female")) {
                                btnRadioGenderFemale.fire();
                            }

                            if (newValue.getType().equals("Administrator")) {
                                dropDownUserType.getSelectionModel().select(0);
                            } else if (newValue.getType().equals("Guest")) {
                                dropDownUserType.getSelectionModel().select(1);
                            }
                        }
                    }
                }
        );
    }

    @FXML
    private void getUserData() {
        username = usernameField.getText();
        password = passField.getText();
        dni = dniField.getText();
        name = nameField.getText();
        surname = surnameField.getText();
        address = addressField.getText();
        age = ageField.getText();
        gender = selectUserGender();
        userTypeIndex = dropDownUserType.getSelectionModel().getSelectedIndex();
        String userType = selectUserType(userTypeIndex);

        addUser(username,password,dni,name,surname,address,age,gender,userType);
    }

    public void updateList(){

        ObservableList users = FXCollections.observableArrayList(userList);
        listUsers.setItems(users);
    }

    private void addUser(String username, String password,String dni, String name, String surname, String address, String age, String gender, String userType) {

        Person user = null;

        switch (userType)
        {
            case "Administrator":
                user = new Administrator(username,password,dni,name,surname,address,age,gender);
                break;

            case "Guest":
                user = new Guest(username,password,dni,name,surname,address,age,gender);
                break;
        }

        userList.add(user);
        updateList();
    }

    public void removeUser(){

        for (int i=0; i<userList.size(); i++) {
            if(userList.get(i).getDni().equals(dniField.getText())){
                userList.remove(i);
            }
        }

        updateList();
    }

    @FXML
    private void editUser() {
        int indexUserEdit = listUsers.getSelectionModel().getSelectedIndex();
        String usernameEdit = usernameField.getText();
        String passwordEdit = passField.getText();
        String dniEdit = dniField.getText();
        String nameEdit = nameField.getText();
        String surnameEdit = surnameField.getText();
        String addressEdit = addressField.getText();
        String ageEdit = ageField.getText();
        String genderEdit = selectUserGender();

        //for (Person person : userList) {
            if (!userList.get(indexUserEdit).getUsername().equals(usernameEdit) || !userList.get(indexUserEdit).getPassword().equals(passwordEdit)
                    || !userList.get(indexUserEdit).getDni().equals(dniEdit) || !userList.get(indexUserEdit).getName().equals(nameEdit)
                    || !userList.get(indexUserEdit).getSurname().equals(surnameEdit) || !userList.get(indexUserEdit).getAddress().equals(addressEdit)
                    || !userList.get(indexUserEdit).getAge().equals(ageEdit) || !userList.get(indexUserEdit).getGender().equals(genderEdit))
            {
                userList.get(indexUserEdit).setUsername(usernameEdit);
                userList.get(indexUserEdit).setPassword(passwordEdit);
                userList.get(indexUserEdit).setDni(dniEdit);
                userList.get(indexUserEdit).setName(nameEdit);
                userList.get(indexUserEdit).setSurname(surnameEdit);
                userList.get(indexUserEdit).setAddress(addressEdit);
                userList.get(indexUserEdit).setAge(ageEdit);
                userList.get(indexUserEdit).setGender(genderEdit);
            }
        //}
        updateList();

    }

    private String selectUserGender() {
        String gender = "";
        if (btnRadioGenderMale.isSelected()) {
            gender = "Male";
        }
        else if (btnRadioGenderFemale.isSelected()) {
            gender = "Female";
        }
        return gender;
    }

    private String selectUserType(int index) {
        String type = "";
        switch (index)
        {
            case 0:
                type = "Administrator";
                break;
            case 1:
                type = "Guest";
                break;
        }
        return type;
    }
    @FXML
    private void optionReturnLogin(){
        LoginController.StageClose();
        Main.primaryStageShow();
    }

    public void saveUsers(){

        PrintWriter printWriter = null;

        try {
            printWriter = new PrintWriter (LoginController.USERS_FILE_PATH);

            for (Person person:userList) {

                printWriter.println(person.getUsername() + ";"
                        + person.getPassword() + ";" + person.getType() + ";"
                        + person.getDni() + ";"+ person.getName() + ";"
                        + person.getSurname() + ";"+ person.getAddress() + ";"
                        + person.getAge() + ";"+ person.getGender());
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }
    }
}
