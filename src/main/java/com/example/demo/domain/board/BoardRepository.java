package com.example.demo.domain.board;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Long>{
    List<BoardEntity> findByTitle(String keyword);
}



