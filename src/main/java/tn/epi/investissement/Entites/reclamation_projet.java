package tn.epi.investissement.Entites;

import javax.persistence.*;

@Entity
public class reclamation_projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_reclamation ;
    private String Titre ;
    private String Description ;
    private String image ;
    @ManyToOne
    private projet projet;
    public reclamation_projet() {

    }

    public Long getId_reclamation() {
        return Id_reclamation;
    }

    public void setId_reclamation(Long id_reclamation) {
        Id_reclamation = id_reclamation;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String titre) {
        Titre = titre;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public reclamation_projet(Long id_reclamation, String titre, String description, String image) {
        Id_reclamation = id_reclamation;
        Titre = titre;
        Description = description;
        this.image = image;
    }

    public reclamation_projet(String titre, String description, String image) {
        Titre = titre;
        Description = description;
        this.image = image;
    }

    public tn.epi.investissement.Entites.projet getProjet() {
        return projet;
    }

    public void setProjet(tn.epi.investissement.Entites.projet projet) {
        this.projet = projet;
    }


}
