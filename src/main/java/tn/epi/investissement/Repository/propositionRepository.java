package tn.epi.investissement.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.epi.investissement.Entites.*;

import javax.swing.*;
import java.sql.ClientInfoStatus;
import java.util.List;

@Repository
public interface propositionRepository extends CrudRepository<Proposition,Long> {

    @Query("SELECT p FROM Proposition p where p.user.id = ?1 and p.status_propo = ?2")
    public List<Proposition> findPropositionByStatus_propo(long user_id , status_proposition status_proposition);

    @Query(value ="SELECT * FROM proposition p where p.projet_id_projet = ?1" , nativeQuery = true)
    public List<Proposition> findpropobyprojet(long id_projet);
    @Query(value ="SELECT * FROM proposition p where p.projet_id_projet = ?1 AND p.user_id=?2" , nativeQuery = true)
    public List<Proposition> findpropobyprojetanduser(long id_projet, long id_user);

    @Query(value ="SELECT p.user_id FROM proposition p where p.id_proposition = ?1" , nativeQuery = true)
    public long getUserbyproposition(long id_proposition);
    @Query(value ="SELECT p.user FROM Proposition p where p.projet.Id_Projet = ?1")
    public List<User> getUserbypropositionprojet(long id_projet);
}

