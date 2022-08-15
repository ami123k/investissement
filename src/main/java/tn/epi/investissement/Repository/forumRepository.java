package tn.epi.investissement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.epi.investissement.Entites.forum;

@Repository
public interface forumRepository extends CrudRepository<forum,Long> {
}
