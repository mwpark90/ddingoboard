package com.example.demo.dto.member;


import com.example.demo.domain.Member.MemberEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDto {
    private Long id;
    private String email;
    private String password;
    private String username;
    private LocalDateTime create_time;
    private LocalDateTime modify_time;

    public MemberEntity toEntity(){
        return MemberEntity.builder()
                .id(id)
                .email(email)
                .password(password)
                .username(username)
                .build();
    }

    @Builder
    public MemberDto(Long id,String email, String password, String username){
        this.id = id;
        this.email = email;
        this.password = password;
        this.username = username;
    }


}
