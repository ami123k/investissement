package tn.epi.investissement.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.epi.investissement.Entites.Proposition;
import tn.epi.investissement.Entites.contrat;
import tn.epi.investissement.storage.StorageService;
import tn.epi.investissement.repository.contratRepository;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
public class ContratController {


    @Autowired
    StorageService storageService;
    List<String> files = new ArrayList<String>();

@Autowired
contratRepository cr ;
    @Autowired
    tn.epi.investissement.Services.projetService projetService;
    @Autowired
    UserController US;
    @Autowired
    projetController PC;
    @PostMapping("/AddContrat/{id_user}/{id_projet}")
    @ResponseBody
    public ResponseEntity<String> addprojet(@RequestParam("signature_investisseur") MultipartFile signature_investisseur  , @PathVariable("id_user" )long id_user,@PathVariable("id_projet" ) long id_projet, contrat c  )
    {
        String message = "";
        try {
            storageService.store(signature_investisseur);
            files.add(signature_investisseur.getOriginalFilename());
            message = "You successfully uploaded " + signature_investisseur.getOriginalFilename() + "!";
            System.out.println(message);

            c.setSingature_investisseur(signature_investisseur.getOriginalFilename());
            c.setSignature_entrepreneur("attente");
            c.setUser(US.user(id_user));
            c.setProjet(PC.GetOneProject(id_projet));
            cr.save(c);
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            message = "FAIL to upload " + signature_investisseur.getOriginalFilename() + "!";
            System.out.println(message);

            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }

    }
    @PutMapping("/UpdateContrat/{id_contrat}")
    @ResponseBody
    public ResponseEntity<String> addprojet(@RequestParam("signature_entrepreneur") MultipartFile signature_entrepreneur  ,@PathVariable("id_contrat") long id_contrat  )
    {
        contrat c = cr.findById(id_contrat).get();
        String message = "";
        try {
            storageService.store(signature_entrepreneur);
            files.add(signature_entrepreneur.getOriginalFilename());
            message = "You successfully uploaded " + signature_entrepreneur.getOriginalFilename() + "!";
            System.out.println(message);

            c.setSignature_entrepreneur(signature_entrepreneur.getOriginalFilename());
            c.setSingature_investisseur(c.getSingature_investisseur());
            c.setUser(c.getUser());
            c.setProjet(c.getProjet());
            c.setTitre(c.getTitre());
            c.setId_contrat(c.getId_contrat());
            c.setDescription(c.getDescription());
            c.setMontant(c.getMontant());

            cr.save(c);
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            message = "FAIL to upload " + signature_entrepreneur.getOriginalFilename() + "!";
            System.out.println(message);

            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }

    }
    @GetMapping(value = "/contratByprojet/{projet_id}" )
    public List<contrat> findcontratByprojet(@PathVariable(value = "projet_id") Long id) {
        return cr.findcontratbyprojet(id);
    }
    @GetMapping(value = "/findpropositioncontrat/{projet_id}/{user_id}" )
    public List<tn.epi.investissement.Entites.Proposition> findpropositioncontrat(@PathVariable(value = "projet_id") Long projet_id, @PathVariable(value = "user_id") Long id_user) {
        return cr.findpropositioncontrat(projet_id,id_user);
    }
}
