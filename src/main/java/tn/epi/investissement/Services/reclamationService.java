package tn.epi.investissement.Services;

import tn.epi.investissement.Entites.Proposition;
import tn.epi.investissement.Entites.reclamation_projet;

import java.util.List;

public interface reclamationService {
    public List<reclamation_projet> RetriveAll() ;
    public reclamation_projet AddOrUpdatereclamation(reclamation_projet rp );
    void DeleteReclamation (Long Id_reclamation);
    public reclamation_projet RetriveOne(Long Id_reclamation);
}
