package intercore.web.api;

import intercore.domain.MemberInformation;
import intercore.data.InformationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path="/api/information", produces = "application/json")
@CrossOrigin(origins = {"http://localhost:8080"})
public class InformationApiController {

    private InformationRepository informationRepository;

    public InformationApiController(InformationRepository informationRepository) {
        this.informationRepository=informationRepository;
    }

    @GetMapping(produces="application/json")
    public Iterable<MemberInformation> allInformation(){
        return informationRepository.findAll();
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public MemberInformation postInformation(@RequestBody MemberInformation information){
        return informationRepository.save(information);
    }

    @PutMapping(path = "/{informationId}", consumes = "application/json")
    public MemberInformation putInformation(@PathVariable("informationId") Long informationId, @RequestBody MemberInformation information) {
        information.setId(informationId);
        return informationRepository.save(information);
    }

    @PatchMapping(path = "informationId", consumes = "application/json")
    public MemberInformation patchInformation(@PathVariable("informationId") Long informationId, @RequestBody MemberInformation patch) {
        MemberInformation information = informationRepository.findById(informationId).get();
        if (patch.getSurname() != null) {
            information.setSurname(patch.getSurname());
        }
        if (patch.getRealName() != null) {
            information.setRealName(patch.getRealName());
        }
        if (patch.getSpeciality() != null) {
            information.setSpeciality(patch.getSpeciality());
        }
        if (patch.getRating() != null) {
            information.setRating(patch.getRating());
        }
        if (patch.getDiscord() != null) {
            information.setDiscord(patch.getDiscord());
        }
        if (patch.getBirthday() != null) {
            information.setBirthday(patch.getBirthday());
        }
        return informationRepository.save(information);
    }

    @DeleteMapping(path = "informationId", consumes = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteInformation(@PathVariable("informationId") Long informationId){
        try {
            informationRepository.deleteById(informationId);
        } catch (EmptyResultDataAccessException e) {
            log.info("This member was not found: " + e);
            /* #TODO */
        }
    }
}
