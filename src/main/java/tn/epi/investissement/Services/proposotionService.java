package tn.epi.investissement.Services;

import tn.epi.investissement.Entites.Proposition;
import tn.epi.investissement.Entites.avis;

import java.util.List;

public interface proposotionService {

    public List<Proposition> RetriveAll() ;
    void DeleteProposition (Long Id_Propostion);
    public Proposition RetriveOne(Long Id_Propostion);
    public Proposition Update(Proposition p);
    public Proposition AddProposition(Proposition p );
    public Proposition UpdatePropsitionPreConfirm(Long Id_prop);
    public Proposition UpdatePropostionConfirm(Long Id_prop);
}
