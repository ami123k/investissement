package tn.epi.investissement.Entites;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class projet {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long Id_Projet;
    private String nom;
    private String predescription ;
    private String description;

    public String getPredescription() {
        return predescription;
    }

    public void setPredescription(String predescription) {
        this.predescription = predescription;
    }

    public List<Proposition> getListepropo() {
        return listepropo;
    }

    public void setListepropo(List<Proposition> listepropo) {
        this.listepropo = listepropo;
    }

    public List<reclamation_projet> getReclamation_projets() {
        return reclamation_projets;
    }

    public void setReclamation_projets(List<reclamation_projet> reclamation_projets) {
        this.reclamation_projets = reclamation_projets;
    }

    public List<avis> getAvisList() {
        return avisList;
    }

    public void setAvisList(List<avis> avisList) {
        this.avisList = avisList;
    }

    private String image ;
    private status_projet status ;
    private double montant_debut ;
    private double montant_fin ;



    public projet() {

    }

    public Long getId_Projet() {
        return Id_Projet;
    }

    public void setId_Projet(Long id_Projet) {
        Id_Projet = id_Projet;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public status_projet getStatus() {
        return status;
    }

    public void setStatus(status_projet status) {
        this.status = status;
    }

    public double getMontant_debut() {
        return montant_debut;
    }

    public void setMontant_debut(double montant_debut) {
        this.montant_debut = montant_debut;
    }

    public double getMontant_fin() {
        return montant_fin;
    }

    public void setMontant_fin(double montant_fin) {
        this.montant_fin = montant_fin;
    }

    public projet(Long id_Projet, String nom, String description, String image, status_projet status, double montant_debut, double montant_fin) {
        Id_Projet = id_Projet;
        this.nom = nom;
        this.description = description;
        this.image = image;
        this.status = status;
        this.montant_debut = montant_debut;
        this.montant_fin = montant_fin;
    }

    public projet(String nom, String description, String image, status_projet status, double montant_debut, double montant_fin) {
        this.nom = nom;
        this.description = description;
        this.image = image;
        this.status = status;
        this.montant_debut = montant_debut;
        this.montant_fin = montant_fin;
    }

    @Override
    public String toString() {
        return "projet{" +
                "Id_Projet=" + Id_Projet +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", status=" + status +
                ", montant_debut=" + montant_debut +
                ", montant_fin=" + montant_fin +
                '}';
    }

    @JsonIgnore
    @OneToMany(mappedBy="projet",cascade={CascadeType.REMOVE})
    private List<Proposition> listepropo ;

    @JsonIgnore
    @OneToMany(mappedBy="projet",cascade={CascadeType.REMOVE})
    private List<reclamation_projet> reclamation_projets ;
    @JsonIgnore
    @OneToMany(mappedBy="projet",cascade={CascadeType.ALL},fetch = FetchType.EAGER)
    private List<avis> avisList;

    public projet(String nom, String predescription, String description, String image, status_projet status, double montant_debut, double montant_fin) {
        this.nom = nom;
        this.predescription = predescription;
        this.description = description;
        this.image = image;
        this.status = status;
        this.montant_debut = montant_debut;
        this.montant_fin = montant_fin;
    }

    public projet(Long id_Projet, String nom, String predescription, String description, String image, status_projet status, double montant_debut, double montant_fin) {
        Id_Projet = id_Projet;
        this.nom = nom;
        this.predescription = predescription;
        this.description = description;
        this.image = image;
        this.status = status;
        this.montant_debut = montant_debut;
        this.montant_fin = montant_fin;
    }
}
