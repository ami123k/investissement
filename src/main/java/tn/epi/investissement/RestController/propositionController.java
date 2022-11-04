package tn.epi.investissement.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.*;
import tn.epi.investissement.Entites.Proposition;
import org.springframework.context.annotation.Bean;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import tn.epi.investissement.Entites.User;
import tn.epi.investissement.Services.proposotionService;
import tn.epi.investissement.storage.StorageService;
import tn.epi.investissement.repository.propositionRepository;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)

public class propositionController {
@Autowired
proposotionService proposotionService;
    @Autowired
    UserController UC;
    @Autowired
    @Lazy
    private JavaMailSender jms;
    @Autowired
    propositionRepository PR;
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
    @GetMapping("/GetAllPropositionNonconfirm/{user_id}")
    @ResponseBody
    public List<Proposition> GetAllPropositionNonconfirm(@PathVariable("user_id")long user_id){
        return proposotionService.findallnonconfirm(user_id);
    }
    @GetMapping("/GetAllPropositionconfirm/{user_id}")
    @ResponseBody
    public List<Proposition> GetAllPropositionconfirm(@PathVariable("user_id")long user_id){
        return proposotionService.findallconfirm(user_id);
    }
    @GetMapping("/GetAllPropositionpreconfirm/{user_id}")
    @ResponseBody
    public List<Proposition> GetAllPropositionpreconfirm(@PathVariable("user_id")long user_id){
        return proposotionService.findallpreconfirm(user_id);
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
        SimpleMailMessage msg = new SimpleMailMessage();
        Proposition propo = GetOneProposition(id_proposition);

    /*    msg.setTo(propo.getUser().getEmail());

        msg.setSubject("bonjour votre proposition de  "+propo.getProjet().getNom());
        msg.setText("votre proposition de  "+propo.getProjet().getNom()+"est accepter veuillez visiter notre site web rubrique proposition confirmer");

        jms.send(msg);

      */  return proposotionService.UpdatePropsitionPreConfirm(id_proposition);
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
    @GetMapping(value = "/finduserbyproposition/{proposition_id}" )
    public String finduserbyproposition(@PathVariable(value = "proposition_id") Long id){

        return UC.user( PR.getUserbyproposition(id)).getUsername();
    }
    @PostMapping("/{user_id}/addproposition/{id_projet}")
    public void addpropositionA (@PathVariable(value = "user_id") Long id_user, @PathVariable(value = "id_projet") Long id_projet, Proposition e ) {


            e.setDate(LocalDate.now());
            e.setUser(UC.user(id_user));
            e.setProjet(PC.GetOneProject(id_projet));
            proposotionService.AddProposition(e);



    }


    @Bean
    public JavaMailSender getJavaMailSender() {

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("");
        mailSender.setPassword("");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }
    @GetMapping(value = "/finduserbyprojetproposition/{projet_id}/{user_id}" )
    public Boolean finduserbyprojetproposition(@PathVariable(value = "projet_id") Long projet_id,@PathVariable(value = "user_id")Long user_id) {
        User user = UC.user(user_id);
        try {
            if (user == PR.getUserbypropositionprojet(projet_id).get(0)) {
                System.out.println("true *************************************************************************************************");
                return true;

            }
        } catch (Exception e) {
            System.out.println("false *************************************************************************************************");

            return false;

        }
        return false;

    }

}
