package com.spring.hello_spring.service;

import com.spring.hello_spring.domain.Member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class MemberServiceTest {
    @AfterEach
    public void cleanStore() {

    }

    /*회원가입하려면 멤버 서비스가 있어야겠지? */
    MemberService memberService = new MemberService();


    @Test
    void 회원가입() {
       //given
        Member member = new Member();
        member.setName("정예은");

        //when
        Long saveId = memberService.join(member);

        //then
        //우리가 찾는게 레포지토리에 있는거 맞아? 확인 검증
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName()
        );


    }

    @Test
    void 회원조회() {
    }

    @Test
    void findOne() {
    }
}