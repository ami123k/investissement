package tn.epi.investissement.Entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class commentaire_forum {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_commentaire_forum ;
    private String Description ;


    public Long getId_commentaire_forum() {
        return Id_commentaire_forum;
    }

    public void setId_commentaire_forum(Long id_commentaire_forum) {
        Id_commentaire_forum = id_commentaire_forum;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public commentaire_forum(Long id_commentaire_forum, String description) {
        Id_commentaire_forum = id_commentaire_forum;
        Description = description;
    }

    public commentaire_forum(String description) {
        Description = description;
    }
    public commentaire_forum() {

    }

}
