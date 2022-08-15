package tn.epi.investissement.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import tn.epi.investissement.Entites.avis;


import tn.epi.investissement.Entites.forum;
import tn.epi.investissement.Services.forumService;

import java.util.List;

@RestController
public class forumController {
    @Autowired
    forumService forumService ;


    @GetMapping("/GetAllForum")
    @ResponseBody
    public List<forum> GetAllFurm() {
        return forumService.RetriveAll();
    }

    @GetMapping("/GetOneForum/{Id_Forum}")
    @ResponseBody
    public forum GetOneForum(@PathVariable("Id_Forum") Long Id_Forum) {
        return forumService.RetriveOne(Id_Forum);
    }

    @PostMapping("/AddForum")
    @ResponseBody
    public forum AddAvis(@RequestBody forum f ){
        return forumService.AddOrUpdateForum(f);
    }
    @PutMapping("UpdateForum")
    @ResponseBody
    public forum UpdateAvis(@RequestBody forum f ){
        return forumService.AddOrUpdateForum(f);
    }
    @DeleteMapping("/DeleteAvis/{Id_Forum}")
    @ResponseBody
    public void DeleteAvis(@PathVariable("Id_Forum")Long Id_Forum){
        forumService.Deletedorum(Id_Forum);
    }
}
