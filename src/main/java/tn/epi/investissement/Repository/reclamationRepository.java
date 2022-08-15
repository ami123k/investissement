package tn.epi.investissement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.epi.investissement.Entites.reclamation_projet;

@Repository
public interface reclamationRepository extends CrudRepository<reclamation_projet,Long> {
}
