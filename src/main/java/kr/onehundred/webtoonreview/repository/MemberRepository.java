package kr.onehundred.webtoonreview.repository;

import kr.onehundred.webtoonreview.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    
    //이메일로 사용자를 찾는 멤버함수(구현은 알아서 해줌)
    Member findByEmail(String email);
}