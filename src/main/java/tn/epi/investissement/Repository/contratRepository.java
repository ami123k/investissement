package tn.epi.investissement.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tn.epi.investissement.Entites.*;
import tn.epi.investissement.Entites.Proposition;
import java.util.List;

public interface contratRepository extends CrudRepository<contrat,Long> {
    @Query(value ="SELECT u FROM contrat u where u.projet.Id_Projet = ?1")
    public List<contrat> findcontratbyprojet(long id_projet);

//id mta3 proposition mta3 luser eli 3mal proposition ala projet mou3ayen ma3neha select bin select * from proposition where id_projet = id_projet and userid = userid

    @Query(value ="SELECT u FROM Proposition u where u.projet.Id_Projet = ?1 and u.user.id= ?2")
    public List<Proposition> findpropositioncontrat(long id_projet,long user_id);
}
