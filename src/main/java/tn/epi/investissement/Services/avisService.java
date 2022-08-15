package tn.epi.investissement.Services;

import tn.epi.investissement.Entites.avis;

import java.util.List;

public interface avisService {

    public List<avis> RetriveAll() ;
    public avis AddOrUpdateavis(avis a );
    void Deleteavis (Long Id_avis);
    public avis RetriveOne(Long Id_avis);

}
