package com.re.hackathong.libary_book.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Book;
import java.awt.print.Pageable;

public interface BookRepository extends JpaRepository <Book,Long> {
    @Query("""
      select b from Book b 
      where b.isDeleted=false
            and ( lower(b.title) like lower(concat('%',:keyword,'%'))
                  or lower(b.author) like lower(concat('%',:keyword,'%')) ) """)
    Page<Book> search(String keyword, Pageable pageable);
}
