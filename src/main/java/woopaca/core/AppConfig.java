package woopaca.core;

import woopaca.core.discount.FixDiscountPolicy;
import woopaca.core.member.MemberService;
import woopaca.core.member.MemberServiceImpl;
import woopaca.core.member.MemoryMemberRepository;
import woopaca.core.order.OrderService;
import woopaca.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

}
