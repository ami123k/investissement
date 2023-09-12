package tn.epi.investissement.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.epi.investissement.DTO.PersonneDTO;
import tn.epi.investissement.Models.Personne;
import tn.epi.investissement.Service.PersonneService;
import tn.epi.investissement.datetoinit;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

@Mapper(componentModel = "spring")

public interface PersonneMapper {

    Personne PersonneDTOToPersonneTarget(PersonneDTO source);
    @Mapping(source = "dateNaissance", target = "age", qualifiedBy = datetoinit.class)
    PersonneDTO PersonneToPersonneDTOTarget(Personne source);
    @datetoinit
    default int mapDateToInt(LocalDate dateNaissance) {
        return Period.between(dateNaissance, LocalDate.now()).getYears();
    }
}
