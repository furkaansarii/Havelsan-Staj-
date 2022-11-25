package com.example.son.controller;


import com.example.son.dto.AuthorDto;
import com.example.son.dto.BookDto;
import com.example.son.model.Author;
import com.example.son.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    @PostMapping("/create")
    public ResponseEntity<AuthorDto> addAuthor(@RequestBody final AuthorDto authorDto){
        Author author = authorService.addAuthor(Author.from(authorDto));
        return new ResponseEntity<>(AuthorDto.from(author), HttpStatus.OK);

    }
    @GetMapping("/getAll")
    public ResponseEntity<List<AuthorDto>> getAuthor(){
        List<Author> authors = authorService.getAuthor();
        List<AuthorDto> authorDto = authors.stream().map(AuthorDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(authorDto, HttpStatus.OK);
    }
    @GetMapping(value = "{id}")
    public ResponseEntity<AuthorDto> getAuthor(@PathVariable final Long id){
        Author author = authorService.getAuthor(id);
        return new ResponseEntity<>(AuthorDto.from(author), HttpStatus.OK);
    }
    @DeleteMapping(value = "{id}")
    public ResponseEntity<AuthorDto> deleteAuthor(@PathVariable final Long id){
        Author author = authorService.deleteAuthor(id);
        return new ResponseEntity<>(AuthorDto.from(author), HttpStatus.OK);
    }
    @PutMapping(value = "{id}")
    public ResponseEntity<AuthorDto> editAuthor(@PathVariable final Long id, @RequestBody final AuthorDto authorDto){
        Author author = authorService.editAuthor(id, Author.from(authorDto));
        return new ResponseEntity<>(AuthorDto.from(author), HttpStatus.OK);
    }

    @PostMapping(value = "{authorId}/books/{bookId}/add")
    public ResponseEntity<AuthorDto> addBookToAuthor(@PathVariable final  Long authorId, @PathVariable final Long bookId) {

        Author author = authorService.addBookToAuthor(authorId, bookId);
        return new ResponseEntity<>(AuthorDto.from(author), HttpStatus.OK);

    }
    @DeleteMapping(value = "{authorId}/books/{bookId}/remove")
    public ResponseEntity<AuthorDto> removeBookFromAuthor(@PathVariable final  Long authorId, @PathVariable final Long bookId) {

        Author author = authorService.removeBookFromBook(authorId, bookId);
        return new ResponseEntity<>(AuthorDto.from(author), HttpStatus.OK);

    }

}
