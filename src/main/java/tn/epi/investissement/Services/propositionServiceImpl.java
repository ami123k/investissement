package tn.epi.investissement.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
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
        p.setStatus_propo(status_proposition.nonConfirme);
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
    public List<Proposition> findallnonconfirm(long user_id) {
        return (List<Proposition>) propositionRpository.findPropositionByStatus_propo(user_id , status_proposition.nonConfirme);
    }
    @Override
    public List<Proposition> findallconfirm(long user_id) {
        return (List<Proposition>) propositionRpository.findPropositionByStatus_propo( user_id , status_proposition.confirme);
    }
    @Override
    public List<Proposition> findallpreconfirm(long user_id) {
        return (List<Proposition>) propositionRpository.findPropositionByStatus_propo(user_id,status_proposition.preconfirme);
    }
    @Override
    public List<Proposition> findpropobyprojet(Long id) {
        return propositionRpository.findpropobyprojet(id);
    }
    @Override
    public List<Proposition> findpropobyprojetanduser(Long id_projet,long id_user) {
        return propositionRpository.findpropobyprojetanduser(id_projet,id_user);
    }
}
