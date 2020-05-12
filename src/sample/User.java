package sample;

abstract public class User {
    private int id; //Opcional
    private String dni;
    private String name;
    private String surname;
    private String address;
    private int age;
    private String gender; //Male o female

    public User(String dni, String name, String surname, String address, int age, String gender) {
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.age = age;
        this.gender = gender;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Dni: "+dni+"\n"
                +"Name: "+name+"\n"
                +"Surname: "+surname+"\n"
                +"Address: "+address+"\n"
                +"Age: "+age+"\n"
                +"Gender: "+gender+"\n";
    }
}
