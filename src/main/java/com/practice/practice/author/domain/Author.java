package com.practice.practice.author.domain;

import com.practice.practice.author.dto.AuthorDetailDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

// @Builder를 통해 유연하게 객체 생성 가능 (@AllArgsConstructor 반드시 있어야 함)
@Builder
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)        // db의 문자열 형태로 저장
    @Builder.Default                    // 빌더 패턴에서 변수 초기화(디폴트 값) 시 @Builder.Default 필수
    private Role role = Role.USER;      // 기본값을 user로 설정, 값이 할당되면 해당 값으로 세팅

    @CreationTimestamp
    private LocalDateTime createdTime;

    @UpdateTimestamp
    private LocalDateTime updatedTime;

//    public Author (String name, String email, String password) {
//        this.name = name;
//        this.email = email;
//        this.password = password;
//    }



    public void updatePassword(String password) {
        this.password = password;
    }
}
