package tn.epi.investissement.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.epi.investissement.Entites.Proposition;
import tn.epi.investissement.Entites.projet;
import tn.epi.investissement.Entites.status_projet;
import tn.epi.investissement.Entites.status_proposition;

import java.util.List;

@Repository
public interface propositionRepository extends CrudRepository<Proposition,Long> {
    @Query(value ="SELECT * FROM proposition p where p.status_proposition = ?1" , nativeQuery = true)
    public List<Proposition> findPropositionByStatus_propo(status_proposition status_proposition);
    @Query(value ="SELECT * FROM proposition p where p.projet_id_projet = ?1" , nativeQuery = true)
    public List<Proposition> findpropobyprojet(long id_projet);
    @Query(value ="SELECT * FROM proposition p where p.projet_id_projet = ?1 AND p.user_id=?2" , nativeQuery = true)
    public List<Proposition> findpropobyprojetanduser(long id_projet, long id_user);

}
