package com.example.demo.domain.file;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileRepository extends JpaRepository<FileEntity, Long> {
        List<FileEntity> findByBoardid(Long boardid);
        Long deleteByBoardid(Long boardid);
}