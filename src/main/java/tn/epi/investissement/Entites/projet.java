package tn.epi.investissement.Entites;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @Enumerated(EnumType.STRING)
    private categorie categories ;
    @Enumerated(EnumType.STRING)
    private status_projet status_projet ;
    @ManyToOne
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonBackReference
    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user ;

    @JsonIgnore
    @OneToMany(mappedBy="projet",cascade={CascadeType.REMOVE})
    private List<Proposition> listepropo ;
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    @JsonBackReference
    @OneToMany(mappedBy="projet",cascade={CascadeType.REMOVE})
    private List<contrat> listecontrat ;
    @JsonIgnore
    @OneToMany(mappedBy="projet",cascade={CascadeType.REMOVE})
    private List<reclamation_projet> reclamation_projets ;
    @JsonIgnore
    @OneToMany(mappedBy="projet",cascade={CascadeType.ALL})
    private List<avis> avisList;

    public categorie getCategories() {
        return categories;
    }

    public void setCategories(categorie categories) {
        this.categories = categories;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public tn.epi.investissement.Entites.status_projet getStatus_projet() {
        return status_projet;
    }

    public void setStatus_projet(tn.epi.investissement.Entites.status_projet status_projet) {
        this.status_projet = status_projet;
    }

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
        return status_projet;
    }

    public void setStatus(status_projet status) {
        this.status_projet = status;
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



    @Override
    public String toString() {
        return "projet{" +
                "Id_Projet=" + Id_Projet +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", status=" + status_projet +
                ", montant_debut=" + montant_debut +
                ", montant_fin=" + montant_fin +
                '}';
    }


    public projet(Long id_Projet, String nom, String predescription, String description, categorie categories, tn.epi.investissement.Entites.status_projet status_projet, User user, String image, double montant_debut, double montant_fin) {
        Id_Projet = id_Projet;
        this.nom = nom;
        this.predescription = predescription;
        this.description = description;
        this.categories = categories;
        this.status_projet = status_projet;
        this.user = user;
        this.image = image;
        this.montant_debut = montant_debut;
        this.montant_fin = montant_fin;
    }

    public projet(String nom, String predescription, String description, categorie categories, tn.epi.investissement.Entites.status_projet status_projet, User user, String image, double montant_debut, double montant_fin) {
        this.nom = nom;
        this.predescription = predescription;
        this.description = description;
        this.categories = categories;
        this.status_projet = status_projet;
        this.user = user;
        this.image = image;
        this.montant_debut = montant_debut;
        this.montant_fin = montant_fin;
    }
}
