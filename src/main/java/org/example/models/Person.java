package org.example.models;

public class Person {
    private int id;
    private String name;
    private String patronymic;
    private String phone;
    private String email;
    private String surname;

    public Person() {
        // Пустой конструктор
    }

    public Person(int id, String name, String patronymic, String phone, String email, String surname) {
        this.id = id;
        this.name = name;
        this.patronymic = patronymic;
        this.phone = phone;
        this.email = email;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
