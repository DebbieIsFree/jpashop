package jpabook.jpashop;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jpabook.jpashop.domain.Member;
import org.springframework.stereotype.Repository;


@Repository     // 컴포넌트 스캔 대상, 자동으로 스프링 빈 등록
public class MemberRepository {

    // build.gradle --> spring-boot-starter-data-jpa
    // 스프링 부트 사용 -> 모든 것이 스프링 컨테이너 위에서 동작
    // --> 스프링 부트가 entity manager 주입
    @PersistenceContext private EntityManager em;

    public Long save(Member member){
        em.persist(member);
        return member.getId();
    }

    public Member find(Long id){
        return em.find(Member.class, id);
    }
}
