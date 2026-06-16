package com.re.hackathong.libary_book.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class BookRequest {
    @NotBlank(message = "Title không được để trống")
    private String title;
    @NotBlank(message = "Author không được để trống")
    private String author;
    @Positive(message = "Price phải lớn hơn 0")
    private Double price;
    @NotNull(message = "Status không được để trống")
    private boolean status;
}