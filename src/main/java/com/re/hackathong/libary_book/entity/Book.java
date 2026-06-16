package com.re.hackathong.libary_book.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private Double price;
    @Enumerated(EnumType.STRING)
    private BookStatus status;
    @Column(name="is_deleted")
    private Boolean isDeleted=false;
}