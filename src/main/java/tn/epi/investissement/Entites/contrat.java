package tn.epi.investissement.Entites;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class contrat {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id_contrat;
    private String singature_investisseur;
    private String signature_entrepreneur;
    private String titre ;
    private String Description ;
    private String montant ;

    public contrat() {

    }

    public Long getId_contrat() {
        return id_contrat;
    }

    public void setId_contrat(Long id_contrat) {
        this.id_contrat = id_contrat;
    }

    public String getSingature_investisseur() {
        return singature_investisseur;
    }

    public void setSingature_investisseur(String singature_investisseur) {
        this.singature_investisseur = singature_investisseur;
    }

    public String getSignature_entrepreneur() {
        return signature_entrepreneur;
    }

    public void setSignature_entrepreneur(String signature_entrepreneur) {
        this.signature_entrepreneur = signature_entrepreneur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getMontant() {
        return montant;
    }

    public void setMontant(String montant) {
        this.montant = montant;
    }

    public tn.epi.investissement.Entites.projet getProjet() {
        return projet;
    }

    public void setProjet(tn.epi.investissement.Entites.projet projet) {
        this.projet = projet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public contrat(Long id_contrat, String singature_investisseur, String signature_entrepreneur, String titre, String description, String montant, tn.epi.investissement.Entites.projet projet, User user) {
        this.id_contrat = id_contrat;
        this.singature_investisseur = singature_investisseur;
        this.signature_entrepreneur = signature_entrepreneur;
        this.titre = titre;
        Description = description;
        this.montant = montant;
        this.projet = projet;
        this.user = user;
    }

    public contrat(String singature_investisseur, String signature_entrepreneur, String titre, String description, String montant, tn.epi.investissement.Entites.projet projet, User user) {
        this.singature_investisseur = singature_investisseur;
        this.signature_entrepreneur = signature_entrepreneur;
        this.titre = titre;
        Description = description;
        this.montant = montant;
        this.projet = projet;
        this.user = user;
    }

    @JsonIgnore
    @ManyToOne
    @JsonBackReference
    @OnDelete(action = OnDeleteAction.CASCADE)
    private projet projet ;
    @ManyToOne
    @JsonIgnore
    @JsonBackReference
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user ;
}
