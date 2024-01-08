package intercore.data;

import intercore.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository  extends CrudRepository<Member, Long> {
}
