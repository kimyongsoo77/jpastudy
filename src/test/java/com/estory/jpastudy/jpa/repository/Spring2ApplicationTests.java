package com.estory.jpastudy.jpa.repository;

import com.estory.jpastudy.jpa.entity.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Spring2ApplicationTests {

    private final MemberRepository memberRepository;

    // 의존성 주입
    @Autowired
    public Spring2ApplicationTests(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Test
    void memberTest() {
        // 멤버 저장
        Member member = new Member();
        member.setName("nameTestAAAAAA");
        member.setAddress("seoulAAAAAA");
        memberRepository.save(member);

        // 저장한 멤버 아이디로 검색
        Member findMember = memberRepository.findById(member.getId()).get();
        System.out.println(findMember.getAddress());
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());

    }
}