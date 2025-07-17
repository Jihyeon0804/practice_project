package com.practice.practice.author.repository;

import com.practice.practice.author.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {


    // 회원 상세 조회 (by Email)
    Optional<Author> findByEmail(String email);


}
