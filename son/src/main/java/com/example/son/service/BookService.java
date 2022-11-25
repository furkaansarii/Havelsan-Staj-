package com.example.son.service;


import com.example.son.exception.BookNotFoundException;
import com.example.son.model.Book;
import com.example.son.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BookService {

    private final BookRepository bookRepository;
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book){
        return bookRepository.save(book);
    }

    public List<Book> getBooks(){
        return StreamSupport.stream(bookRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public Book getBook(Long id){
        return bookRepository.findById(id).orElseThrow(() ->
                new BookNotFoundException(id));
    }
    public Book deleteBook(Long id){
        Book book = getBook(id);
        bookRepository.delete(book);
        return book;
    }
    @Transactional
    public Book editBook(Long id, Book book){
        Book bookToEdit = getBook(id);
        bookToEdit.setBookName(book.getBookName());
        return bookToEdit;
    }

}
