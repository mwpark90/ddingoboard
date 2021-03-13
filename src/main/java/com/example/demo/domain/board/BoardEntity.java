package com.example.demo.domain.board;


import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@Setter
@Table(name="board")
public class BoardEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long  id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String writer;

    @Column
    private Long fileId;

    @Column(nullable = false)
    private String filename;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime insert_time;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime update_time;

    @Builder
    public BoardEntity(Long id, String title, String content, String writer, String filename, LocalDateTime insert_time, LocalDateTime update_time,Long fileId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.filename = filename;
        this.insert_time = insert_time;
        this.update_time = update_time;
        this.fileId = fileId;
    }

}
