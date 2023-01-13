package woopaca.core.discount;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import woopaca.core.member.Grade;
import woopaca.core.member.Member;

@Component
@Primary
public class RateDiscountPolicy implements DiscountPolicy {

    private final int DISCOUNT_PERCENT = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * DISCOUNT_PERCENT / 100;
        } else {
            return 0;
        }
    }
}


