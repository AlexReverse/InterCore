package intercore.data;

import intercore.domain.Discipline;
import org.springframework.data.repository.CrudRepository;

public interface DisciplineRepository extends CrudRepository<Discipline, String> {
}
