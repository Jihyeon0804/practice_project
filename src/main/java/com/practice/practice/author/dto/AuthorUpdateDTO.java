package com.practice.practice.author.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorUpdateDTO {

    private String email;
    private String password;
}
