package tn.epi.investissement.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.epi.investissement.Entites.Proposition;
import tn.epi.investissement.Entites.status_proposition;
import tn.epi.investissement.repository.propositionRepository;

import java.util.List;
@Service
public class propositionServiceImpl implements proposotionService {


    @Autowired
    propositionRepository propositionRpository ;
    @Override
    public List<Proposition> RetriveAll() {
        return (List<Proposition>) propositionRpository.findAll();
    }

    @Override
    public Proposition Update(Proposition p) {
        p.setStatus_propo(p.getStatus_propo());
        return propositionRpository.save(p);
    }


    @Override
    public Proposition AddProposition(Proposition p ){
        p.setStatus_propo(status_proposition.NonConfirme);
        return  propositionRpository.save(p);
    }
    @Override
    public Proposition UpdatePropsitionPreConfirm(Long Id_prop){
       Proposition p= propositionRpository.findById(Id_prop).get();
        p.setStatus_propo(status_proposition.preconfirme);
        return propositionRpository.save(p);
    }


    @Override
    public Proposition UpdatePropostionConfirm(Long Id_prop){
        Proposition p= propositionRpository.findById(Id_prop).get();
        p.setStatus_propo(status_proposition.confirme);
        return propositionRpository.save(p);
    }

    @Override
    public void DeleteProposition(Long Id_Propostion) {
        propositionRpository.deleteById(Id_Propostion);

    }

    @Override
    public Proposition RetriveOne(Long Id_Propostion) {

        return propositionRpository.findById(Id_Propostion).get();
    }
    @Override
    public List<Proposition> findallnonconfirm() {
        return (List<Proposition>) propositionRpository.findPropositionByStatus_propo(status_proposition.NonConfirme);
    }
    @Override
    public List<Proposition> findallconfirm() {
        return (List<Proposition>) propositionRpository.findPropositionByStatus_propo(status_proposition.confirme);
    }
    @Override
    public List<Proposition> findallpreconfirm() {
        return (List<Proposition>) propositionRpository.findPropositionByStatus_propo(status_proposition.preconfirme);
    }

}
