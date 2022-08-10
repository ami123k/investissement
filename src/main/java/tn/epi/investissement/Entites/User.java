package tn.epi.investissement.Entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long Id_user;
    private String nom ;

    public User() {

    }

    public Long getId_user() {
        return Id_user;
    }

    public void setId_user(Long id_user) {
        Id_user = id_user;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public User(Long id_user, String nom) {
        Id_user = id_user;
        this.nom = nom;
    }

    public User(String nom) {
        this.nom = nom;
    }

}
