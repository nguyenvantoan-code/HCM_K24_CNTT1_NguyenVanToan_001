package com.re.hackathong.libary_book.dto.response;


import com.re.hackathong.libary_book.entity.BookStatus;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookResponse {
    private Long id;
    private String title;
    private String author;
    private Double price;
    private BookStatus status;
}



