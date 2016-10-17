package com.example.yasmine.semana2;

import java.io.Serializable;
import java.util.Date;


public class Register implements Serializable{
    private String name;
    private String birthDate;
    private String telephone;
    private String email;
    private String notes;

    public Register(String name, String birthDate, String telephone, String email, String notes) {
        this.name = name;
        this.birthDate = birthDate;
        this.telephone = telephone;
        this.email = email;
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Register{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
