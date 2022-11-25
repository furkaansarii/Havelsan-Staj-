package com.example.son.exception;

import java.text.MessageFormat;

public class BookIsAlreadyAssignedException extends  RuntimeException{
    public BookIsAlreadyAssignedException(final Long bookId, Long authorId){
        super(MessageFormat.format("Book: {0} is already assigned to author: {1}", bookId, authorId));
    }
}
