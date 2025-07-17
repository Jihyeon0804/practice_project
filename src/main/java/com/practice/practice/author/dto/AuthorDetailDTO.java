package com.practice.practice.author.dto;

import com.practice.practice.author.domain.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDetailDTO {

    private String name;
    private String email;

    public static AuthorDetailDTO authorFromEntity(Author author) {
        return new AuthorDetailDTO(author.getName(), author.getEmail());
    }
}
