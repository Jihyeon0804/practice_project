package com.practice.practice.author.dto;

import com.practice.practice.author.domain.Author;
import com.practice.practice.author.domain.Role;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorSignUpDTO {

    @NotEmpty(message = "이름은 필수 입력 항목입니다.")
    private String name;

    @NotEmpty(message = "이메일 필수 입력 항목입니다.")
    private String email;

    @NotEmpty(message = "password 필수 입력 항목입니다.")
    @Size(min = 8, message = "비밀번호는 8자 이상으로 입력해주세요.")     // 최소 길이 설정
    private String password;

    // 문자열로 값이 넘어오면 Role에 값으로 매핑
    private Role role = Role.USER;

//    public Author authorToEntity() {
//        return new Author(this.name, this.email, this.password, this.role);
//    }
    
    
    public Author authorToEntity() {
        // ⭐ 빌더 패턴은 매개 변수의 개수와 매개 변수의 순서에 상관 없이 객체 생성 가능
        return Author.builder()
                .name(this.name)
                .email(this.email)
                .password(this.password)
                .role(this.role)
                .build();
    }
}
