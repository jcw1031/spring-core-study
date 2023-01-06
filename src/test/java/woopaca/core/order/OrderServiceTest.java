package woopaca.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import woopaca.core.AppConfig;
import woopaca.core.member.Grade;
import woopaca.core.member.Member;
import woopaca.core.member.MemberService;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {

        Long memberId = 1L;
        Member member = new Member(memberId, "Woopaca", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "맥북", 3400000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(340000);
    }

}
