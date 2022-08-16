package tn.epi.investissement.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.epi.investissement.Entites.Proposition;

import java.util.ArrayList;
import java.util.List;

import tn.epi.investissement.Services.proposotionService;
import tn.epi.investissement.storage.StorageService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)

public class propositionController {
@Autowired
proposotionService proposotionService;
    @Autowired
    UserController UC;
    @Autowired
    projetController PC;
List<String> files = new ArrayList<String>();

@Autowired
StorageService storageService;
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

    @PutMapping("UpdatePropositionpreConfirm/{id_proposition}")
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

    @GetMapping(value = "/listpropbyprojet/{projet_id}" )
    public List<Proposition> findpropobyprojet( @PathVariable(value = "projet_id") Long id){
        return  proposotionService.findpropobyprojet(id);

    }
    @GetMapping(value = "/listpropbyprojetanduser/{projet_id}/{user_id}" )
    public List<Proposition> findpropobyprojet( @PathVariable(value = "projet_id") Long id, @PathVariable (value = "user_id") long user_id){
        return  proposotionService.findpropobyprojetanduser(id,user_id);

    }

    @PostMapping("/{user_id}/addproposition/{id_projet}")
    public void addpropositionA (@PathVariable(value = "user_id") Long id_user, @PathVariable(value = "id_projet") Long id_projet, Proposition e ) {



            e.setUser(UC.user(id_user));
            e.setProjet(PC.GetOneProject(id_projet));
            proposotionService.AddProposition(e);



    }}
