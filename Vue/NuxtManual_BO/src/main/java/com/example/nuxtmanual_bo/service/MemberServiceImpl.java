package com.example.nuxtmanual_bo.service;

import com.example.nuxtmanual_bo.domain.Member;
import com.example.nuxtmanual_bo.model.MemberDto;
import com.example.nuxtmanual_bo.repository.MemberRepositoryManager;
import com.example.nuxtmanual_bo.repository.MemberRepositorySupport;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    @NonNull
    private final MemberRepositoryManager memberRepositoryManager;

    @NonNull
    private final MemberRepositorySupport memberRepositorySupport;

    public Member insertMember(MemberDto.insertMember insertMember){

        final Member member = memberRepositoryManager.insertMember(insertMember);

        return member;
    }

//    @Override
//    public MemberDto.loginMemberResponse loginMember(MemberDto.loginMember loginMember) {
//
//        MemberDto.loginMemberResponse member = memberRepositorySupport.findMemberByUsernameAndPassword(loginMember);
//        if(member.getUsername() != null){
//            return member;
//        }else{
//            return null;
////            System.out.println("login 실패");
//        }
////
//        Member member = memberRepositorySupport.findMemberByUsernameAndPassword(loginMember);
////        MemberDto.loginMemberResponse()
//        System.out.println(member.getUsername());
//
//        return new MemberDto.loginMemberResponse(member.getUsername(), member.getPassword());
//
//    }
}
