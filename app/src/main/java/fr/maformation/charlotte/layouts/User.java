package fr.maformation.charlotte.layouts;

import java.io.Serializable;

public class User implements Serializable {

    String nom;
    String prenom;
    int age;

    public User(String nom, String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getAge() {
        return age;
    }
}
