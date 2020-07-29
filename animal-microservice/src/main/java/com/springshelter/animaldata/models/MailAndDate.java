package com.springshelter.animaldata.models;

import java.time.LocalDate;

public class MailAndDate {
    private LocalDate date;
    private String mail;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
