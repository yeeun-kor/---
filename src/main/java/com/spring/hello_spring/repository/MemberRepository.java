package com.spring.hello_spring.repository;

import com.spring.hello_spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // 회원 정보를 저장하고, 저장된 Member 객체를 반환하는 메서드
    Optional<Member> findById(Long id); // 주어진 id에 해당하는 회원을 조회하는 메서드 (Optional로 감싸져 있어, 값이 없을 수도 있음)
    Optional<Member> findByName(String name); // 주어진 name에 해당하는 회원을 조회하는 메서드
    List<Member> findAll(); // 저장소에 저장된 모든 회원 정보를 리스트로 반환하는 메서드
}
