package tn.epi.investissement.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.epi.investissement.Entites.commentaire_proposition;

@Repository
public interface comPropRepository extends CrudRepository<commentaire_proposition,Long> {
}
