package intercore.data;

import intercore.domain.Discipline;
import intercore.domain.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface MemberRepository extends PagingAndSortingRepository<Member, Long>, CrudRepository<Member, Long> {
    List<Member> findByDisciplinesIsStartingWith(Discipline.Type type);
}
