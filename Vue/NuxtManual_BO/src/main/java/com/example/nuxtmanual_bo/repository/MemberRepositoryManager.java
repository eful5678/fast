package com.example.nuxtmanual_bo.repository;

import com.example.nuxtmanual_bo.domain.Member;
import com.example.nuxtmanual_bo.model.MemberDto;

public interface MemberRepositoryManager {

    Member insertMember(MemberDto.insertMember member);
}
