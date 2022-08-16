package tn.epi.investissement.Services;

import org.springframework.stereotype.Service;
import tn.epi.investissement.Entites.User;
import tn.epi.investissement.repository.UserRepository;

import java.util.Optional;

@Service

public class UserServiceImp implements UserService {
UserRepository userRepository;
    public User findbyid(long id) {
        return  userRepository.findById(id).get();
    }

}
