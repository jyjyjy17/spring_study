package springstudy.spring01.service;

import springstudy.spring01.domain.Member;
import springstudy.spring01.repository.MemberRepository;
import springstudy.spring01.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository;
    MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
    /**
     * 회원가입
     */
    public Long join(Member member){
        validateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateMember(Member member) {
        //OPTIONAL을 반환 하는 걸 권장하지 않음.
        memberRepository.findByName(member.getName()).ifPresent(m->{
             throw new IllegalStateException("이미 존재하는 회원임 ㅇㅇ");
         });
    }

    /**
    * 전체 회원 조회
    * */
    public List<Member> findMember(){
        return memberRepository.findAll() ;
    }
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
