package tennis.practice.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tennis.practice.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryInterface {

  @Query("select m from Member m where m.longinId = :loginId")
  Optional<Member> findByLoginId(@Param("loginId") String loginId);

}
