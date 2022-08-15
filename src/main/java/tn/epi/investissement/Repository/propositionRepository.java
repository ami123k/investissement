package tn.epi.investissement.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.epi.investissement.Entites.Proposition;

@Repository
public interface propositionRepository extends CrudRepository<Proposition,Long> {
}
