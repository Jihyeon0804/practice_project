package com.practice.practice.author.service;

import com.practice.practice.author.domain.Author;
import com.practice.practice.author.dto.AuthorDetailDTO;
import com.practice.practice.author.dto.AuthorSignUpDTO;
import com.practice.practice.author.dto.AuthorUpdateDTO;
import com.practice.practice.author.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    // 회원 가입
    public void signUp(AuthorSignUpDTO authorSignUpDTO) {
        
        // 이메일 중복인 경우
        if (authorRepository.findByEmail(authorSignUpDTO.getEmail()).isPresent()) {
            throw new IllegalArgumentException("이미 가입된 이메일입니다.");
        }
        Author author = authorSignUpDTO.authorToEntity();
        authorRepository.save(author);
    }

    // 회원 목록 조회
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    // 회원 상세 조회 (by ID)
    public AuthorDetailDTO findById(Long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new NoSuchElementException("존재하지 않는 ID입니다."));
        return AuthorDetailDTO.authorFromEntity(author);
    }

    // 비밀번호 수정
    public void updatePassword(AuthorUpdateDTO authorUpdateDTO) {
        Author author = authorRepository.findByEmail(authorUpdateDTO.getEmail()).orElseThrow(() -> new NoSuchElementException("존재하지 않는 이메일입니다."));
        author.updatePassword(authorUpdateDTO.getPassword());
    }

    // 회원 탈퇴
    public void delete(Long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new NoSuchElementException("존재하지 않는 ID입니다."));
        authorRepository.delete(author);
    }

}
