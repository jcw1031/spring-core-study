package woopaca.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import woopaca.core.member.Grade;
import woopaca.core.member.Member;
import woopaca.core.member.MemberService;
import woopaca.core.member.MemberServiceImpl;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {

        Long memberId = 1L;
        Member member = new Member(memberId, "Woopaca", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "맥북", 3400000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}
