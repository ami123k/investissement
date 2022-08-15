package tn.epi.investissement.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.epi.investissement.Entites.projet;
import tn.epi.investissement.Entites.status_projet;
import tn.epi.investissement.Repository.projetRepository;

import java.util.List;

@Service
public class projetServiceImpl implements  projetService{
    @Autowired
    projetRepository projetRepository;
    @Override
    public List<projet> RetriveAll() {
        return (List<projet>) projetRepository.findAll();
    }


    @Override
    public void DeleteProjet(Long Id_projet) {
    projetRepository.deleteById(Id_projet);
    }
    @Override
    public projet AddProjetNonConfirm(projet p ){
        p.setStatus(status_projet.NonConfirme);
     return
             projetRepository.save(p);

    }
    @Override
    public projet UpdateStatusProjet(Long Id_Projet){
        projet p = projetRepository.findById(Id_Projet).get();
        p.setStatus(status_projet.Confirme);
        return projetRepository.save(p);
    }


    @Override
    public projet RetriveOne(Long Id_projet) {
        return projetRepository.findById(Id_projet).get();
    }
}
