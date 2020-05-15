package sample;

public class Guest extends Person {

    public Guest(String dni, String name, String surname, String address, int age, String gender) {
        super(dni,name,surname,address,age,gender);
    }

    public Guest(String username, String password) {
        super(username, password);
    }
}
