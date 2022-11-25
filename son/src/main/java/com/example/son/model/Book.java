package com.example.son.model;


import com.example.son.dto.BookDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "Book")
@ApiModel(value = "Book entity documents", description = "Entity")
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "bigint", name = "id")
    @ApiModelProperty(value = "ID field of the book entity", required = true)
    private Long id;

    @Column(columnDefinition = "character varying", name = "book_name")
    @ApiModelProperty(value = "Book field of the book entity", required = true)
    private String bookName;


    //@ManyToMany(fetch = FetchType.LAZY)
    //@JoinColumn(name = "author_id")
    //private Author author;

    public static Book from(BookDto bookDto){
        Book book = new Book();
        book.setBookName(bookDto.getBookName());
        return book;
    }
}
