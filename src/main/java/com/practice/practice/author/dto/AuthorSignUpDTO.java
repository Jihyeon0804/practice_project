package com.practice.practice.author.dto;

import com.practice.practice.author.domain.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorSignUpDTO {

    private String name;

    private String email;

    private String password;

    public Author authorFromEntity(AuthorSignUpDTO authorSignUpDTO) {
        return new Author(this.name, this.email, this.password);
    }
}
