package fr.maformation.charlotte.layouts;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.io.Serializable;

public class User extends BaseObservable implements Serializable {

    boolean isSelected;
    String nom;
    String prenom;
    int age;

    public User(boolean isSelected, String nom, String prenom, int age) {
        this.isSelected = isSelected;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    @Bindable
    public String getNom() {
        return nom;
    }

    @Bindable
    public String getPrenom() {
        return prenom;
    }

    @Bindable
    public int getAge() {
        return age;
    }

    @Bindable
    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
        notifyPropertyChanged(BR.selected);
    }
}
