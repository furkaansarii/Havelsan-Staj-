package com.example.son.service;


import com.example.son.exception.AuthorNotFoundException;
import com.example.son.exception.BookIsAlreadyAssignedException;
import com.example.son.model.Author;
import com.example.son.model.Book;
import com.example.son.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final BookService bookService;

    @Autowired
    public AuthorService(AuthorRepository authorRepository, BookService bookService) {
        this.authorRepository = authorRepository;
        this.bookService = bookService;
    }

    public Author addAuthor(Author author){
        return authorRepository.save(author);
    }

    public List<Author> getAuthor(){
        return StreamSupport.stream(authorRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }
    public Author getAuthor(Long id){
        return authorRepository.findById(id).orElseThrow(() ->
              new AuthorNotFoundException(id));
    }
    public Author deleteAuthor(Long id){
        Author author = getAuthor(id);
        authorRepository.delete(author);
        return author;
    }
    @Transactional
    public Author editAuthor(Long id, Author author){
        Author authorToEdit = getAuthor(id);
        authorToEdit.setFirstName(author.getFirstName());
        return authorToEdit;
    }
    @Transactional
    public Author addBookToAuthor(Long authorId, Long bookId){
        Author author = getAuthor(authorId);
        Book book = bookService.getBook(bookId);
        //if(Objects.nonNull(book.getAuthor())){
          //  throw new BookIsAlreadyAssignedException(bookId, book.getAuthor().getId());
      //  }
        author.addBook(book);
        //book.setAuthor(author);
        return author;
    }
    @Transactional
    public Author removeBookFromBook(Long authorId, Long bookId){
        Author author = getAuthor(authorId);
        Book book = bookService.getBook(bookId);
        author.removeBook(book);
        return author;
    }
}
