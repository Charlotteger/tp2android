package fr.maformation.charlotte.layouts;

import java.io.Serializable;

public class User implements Serializable {

    boolean isSelected = false;
    String nom;
    String prenom;
    int age;

    public User(boolean isSelected, String nom, String prenom, int age) {
        this.isSelected = isSelected;
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

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
