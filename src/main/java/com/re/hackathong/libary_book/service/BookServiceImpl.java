package com.re.hackathong.libary_book.service;

import com.re.hackathong.libary_book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.awt.print.Book;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements com.re.hackathong.libary_book.service.BookService {

    private final BookRepository repository;

    @Override
    public com.re.hackathong.libary_book.dto.response.BookResponse create(com.re.hackathong.libary_book.dto.request.BookRequest request){

        Book book=Book.bulder()
                .title(request.getTitle())
                .author(request.getAuthor())
                .price(request.getPrice())
                .status(request.getStatus())
                .isDeleted(false)
                .build();

        repository.save(book);

        return map(book);

    }

    @Override
    public Page<com.re.hackathong.libary_book.dto.response.BookResponse> getAll(String keyword, int page, int size){

        Pageable pageable= PageRequest.of(page,size);

        if(keyword==null){
            keyword="";
        }

        return repository.search(keyword,pageable)
                .map(this::map);

    }

    @Override
    public com.re.hackathong.libary_book.dto.response.BookResponse update(Long id, com.re.hackathong.libary_book.dto.request.BookRequest request){

        Book book=repository.findById(id).orElseThrow();

        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setPrice(request.getPrice());
        book.setStatus(request.getStatus());

        repository.save(book);

        return map(book);

    }

    @Override
    public com.re.hackathong.libary_book.dto.response.BookResponse patch(Long id, com.re.hackathong.libary_book.dto.request.BookRequest request){

        Book book=repository.findById(id).orElseThrow();

        if(request.getTitle()!=null){
            book.setTitle(request.getTitle());
        }

        if(request.getAuthor()!=null){
            book.setAuthor(request.getAuthor());
        }

        if(request.getPrice()!=null){
            book.setPrice(request.getPrice());
        }

        if(request.getStatus()!=null){
            book.setStatus(request.getStatus());
        }

        repository.save(book);

        return map(book);

    }

    @Override
    public void delete(Long id){

        Book book=repository.findById(id).orElseThrow();

        book.setIsDeleted(true);

        repository.save(book);

    }

    private com.re.hackathong.libary_book.dto.response.BookResponse map(Book book){

        return com.re.hackathong.libary_book.dto.response.BookResponse.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .price(book.getPrice())
                .status(book.getStatus())
                .build();

    }
