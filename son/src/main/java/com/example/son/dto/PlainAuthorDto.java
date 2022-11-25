package com.example.son.dto;

import com.example.son.model.Author;
import lombok.Data;

import java.util.Objects;

@Data
public class PlainAuthorDto {
    private Long id;

    public static PlainAuthorDto from(Author author){
        PlainAuthorDto plainAuthorDto = new PlainAuthorDto();
        plainAuthorDto.setId(author.getId());

        return plainAuthorDto;
    }
}
