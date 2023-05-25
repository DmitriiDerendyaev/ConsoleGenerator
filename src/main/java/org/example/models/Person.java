package org.example.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    private Long id;

    @OneToMany(mappedBy = "person")
    private List<InteractionHistory> interactionHistoryList;

    private String name;
    private String patronymic;
    private String phone;
    private String email;
    private String surname;

    public Person() {
    }

    // Добавьте геттеры и сеттеры для всех полей

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
