package intercore.data;

import intercore.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MemberRepository  extends PagingAndSortingRepository<Member, Long>, CrudRepository<Member, Long> {
}
