package com.example.nuxtmanual_bo.service;

import com.example.nuxtmanual_bo.domain.Member;
import com.example.nuxtmanual_bo.model.MemberDto;

public interface MemberService{

    Member insertMember(MemberDto.insertMember member);

//    MemberDto.loginMemberResponse loginMember(MemberDto.loginMember loginMember);
}
