package woopaca.core;

import woopaca.core.discount.DiscountPolicy;
import woopaca.core.discount.FixDiscountPolicy;
import woopaca.core.discount.RateDiscountPolicy;
import woopaca.core.member.MemberRepository;
import woopaca.core.member.MemberService;
import woopaca.core.member.MemberServiceImpl;
import woopaca.core.member.MemoryMemberRepository;
import woopaca.core.order.OrderService;
import woopaca.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
