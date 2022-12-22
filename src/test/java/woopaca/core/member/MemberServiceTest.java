package woopaca.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import woopaca.core.AppConfig;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach // 각 테스트가 시작되기 전에 무조건 실행되는 부분
    void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

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
