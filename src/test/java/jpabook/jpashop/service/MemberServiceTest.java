package jpabook.jpashop.service;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)      // Junit & Srping Boot 테스트
@SpringBootTest     // Spring Boot 위에서 테스트
@Transactional      // 테스트 케이스에 있으면 기본적으로 Rollback
public class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
    @Autowired EntityManager em;

    @Test
//    @Rollback(false)      // 롤백 안 하고 commit
    public void 회원가입(){
        // given
        Member member = new Member();
        member.setName("Jang");

        // when
        Long savedId = memberService.join(member);

        // then
//        em.flush();
        assertEquals(member, memberRepository.findOne(savedId));
    }

    @Test(expected = IllegalStateException.class)
    public void 중복_예외_회원(){
        // given
        Member member1 = new Member();
        member1.setName("Jang");

        Member member2 = new Member();
        member2.setName("Jang");

        // when
        memberService.join(member1);
        memberService.join(member2);

        // (expected = IllegalStatementException.class)로 대체
//        try{
//            memberService.join(member2);
//        }catch (IllegalStatementException e){
//            return;
//        }

        //then
        fail("예외가 발생해야 한다.");
    }
}