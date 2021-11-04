package com.example.creditcardtest.dto;

import lombok.*;

@Builder @AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class AuthenticationResponse {
    private String jwt;
}
