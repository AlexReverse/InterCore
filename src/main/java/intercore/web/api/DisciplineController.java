package intercore.web.api;

import intercore.domain.Discipline;
import intercore.data.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/disciplines", produces = "application/json")
@CrossOrigin(origins = "http://localhost:8080")
public class DisciplineController {

    private DisciplineRepository disciplineRepository;

    @Autowired
    public DisciplineController(DisciplineRepository disciplineRepository){
        this.disciplineRepository=disciplineRepository;
    }

    @GetMapping
    @PreAuthorize("#hasRole('USER')")
    public Iterable<Discipline> allDisciplines() {
        return disciplineRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("#hasRole('USER')")
    public Discipline saveDiscipline(@RequestBody Discipline discipline) {
        return disciplineRepository.save(discipline);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("#hasRole('USER')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteDiscipline(@PathVariable("id") String disciplineId) {
        disciplineRepository.deleteById(disciplineId);
    }
}
