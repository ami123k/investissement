package tn.epi.investissement.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.epi.investissement.Entites.Proposition;
import tn.epi.investissement.Entites.projet;
import tn.epi.investissement.Entites.status_projet;

import java.util.List;

@Repository
public interface projetRepository extends CrudRepository<projet,Long> {
    @Query(value ="SELECT * FROM projet p where p.status_projet = ?1" , nativeQuery = true)
    public List<projet> findprojetBystatus(status_projet status_projet);
    @Query(value ="SELECT * FROM projet p where p.user_id = ?1" , nativeQuery = true)
    public List<projet> findprojetsByuser(long id_user);

}
