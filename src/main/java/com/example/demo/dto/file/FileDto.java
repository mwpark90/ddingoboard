package com.example.demo.dto.file;

import com.example.demo.domain.file.FileEntity;
import com.example.demo.domain.file.FileRepository;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class FileDto {
    private Long id;
    private String origFilename;
    private String filename;
    private String filePath;
    private Long boardid;

    public FileEntity toEntity() {
        FileEntity build = FileEntity.builder()
                .id(id)
                .origFilename(origFilename)
                .filename(filename)
                .filePath(filePath)
                .boardid(boardid)
                .build();
        return build;
    }

    @Builder
    public FileDto(Long id, String origFilename, String filename, String filePath, Long boardid) {
        this.id = id;
        this.origFilename = origFilename;
        this.filename = filename;
        this.filePath = filePath;
        this.boardid = boardid;
    }
}
