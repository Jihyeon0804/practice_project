package com.practice.practice.author.controller;

import com.practice.practice.author.domain.Author;
import com.practice.practice.author.dto.AuthorSignUpDTO;
import com.practice.practice.author.dto.AuthorUpdateDTO;
import com.practice.practice.author.dto.CommonDTO;
import com.practice.practice.author.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;
    
    // 회원가입
    @PostMapping("/signUp")
    public ResponseEntity<?> signUp(@RequestBody AuthorSignUpDTO authorSignUpDTO) {
        authorService.signUp(authorSignUpDTO);
        return new ResponseEntity<>("회원 가입 완료", HttpStatus.CREATED);
    }
    
    // 회원 목록 조회
    @GetMapping("/list")
    public List<Author> findAll() {
        return authorService.findAll();
    }
    
    // 회원 상세 조회
    @GetMapping("/detail/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
//        return authorService.findById(id);
        return new ResponseEntity<>(new CommonDTO(authorService.findById(id)
                , HttpStatus.OK.value(), "회원 조회 성공"), HttpStatus.OK);
    }
    
    // 회원 비밀번호 변경
    @PatchMapping("/updatePassword")
    public ResponseEntity<?> updatePassword(@RequestBody AuthorUpdateDTO authorUpdateDTO) {
        authorService.updatePassword(authorUpdateDTO);
        return new ResponseEntity<>("비밀번호 변경 완료", HttpStatus.OK);
    }

    // 회원 탈퇴
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        authorService.delete(id);
        return new ResponseEntity<>("회원 탈퇴 완료", HttpStatus.OK);
    }
}
