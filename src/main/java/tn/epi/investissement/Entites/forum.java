package tn.epi.investissement.Entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class forum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_forum;
    private String titre ;
    private String Description ;

    public forum() {

    }

    public Long getId_forum() {
        return Id_forum;
    }

    public void setId_forum(Long id_forum) {
        Id_forum = id_forum;
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

    public forum(Long id_forum, String titre, String description) {
        Id_forum = id_forum;
        this.titre = titre;
        Description = description;
    }

    public forum(String titre, String description) {
        this.titre = titre;
        Description = description;
    }

}
