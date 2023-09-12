package tn.epi.investissement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.epi.investissement.Models.Personne;

@Repository
public interface PersonneRepository  extends JpaRepository<Personne, Long> {
}
