package com.spring.hello_spring.service;

import com.spring.hello_spring.domain.Member;

import com.spring.hello_spring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository memberRepository;


    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }



    @AfterEach
    public void afterEach() {

        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("김진규");

        //when
        Long saveId = memberService.join(member);

        //then
        //우리가 찾는게 레포지토리에 있는거 맞아? 확인 검증
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());


    }

    @Test
    public void 중복_회원_예외_확인() {
        //given
        Member member1 = new Member();
        member1.setName("김진규");

        Member member2 = new Member();
        member2.setName("김진규");

        //when
        memberService.join(member1);
        Assertions.assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        //then


    }

    @Test
    void 회원조회() {
    }

    @Test
    void findOne() {
    }
}