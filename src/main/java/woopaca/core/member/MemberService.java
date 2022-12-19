package woopaca.core.member;

public interface MemberService extends MemberRepository {

    void join(Member member);

    Member findMember(Long memberId);
}
