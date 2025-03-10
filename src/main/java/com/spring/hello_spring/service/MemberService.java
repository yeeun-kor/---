package com.spring.hello_spring.service;

import com.spring.hello_spring.domain.Member;
import com.spring.hello_spring.repository.MemberRepository;
import com.spring.hello_spring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //회원서비스개발 1. 회원가입
    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    //note 중복회원 검사하는 로직
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원");
        });
    }

    //2. 전체회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    //3. 사람 한명찾기
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
