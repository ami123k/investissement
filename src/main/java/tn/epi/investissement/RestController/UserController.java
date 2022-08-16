package tn.epi.investissement.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.epi.investissement.Entites.Proposition;
import tn.epi.investissement.Entites.User;
import tn.epi.investissement.Services.UserService;
import tn.epi.investissement.Services.proposotionService;
import tn.epi.investissement.repository.UserRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {
    @Autowired
    UserService userService ;
    @Autowired
    UserRepository UR;
    @GetMapping(value = "/user/{id}" )
    public User user(@PathVariable(name = "id") Long id ) {
        return UR.findById(id).get();
    }


}
