package tn.epi.investissement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.epi.investissement.Entites.commentaire_forum;

@Repository
public interface comForumRepository extends CrudRepository<commentaire_forum,Long> {
}
