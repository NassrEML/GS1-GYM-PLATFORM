package model;

public class User {
    
    private String name;
    private String lastname;
    private int age;
    private double weight;
    private double height;
    private String genre;
    private String mail;
    private String rol;
    private String password;

    public User(String name, String lastname, int age, String genre, String mail, String rol, String password) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.genre = genre;
        this.mail = mail;
        this.rol = rol;
        this.password = password;
    }
    
    public User(String name, String lastname, int age, double weight, double height, String genre, String mail, String rol, String password) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.genre = genre;
        this.mail = mail;
        this.rol = rol;
        this.password = password;
    }
    
    
    

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public String getGenre() {
        return genre;
    }

    public String getMail() {
        return mail;
    }

    public String getRol() {
        return rol;
    }

    public String getPassword() {
        return password;
    }
    
    
    
    
    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
