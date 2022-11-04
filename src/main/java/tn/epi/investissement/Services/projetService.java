package tn.epi.investissement.Services;

import tn.epi.investissement.Entites.avis;
import tn.epi.investissement.Entites.projet;
import tn.epi.investissement.Entites.User;
import java.util.List;

public interface projetService {
    public List<projet> RetriveAll();

    public projet AddProjetNonConfirm(projet p);

    void DeleteProjet(Long Id_projet);
    public User finduserbyprojet(long id);
    public projet RetriveOne(Long Id_projet);

    public projet UpdateStatusProjet(Long Id_Projet);

    public projet UpdateProjet(Long Id_Projet);

    public List<projet> Findallconfirm();
    public List<projet> Retrivemyprojects(long id);

    public List<projet> Findallnonconfirm();
}
