package tn.epi.investissement.DTO;

import lombok.Data;
import org.springframework.lang.Nullable;

import java.time.LocalDate;
import java.time.Period;

@Data
public class PersonneDTO {
    private Long idPersonne;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    @Nullable
    private int age;

    public Long getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(Long idPersonne) {
        this.idPersonne = idPersonne;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
