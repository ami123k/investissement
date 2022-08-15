package tn.epi.investissement.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.epi.investissement.Entites.avis;
import tn.epi.investissement.Repository.avisRepository;

import java.util.List;

@Service
public class avisServiceImpl implements  avisService {

    @Autowired
    avisRepository avisRepository ;


    @Override
    public List<avis> RetriveAll() {
        return (List<avis>) avisRepository.findAll();
    }

    @Override
    public avis AddOrUpdateavis(avis a) {
        return avisRepository.save(a);
    }

    @Override
    public void Deleteavis(Long Id_avis) {
        avisRepository.deleteById(Id_avis);
    }

    @Override
    public avis RetriveOne(Long Id_avis) {
        return avisRepository.findById(Id_avis).get();
    }
}
