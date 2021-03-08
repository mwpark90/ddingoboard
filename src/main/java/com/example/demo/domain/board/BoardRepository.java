package com.example.demo.domain.board;

import com.example.demo.domain.book.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends CrudRepository< BookEntity,Long>{
}



