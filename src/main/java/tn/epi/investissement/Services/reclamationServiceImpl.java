package tn.epi.investissement.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.epi.investissement.Entites.reclamation_projet;
import tn.epi.investissement.repository.reclamationRepository;

import java.util.List;

@Service
public class reclamationServiceImpl implements reclamationService{
    @Autowired
    tn.epi.investissement.repository.reclamationRepository reclamationRepository;
    @Override
    public List<reclamation_projet> RetriveAll() {
        return (List<reclamation_projet>) reclamationRepository.findAll();
    }

    @Override
    public reclamation_projet AddOrUpdatereclamation(reclamation_projet rp) {
        return reclamationRepository.save(rp);
    }

    @Override
    public void DeleteReclamation(Long Id_reclamation) {
        reclamationRepository.deleteById(Id_reclamation);

    }

    @Override
    public reclamation_projet RetriveOne(Long Id_reclamation) {
        return reclamationRepository.findById(Id_reclamation).get();
    }
}
