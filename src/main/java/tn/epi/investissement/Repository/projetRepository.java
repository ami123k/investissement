package tn.epi.investissement.Repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.epi.investissement.Entites.projet;

@Repository
public interface projetRepository extends CrudRepository<projet,Long> {
}
