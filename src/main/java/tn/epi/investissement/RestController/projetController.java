package tn.epi.investissement.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.epi.investissement.Entites.avis;
import tn.epi.investissement.Entites.projet;
import tn.epi.investissement.Services.projetService;

import java.util.List;

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
    @PutMapping("UpdateProject/{id_projet}")
    @ResponseBody
    public projet UpdateAvis(@PathVariable("id_projet" )Long id_projet) {
        return projetService.UpdateStatusProjet(id_projet);
    }
    @DeleteMapping("/DeleteProject/{id_projet}")
    @ResponseBody
    public void DeleteProject(@PathVariable("id_projet")Long id_projet){
        projetService.DeleteProjet(id_projet);
    }
}
