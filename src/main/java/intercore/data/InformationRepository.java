package intercore.data;

import intercore.MemberInformation;
import org.springframework.data.repository.CrudRepository;

public interface InformationRepository extends CrudRepository<MemberInformation, Long> {
}
