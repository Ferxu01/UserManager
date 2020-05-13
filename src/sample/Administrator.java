package sample;

public class Administrator extends Person {

    public Administrator(String dni, String name, String surname, String address, int age, String gender) {
        super(dni,name,surname,address,age,gender);
    }

    public Administrator(String username, String password) {
        super(username, password);
    }
}
