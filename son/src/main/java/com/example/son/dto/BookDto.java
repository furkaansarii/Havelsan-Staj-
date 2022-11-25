package com.example.son.dto;


import com.example.son.model.Book;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Objects;

@Data
public class BookDto {
    @ApiModelProperty(value = "id field of book dto", required = true)
    private Long id;
    @ApiModelProperty(value = "First name field of book dto", required = true)
    private String bookName;


    private PlainAuthorDto plainAuthorDto;

    public static BookDto from(Book book){
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setBookName(book.getBookName());
       // if(Objects.nonNull(book.getAuthor())){
            //bookDto.setPlainAuthorDto(PlainAuthorDto.from(book.getAuthor()));
        //}
        return bookDto;
    }
}
