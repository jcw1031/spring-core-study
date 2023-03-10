package woopaca.core.discount;

import org.springframework.stereotype.Component;
import woopaca.core.member.Grade;
import woopaca.core.member.Member;

@Component
public class FixDiscountPolicy implements DiscountPolicy {

    private final int DISCOUNT_FIX_AMOUNT = 1000; //1000원 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return DISCOUNT_FIX_AMOUNT;
        } else {
            return 0;
        }
    }

}
