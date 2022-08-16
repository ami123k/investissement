package tn.epi.investissement.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.epi.investissement.Entites.avis;
import tn.epi.investissement.Services.avisService;

import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
public class avisController {

    @Autowired
    avisService avisService;


    @GetMapping("/GetAllAvis")
    @ResponseBody
    public List<avis> GetAllAvis() {
        return avisService.RetriveAll();
    }

    @GetMapping("/GetOneAvis/{Id_Avis}")
    @ResponseBody
    public avis GetOneAvis(@PathVariable("Id_Avis") Long Id_Avis) {
        return avisService.RetriveOne(Id_Avis);
    }

@PostMapping("/AddAvis")
    @ResponseBody
    public avis AddAvis(@RequestBody avis a ){
        return avisService.AddOrUpdateavis(a);
}
@PutMapping("UpdateAvis")
    @ResponseBody
    public avis UpdateAvis(@RequestBody avis a ){
        return avisService.AddOrUpdateavis(a);
}
@DeleteMapping("/DeleteAvis/{Id_Avis}")
    @ResponseBody
    public void DeleteAvis(@PathVariable("Id_Avis")Long Id_Avis){
        avisService.Deleteavis(Id_Avis);
}




}
