package com.example.demo.dto.member;


import com.example.demo.domain.Member.MemberEntity;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDto {
    private Long id;
    private String email;
    private String password;
    private String inputName;
    private LocalDateTime createdDate = LocalDateTime.now();
    private LocalDateTime modifiedDate = LocalDateTime.now();

    public MemberEntity toEntity(){
        return MemberEntity.builder()
                .id(id)
                .email(email)
                .password(password)
                .inputName(inputName)
                .createdDate(createdDate)
                .modifiedDate(modifiedDate)
                .build();
    }

    @Builder
    public MemberDto(Long id, String email, String password, String inputName) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.inputName = inputName;
    }
}

