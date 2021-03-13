package com.example.demo.dto.board;

import com.example.demo.domain.board.BoardEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDto {
    private Long id;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime insert_time = LocalDateTime.now();
    private LocalDateTime update_time = LocalDateTime.now();

    public BoardEntity toEntity(){
        return BoardEntity.builder()
                .id(id)
                .title(title)
                .content(content)
                .writer(writer)
                .insert_time(insert_time)
                .update_time(update_time)
                .build();
    }

    @Builder
    public BoardDto(Long id, String title, String content, String writer,LocalDateTime update_time ) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.update_time = update_time;
    }
}
