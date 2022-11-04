package tn.epi.investissement.Entites;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
public class Proposition {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long Id_Proposition;
    private String Description ;
    private double montant;
    @Enumerated(EnumType.STRING)
    private status_proposition status_propo ;
    private LocalDate date;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Proposition() {

    }

    public Long getId_Proposition() {
        return Id_Proposition;
    }

    public void setId_Proposition(Long id_Proposition) {
        Id_Proposition = id_Proposition;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public status_proposition getStatus_propo() {
        return status_propo;
    }

    public void setStatus_propo(status_proposition status_propo) {
        this.status_propo = status_propo;
    }

    public Proposition(Long id_Proposition, String description, double montant, status_proposition status_propo) {
        Id_Proposition = id_Proposition;
        Description = description;
        this.montant = montant;
        this.status_propo = status_propo;
    }

    public Proposition(String description, double montant, status_proposition status_propo) {
        Description = description;
        this.montant = montant;
        this.status_propo = status_propo;
    }

    @JsonIgnore
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private projet projet ;
    @ManyToOne
    @JsonIgnore
    @JsonBackReference
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user ;
    @JsonIgnore
    @OneToMany(mappedBy="proposition",cascade={CascadeType.ALL})
    private List<commentaire_proposition> commentaire_propositionList=new ArrayList<>() ;

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

    public Proposition(String description, double montant, status_proposition status_propo, tn.epi.investissement.Entites.projet projet, User user) {
        Description = description;
        this.montant = montant;
        this.status_propo = status_propo;
        this.projet = projet;
        this.user = user;
    }

    public Proposition(Long id_Proposition, String description, double montant, status_proposition status_propo, LocalDate date, tn.epi.investissement.Entites.projet projet, User user) {
        Id_Proposition = id_Proposition;
        Description = description;
        this.montant = montant;
        this.status_propo = status_propo;
        this.date = date;
        this.projet = projet;
        this.user = user;
    }
}
