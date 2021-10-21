package com.example.nuxtmanual_bo.repository;


import com.example.nuxtmanual_bo.domain.Member;

public interface MemberRepositorySupport {

//    MemberDto.loginMemberResponse findMemberByUsernameAndPassword(MemberDto.loginMember loginMember);

    Member findMemberByUsername(String username);
}
