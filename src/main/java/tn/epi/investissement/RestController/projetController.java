package tn.epi.investissement.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.epi.investissement.Entites.avis;
import tn.epi.investissement.Entites.projet;
import tn.epi.investissement.Services.projetService;

import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
public class projetController {

    @Autowired
    tn.epi.investissement.Services.projetService projetService;

    @GetMapping("/GetAllProject")
    @ResponseBody
    public List<projet> GetAllProject(){
        return projetService.RetriveAll();
    }
    @GetMapping("/GetOneProject/{Id_Project}")
    @ResponseBody
    public projet GetOneProject(@PathVariable("Id_Project") Long Id_Project) {
        return projetService.RetriveOne(Id_Project);
    }

    @PostMapping("/AddProject")
    @ResponseBody
    public projet AddProject(@RequestBody projet p ){

        return projetService.AddProjetNonConfirm(p);
    }
    @PutMapping("UpdatestatusProject/{id_projet}")
    @ResponseBody
    public projet Updatestatusprojet(@PathVariable("id_projet" )Long id_projet) {

        return projetService.UpdateStatusProjet(id_projet);
    }
    @PutMapping("UpdateProject/{id_projet}")
    @ResponseBody
    public projet Updateprojet(@PathVariable("id_projet" )Long id_projet) {

        return projetService.UpdateProjet(id_projet);
    }
    @DeleteMapping("/DeleteProject/{id_projet}")
    @ResponseBody
    public void DeleteProject(@PathVariable("id_projet")Long id_projet){
        projetService.DeleteProjet(id_projet);
    }
    @GetMapping("/GetAllProjectconfirme")
    @ResponseBody
    public List<projet> GetAllProjectconfirme(){
        return projetService.Findallconfirm();
    }
    @GetMapping("/GetAllProjectnonconfirme")
    @ResponseBody
    public List<projet> GetAllProjectnonconfirme(){
        return projetService.Findallnonconfirm();
    }
    @GetMapping("/Getmyprojets/{id_user}")
    @ResponseBody
    public List<projet> Getmyprojets(@PathVariable("id_user" )long id_user){
        return projetService.Retrivemyprojects(id_user);
    }

}
