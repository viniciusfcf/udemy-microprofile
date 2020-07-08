package com.github.viniciusfcf.microprofile.config;

public class Email {
    
    private String mail;

    // public static Email of(String str) {
    //     Email email = new Email();
    //     email.mail = str;
    //     return email;
    // }

    public static Email valueOf(String str) {
        Email email = new Email();
        email.mail = str;
        return email;
    }

    public String getMail() {
        return mail;
    }

}