package intercore.web.api;

import intercore.Discipline;
import intercore.data.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Iterable<Discipline> allDisciplines() {
        return disciplineRepository.findAll();
    }
}
