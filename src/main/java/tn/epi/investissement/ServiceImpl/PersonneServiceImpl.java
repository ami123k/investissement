package tn.epi.investissement.ServiceImpl;

import org.springframework.stereotype.Service;
import tn.epi.investissement.DTO.PersonneDTO;
import tn.epi.investissement.Mapper.PersonneMapper;
import tn.epi.investissement.Models.Personne;
import tn.epi.investissement.Repository.PersonneRepository;
import tn.epi.investissement.Service.PersonneService;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PersonneServiceImpl implements PersonneService {

    private final PersonneRepository repository;
    private final PersonneMapper mapper;

    public PersonneServiceImpl(PersonneRepository repository, PersonneMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public PersonneDTO save(PersonneDTO personneDTO) {

        personneDTO.setAge(Period.between(personneDTO.getDateNaissance(), LocalDate.now()).getYears());
        if (personneDTO.getAge()<150){
            PersonneDTO result = Optional.of(personneDTO)
                    .map(mapper::PersonneDTOToPersonneTarget)
                    .map(repository::save).map(mapper::PersonneToPersonneDTOTarget).orElse(null);

            PersonneDTO result2 = Optional.of(personneDTO)
                    .map(personneDTO1 -> mapper.PersonneDTOToPersonneTarget(personneDTO1))
                    .map(personne -> repository.save(personne)).map(personne -> mapper.PersonneToPersonneDTOTarget(personne)).orElse(null);
            return result;
        }
        else {
            throw new IllegalArgumentException("Invalid age. Age cannot be greater than 150.");
        }
    }
    @Override
    public List<PersonneDTO> Affichage(){
        List<PersonneDTO> p = repository.findAll().stream()
                .sorted(Comparator.comparing(Personne::getNom))
                .map(mapper::PersonneToPersonneDTOTarget)
                .collect(Collectors.toList());
    return p;
    }


    @Override
    public  int calculAge(LocalDate date){
        LocalDate currentDate = LocalDate.now();
      int  age = Period.between(date, currentDate).getYears();
        return  age;
                 }

}
