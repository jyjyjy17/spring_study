package springstudy.spring01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springstudy.spring01.domain.Member;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    //JPQL select m from Member m where m.name = ?
    Optional<Member> findByName(String name);
}