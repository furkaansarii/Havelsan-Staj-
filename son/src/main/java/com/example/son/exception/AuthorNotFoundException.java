package com.example.son.exception;

import java.text.MessageFormat;

public class AuthorNotFoundException extends RuntimeException{
    public AuthorNotFoundException(final Long id){
        super(MessageFormat.format("Could not find author id: {0}", id));
    }
}
