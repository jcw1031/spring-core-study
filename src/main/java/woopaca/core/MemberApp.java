package woopaca.core;

import woopaca.core.member.Grade;
import woopaca.core.member.Member;
import woopaca.core.member.MemberService;
import woopaca.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {

        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "woopaca", Grade.VIP);

        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("join member = " + member.getName());
        System.out.println("find member = " + findMember.getName());

    }
}
