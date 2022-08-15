package tn.epi.investissement.Entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
public class avis {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private Long Id_avis;
    private  int nb_avis;
    public avis() {

    }
    public avis(Long id_avis, int nb_avis) {
        Id_avis = id_avis;
        this.nb_avis = nb_avis;
    }

    public avis(int nb_avis) {
        this.nb_avis = nb_avis;
    }



    public Long getId_avis() {
        return Id_avis;
    }

    public void setId_avis(Long id_avis) {
        Id_avis = id_avis;
    }

    public int getNb_avis() {
        return nb_avis;
    }

    public void setNb_avis(int nb_avis) {
        this.nb_avis = nb_avis;
    }
    @JsonIgnore
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private projet projet ;

    @ManyToOne
    private User user;
}
