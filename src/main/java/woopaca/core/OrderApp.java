package woopaca.core;

import woopaca.core.member.Grade;
import woopaca.core.member.Member;
import woopaca.core.member.MemberService;
import woopaca.core.order.Order;
import woopaca.core.order.OrderService;

public class OrderApp {
    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "Woopaca", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "맥북", 3400000);

        System.out.println("order = " + order);
        System.out.println("calculate price = " + order.calculatePrice());

    }
}
