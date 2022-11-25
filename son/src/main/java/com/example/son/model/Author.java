package com.example.son.model;


import com.example.son.dto.AuthorDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "Author")
@ApiModel(value = "Author entity documents", description = "Entity")
public class Author implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "bigint", name = "author_id")
    @ApiModelProperty(value = "ID field of the author entity", required = true)
    private Long id;

    @Column(columnDefinition = "character varying", name = "firstName")
    @ApiModelProperty(value = "First name field of the author entity", required = true)
    private String firstName;

    @Column(columnDefinition = "character varying", name = "lastName")
    @ApiModelProperty(value = "Last name field of the author entity", required = true)
    private String lastName;


    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Book> books = new ArrayList<>();


    public void addBook(Book book){
        books.add(book);
   }
    public void removeBook(Book book){
        books.remove(book);
    }

    public static Author from(AuthorDto authorDto){
        Author author = new Author();
        author.setFirstName(authorDto.getFirstName());
        return author;
    }

}
