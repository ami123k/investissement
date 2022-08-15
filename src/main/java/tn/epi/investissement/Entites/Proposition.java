package tn.epi.investissement.Entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Proposition {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long Id_Proposition;
    private String Description ;
    private double montant;
    private status_proposition status_propo ;

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

    @JsonIgnore
    @OneToMany(mappedBy="proposition",cascade={CascadeType.ALL})
    private List<commentaire_proposition> commentaire_propositionList=new ArrayList<>() ;


}
