package tn.epi.investissement.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.epi.investissement.Entites.forum;
import tn.epi.investissement.Repository.forumRepository;

import java.util.List;

@Service
public class forumServiceImpl implements forumService{
    @Autowired
    tn.epi.investissement.Repository.forumRepository forumRepository ;


    @Override
    public List<forum> RetriveAll() {
        return (List<forum>) forumRepository.findAll();
    }

    @Override
    public forum AddOrUpdateForum(forum f) {
        return forumRepository.save(f);
    }

    @Override
    public void Deletedorum(Long Id_forum) {
        forumRepository.deleteById(Id_forum);

    }

    @Override
    public forum RetriveOne(Long Id_forum) {
        return forumRepository.findById(Id_forum).get();
    }
}
