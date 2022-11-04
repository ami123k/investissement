package tn.epi.investissement.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import tn.epi.investissement.Entites.avis;
import tn.epi.investissement.Entites.User;

import tn.epi.investissement.Entites.projet;
import tn.epi.investissement.Entites.categorie;
import tn.epi.investissement.storage.StorageService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
public class projetController {
    @Autowired
    StorageService storageService;
    List<String> files = new ArrayList<String>();


    @Autowired
    tn.epi.investissement.Services.projetService projetService;
@Autowired
UserController US;
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
    @GetMapping("/finduserbyprojet/{Id_Project}")
    @ResponseBody
    public User finduserbyprojet(@PathVariable("Id_Project") Long Id_Project) {
        return projetService.finduserbyprojet(Id_Project);
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
/*ajout*/
@PostMapping("/AddProject/{id_user}")
@ResponseBody
public ResponseEntity<String> addprojet(@RequestParam("file") MultipartFile image , @PathVariable("id_user" )long id_user , projet p  )
{
    String message = "";
    try {

        storageService.store(image);
        files.add(image.getOriginalFilename());
        message = "You successfully uploaded " + image.getOriginalFilename() + "!";
        System.out.println(message);
        p.setImage(image.getOriginalFilename());
        p.setUser(US.user(id_user));
        projetService.AddProjetNonConfirm(p);
        return ResponseEntity.status(HttpStatus.OK).body(message);
    } catch (Exception e) {
        message = "FAIL to upload " + image.getOriginalFilename() + "!";
        System.out.println(message);

        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
    }

}
    @GetMapping("/getallfiles")
    public List<String> getListFiles() {
        List<String> fileNames = files
                .stream().map(fileName -> MvcUriComponentsBuilder
                        .fromMethodName(projetController.class, "getFile", fileName).build().toString())
                .collect(Collectors.toList());
        return files;}

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
    Resource file = storageService.loadFile(filename);
    return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
            .body(file);
}

}




















