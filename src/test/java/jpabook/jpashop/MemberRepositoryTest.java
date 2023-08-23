package jpabook.jpashop;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;



@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;

    @Test
    @Transactional      // 엔터티 매니저를 통한 모든 데이터 변경은 Transaction 안에서 발생해야 한다.
    @Rollback(false)    // 롤백 안 하고 커밋
    public void testMember() throws Exception {
        //given
        Member member = new Member();
        member.setUsername("memberA");

        //when
        Long savedId = memberRepository.save(member);
        Member findmember = memberRepository.find(savedId);;

        //then
        Assertions.assertThat(findmember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findmember.getUsername()).isEqualTo(member.getUsername());
        Assertions.assertThat(findmember).isEqualTo(member);
    }
}