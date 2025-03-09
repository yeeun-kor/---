package com.spring.hello_spring.repository;

import com.spring.hello_spring.domain.Member;
import org.junit.jupiter.api.Test;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save(){
        //저장하고 싶은 회원의 정보들 넣기
        Member member = new Member();
        member.setName("정예은");

        //리포지토리에 멤버 세이브
        repository.save(member);

        //검증하기 ( save 할때 시퀀스 id 증가하기 했으니깐, 제대로 시퀀스 되어있나 확인 해보기 )
        Member result =  repository.findById(member.getId()).get();
        System.out.println("result = "+(result ==member));
        System.out.println("result = "+result);
    }
}
