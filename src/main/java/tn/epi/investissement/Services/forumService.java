package tn.epi.investissement.Services;


import tn.epi.investissement.Entites.forum;

import java.util.List;

public interface forumService {

    public List<forum> RetriveAll() ;
    public forum AddOrUpdateForum(forum f );
    void Deletedorum (Long Id_forum);
    public forum RetriveOne(Long Id_forum);
}
