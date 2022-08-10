package tn.epi.investissement.Entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class commentaire_proposition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_commentaire_propo;
    private String Description ;

    public commentaire_proposition() {

    }

    public Long getId_commentaire_propo() {
        return Id_commentaire_propo;
    }

    public void setId_commentaire_propo(Long id_commentaire_propo) {
        Id_commentaire_propo = id_commentaire_propo;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public commentaire_proposition(Long id_commentaire_propo, String description) {
        Id_commentaire_propo = id_commentaire_propo;
        Description = description;
    }

    public commentaire_proposition(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return "commentaire_proposition{" +
                "Id_commentaire_propo=" + Id_commentaire_propo +
                ", Description='" + Description + '\'' +
                '}';
    }

    @JsonIgnore
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Proposition proposition ;

}
