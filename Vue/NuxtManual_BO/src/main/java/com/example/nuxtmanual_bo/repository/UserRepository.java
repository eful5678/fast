package com.example.nuxtmanual_bo.repository;

import com.example.nuxtmanual_bo.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByUsername(String username);
}
