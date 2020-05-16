package sample;

abstract public class Person {

    private String username;
    private String password;
    private int id; //Opcional
    private String dni;
    private String name;
    private String surname;
    private String address;
    private String age;
    private String gender; //Male o female

    public Person(String username, String password,String dni, String name, String surname, String address, String age, String gender) {

        this.username = username;
        this.password = password;
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.age = age;
        this.gender = gender;
    }

    public String getType(){ return this.getClass().getName().substring(7); }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() { return password; }

    public void setPassword(String password) {
        this.password = password;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
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
        return  "====================="+"\n"
                +"Dni: "+dni+"\n"
                +"Name: "+name+"\n"
                +"Surname: "+surname+"\n"
                +"Address: "+address+"\n"
                +"Age: "+age+"\n"
                +"Gender: "+gender+"\n"
                +"====================";
    }
}
