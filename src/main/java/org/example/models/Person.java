package org.example.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "person")
    private List<InteractionHistory> interactionHistoryList;

    private String name;
    private String patronymic;
    private String phone;
    private String email;
    private String surname;
    private String login;
    private String password;

    public Person(String name, String patronymic, String phone, String email, String surname, String login, String password) {
        this.name = name;
        this.patronymic = patronymic;
        this.phone = phone;
        this.email = email;
        this.surname = surname;
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<InteractionHistory> getInteractionHistoryList() {
        return interactionHistoryList;
    }

    public void setInteractionHistoryList(List<InteractionHistory> interactionHistoryList) {
        this.interactionHistoryList = interactionHistoryList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

}
