package intercore.data;

import intercore.domain.Member;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MemberRepository extends PagingAndSortingRepository<Member, Long>, CrudRepository<Member, Long> {
    @Query(nativeQuery = true, value = "select m.* from member m where m.on_team = false and m.disciplines[1] like %?1%")
    List<Member> findByMember(String type);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "update member set on_team = true where id = :id")
    void updateOnTeam(@Param("id") long id);
}
