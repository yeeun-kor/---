package com.spring.hello_spring.repository;

import com.spring.hello_spring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{
    //인터페이스에서 얻어온 메모리 저장하는 곳
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence =0L; /*시퀀스 저장*/



    @Override
    //멤버 저장하는 로직
    public Member save(Member member) {
        member.setId(++sequence);//저장시, 멤버ID의 시퀀스 값을 하나씩 올림.
        store.put(member.getId(), member); //시퀀스 올린 멤버ID를 put해서 Map에 저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        //  Map의 store에서 ID값 꺼내오기
        //null값이 나올 가능성이 있으면, 감싸서 반환해줌,
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        //Map에서 loop를 돌리면서 filter by name 하기
        //findAny는 뭐지?
        return store.values().stream().filter(member-> member.getName().equals(name)).findAny();

    }

    @Override
    public List<Member> findAll() {
        //store(Map)에 저장된 객체들을  List 타입으로 꺼내옴
        return new ArrayList<>(store.values());
    }
}
