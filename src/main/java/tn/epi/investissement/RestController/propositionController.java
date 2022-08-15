package tn.epi.investissement.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.epi.investissement.Entites.Proposition;
import tn.epi.investissement.Entites.projet;

import java.util.List;
import tn.epi.investissement.Services.proposotionService;
@RestController

public class propositionController {
@Autowired
proposotionService proposotionService;

    @GetMapping("/GetAllProposition")
    @ResponseBody
    public List<Proposition> GetAllProposition(){
        return proposotionService.RetriveAll();
    }
    @GetMapping("/GetAllPropositionNonconfirm")
    @ResponseBody
    public List<Proposition> GetAllPropositionNonconfirm(){
        return proposotionService.findallnonconfirm();
    }
    @GetMapping("/GetAllPropositionconfirm")
    @ResponseBody
    public List<Proposition> GetAllPropositionconfirm(){
        return proposotionService.findallconfirm();
    }
    @GetMapping("/GetAllPropositionpreconfirm")
    @ResponseBody
    public List<Proposition> GetAllPropositionpreconfirm(){
        return proposotionService.findallpreconfirm();
    }
    @GetMapping("/GetOneProposition/{Id_proposition}")
    @ResponseBody
    public Proposition GetOneProposition(@PathVariable("Id_proposition") Long Id_Proposition) {
        return proposotionService.RetriveOne(Id_Proposition);
    }

    @PostMapping("/Addproposition")
    @ResponseBody
    public Proposition AddProposition(@RequestBody Proposition p ){

        return proposotionService.AddProposition(p);
    }


    @PutMapping("UpdatePropositionConfirm/{id_proposition}")
    @ResponseBody
    public Proposition Updatepropositionconfirm(@PathVariable("id_proposition" )Long id_proposition) {
        return proposotionService.UpdatePropostionConfirm(id_proposition);
    }

    @PutMapping("UpdatePropositionConfirm/{id_proposition}")
    @ResponseBody
    public Proposition Updatepropositionpreconfirm(@PathVariable("id_proposition" )Long id_proposition) {
        return proposotionService.UpdatePropsitionPreConfirm(id_proposition);
    }
    @DeleteMapping("/DeleteProposition/{id_proposition}")
    @ResponseBody

    public void DeleteProposition(@PathVariable("id_proposition")Long id_proposition){
        proposotionService.DeleteProposition(id_proposition);
    }
    @PutMapping("Updateproposition")
    @ResponseBody
    public Proposition update(@RequestBody Proposition p ) {
        return proposotionService.Update(p);
    }
}
