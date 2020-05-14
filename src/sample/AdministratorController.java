package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class AdministratorController implements Initializable {

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
        ObservableList userTypesList = FXCollections.observableArrayList();
        userTypesList.addAll("Administrator","Guest");
        dropDownUserType.setItems(userTypesList);
        dropDownUserType.getSelectionModel().select(1);
    }

    @FXML
    private void getUserData() {
        String dni = dniField.getText();
        String name = nameField.getText();
        String surname = surnameField.getText();
        String address = addressField.getText();
        int age = Integer.parseInt(ageField.getText());
        String gender = selectUserGender();
        int userTypeIndex = dropDownUserType.getSelectionModel().getSelectedIndex();
        String userType = selectUserType(userTypeIndex);

        addUser(dni,name,surname,address,age,gender,userType);
    }

    private void addUser(String dni, String name, String surname, String address, int age, String gender, String userType) {
        Person user;
        switch (userType)
        {
            case "Administrator":
                user = new Administrator(dni,name,surname,address,age,gender);
                break;

            case "Guest":
                user = new Guest(dni,name,surname,address,age,gender);
                break;
        }
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
}
