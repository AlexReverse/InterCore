package intercore.restclient;

import intercore.Discipline;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.client.Traverson;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestOperations;

@Slf4j
public class InterCoreClient {

    private RestOperations rest;

    public InterCoreClient(RestOperations rest){
        this.rest=rest;
    }
    public Discipline getDisciplineById(String disciplineId) {
        ResponseEntity<Discipline> responseEntity = rest.getForEntity("http://localhost:8080/disciplines/{id}", Discipline.class, disciplineId);
        log.info("Fetched time: {}", responseEntity.getHeaders().getDate());
        return responseEntity.getBody();
    }

    public void updateDiscipline(Discipline discipline){
        rest.put("http://localhost:8080/disciplines/{id}", discipline, discipline.getId());
    }

    public void deleteDiscipline(Discipline discipline){
        rest.delete("http://localhost:8080/disciplines/{id}", discipline.getId());
    }

    public Discipline createDiscipline(Discipline discipline){
        ResponseEntity<Discipline> responseEntity = rest.postForEntity("http://localhost:8080/disciplines/{id}", discipline, Discipline.class);
        log.info("New resource created at: {}", responseEntity.getHeaders().getLocation());
        return responseEntity.getBody();
    }
}
