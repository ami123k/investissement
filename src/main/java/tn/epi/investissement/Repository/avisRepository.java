package tn.epi.investissement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.epi.investissement.Entites.avis;

@Repository
public interface avisRepository extends CrudRepository<avis,Long> {
}
