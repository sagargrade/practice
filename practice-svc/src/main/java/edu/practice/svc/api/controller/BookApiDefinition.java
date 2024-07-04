package edu.practice.svc.api.controller;

import edu.practice.svc.bo.BookBO;

import java.util.List;

public interface BookApiDefinition {

    List<BookBO> getBooks();

    BookBO getBookById(Long id);
}
