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
}
