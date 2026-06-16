package com.re.hackathong.libary_book.service;

import com.re.hackathong.libary_book.dto.request.BookRequest;
import com.re.hackathong.libary_book.dto.response.BookResponse;
import org.springframework.data.domain.Page;

public interface BookService {

    BookResponse create(BookRequest request);

    Page<BookResponse> getAll(String keyword,int page,int size);

    BookResponse update(Long id,BookRequest request);

    BookResponse patch(Long id,BookRequest request);

    void delete(Long id);

}