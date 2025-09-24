package com.example.milo.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserSignupDto {
    private String user_name;
    private String email;
    private String password;
    private LocalDateTime created_at;
    private LocalDateTime deleted_at;
}
