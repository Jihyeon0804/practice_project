package com.practice.practice.author.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonDTO {

    private Object result;
    private int status_code;
    private String status_message;
}
