package tn.epi.investissement.Service;

import tn.epi.investissement.DTO.PersonneDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface PersonneService {
    PersonneDTO save(PersonneDTO personneDTO);

    List<PersonneDTO> Affichage();

    int calculAge(LocalDate date);
}
