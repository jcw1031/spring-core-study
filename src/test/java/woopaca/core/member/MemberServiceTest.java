package woopaca.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        //given -> 어떠한 것이 주어지고
        Member member = new Member(1L, "woopaca", Grade.VIP);

        //when -> 이렇게 했을 때
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then -> 이런 식으로 된다
        Assertions.assertThat(member).isEqualTo(findMember);

    }
}
