package com.example.son.dto;


import com.example.son.model.Author;
import com.example.son.model.Book;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@ApiModel(value = "Yazar varlığının DTO alanı", description = "DTO")
public class AuthorDto {
    @ApiModelProperty(value = "id field of author dto", required = true)
    private Long id;
    @ApiModelProperty(value = "Firs name field of book dto", required = true)
    private String firstName;
    @ApiModelProperty(value = "Last name field of book dto", required = true)
    private String lastName;

    private List<BookDto> booksDto = new ArrayList<>();

    public static AuthorDto from(Author author){
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(author.getId());
        authorDto.setFirstName(author.getFirstName());
        authorDto.setLastName(author.getLastName());
        authorDto.setBooksDto(author.getBooks().stream().map(BookDto::from).collect(Collectors.toList()));
        return authorDto;
    }
}
