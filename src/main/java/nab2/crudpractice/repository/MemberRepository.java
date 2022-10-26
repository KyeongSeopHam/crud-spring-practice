package nab2.crudpractice.repository;

import nab2.crudpractice.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    // JPA 쿼리메소드
    List<Member> findAllById(Long memberNumber);
}
