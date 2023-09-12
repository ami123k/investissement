package tn.epi.investissement.Resource;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;
import tn.epi.investissement.DTO.PersonneDTO;
import tn.epi.investissement.Service.PersonneService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/person")
@Api(value = "TEST")
public class PersonneResource {
    private final PersonneService service;

    public PersonneResource(PersonneService service) {
        this.service = service;
    }

    @ApiOperation(value = "Create a person")
    @PostMapping()
    public PersonneDTO create(@RequestBody PersonneDTO personneDTO){

        try {
            PersonneDTO result = service.save(personneDTO);
            return result;
        } catch (DuplicateKeyException e) {
            throw new IllegalArgumentException("duplicate key");
        }
    }
    @ApiOperation(value = "get all Persons")
    @GetMapping()
    public List<PersonneDTO> getAllperson() {
        return service.Affichage();
    }

}
