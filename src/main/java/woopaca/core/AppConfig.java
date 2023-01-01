package woopaca.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import woopaca.core.discount.DiscountPolicy;
import woopaca.core.discount.RateDiscountPolicy;
import woopaca.core.member.MemberRepository;
import woopaca.core.member.MemberService;
import woopaca.core.member.MemberServiceImpl;
import woopaca.core.member.MemoryMemberRepository;
import woopaca.core.order.OrderService;
import woopaca.core.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
