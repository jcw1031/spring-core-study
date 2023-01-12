package woopaca.core.order;

import org.junit.jupiter.api.Test;
import woopaca.core.discount.RateDiscountPolicy;
import woopaca.core.member.Grade;
import woopaca.core.member.Member;
import woopaca.core.member.MemberRepository;
import woopaca.core.member.MemoryMemberRepository;

import static org.assertj.core.api.Assertions.assertThat;

class OrderServiceImplTest {

    @Test
    void createOrder() {
        MemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "woopaca", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new RateDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 50000);
        assertThat(order.getDiscountPrice()).isEqualTo(5000);
    }

}