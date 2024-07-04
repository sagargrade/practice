package edu.practice.svc.api.controller.impl;

import edu.practice.svc.api.controller.BookApiDefinition;
import edu.practice.svc.bo.BookBO;
import edu.practice.svc.config.security.SecurityScope;
import edu.practice.svc.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(AbstractController.ROOT_CONTEXT_PATH + BookController.BASE_PATH)
@AllArgsConstructor
public class BookController extends AbstractController implements BookApiDefinition {

    public static final String BASE_PATH = "/books";

    private BookService bookService;

    @Override
    @GetMapping
    @PreAuthorize(value = SecurityScope.PRE_AUTHORIZE_CAN_CONSULT)
    public List<BookBO> getBooks(){
        return bookService.getBooks();
    }

    @Override
    @GetMapping(value = "/{id}")
    @PreAuthorize(value = SecurityScope.PRE_AUTHORIZE_CAN_CONSULT)
    public BookBO getBookById(@PathVariable(value = "id") Long id) {
        return bookService.getBookById(id);
    }
}
