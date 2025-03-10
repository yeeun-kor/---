package com.spring.hello_spring.repository;

import com.spring.hello_spring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;


import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }


    @Test
    public void save() {
        //저장하고 싶은 회원의 정보들 넣기
        Member member = new Member();
        member.setName("정예은");

        //리포지토리에 멤버 세이브
        repository.save(member);

        //검증하기 ( save 할때 시퀀스 id 증가하기 했으니깐, 제대로 시퀀스 되어있나 확인 해보기 )
        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);

    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("스프링");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("인텔리제이");
        repository.save(member2);

        Member result = repository.findByName("스프링").get();
        assertThat(result).isEqualTo(member1);

    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("스프링");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("인텔리제이");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }


}
