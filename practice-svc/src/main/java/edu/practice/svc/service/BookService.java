package edu.practice.svc.service;

import edu.practice.svc.api.exception.NotFoundException;
import edu.practice.svc.bo.BookBO;
import edu.practice.svc.bo.mapper.BookBOMapper;
import edu.practice.svc.entity.Book;
import edu.practice.svc.repository.BookRepository;
import edu.practice.svc.uril.CacheConstant;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final BookBOMapper bookBOMapper;

    @Cacheable(value = CacheConstant.CACHE_APPLICATION_CONSTANT)
    public List<BookBO> getBooks(){
        List<Book> books = bookRepository.findAll();
        return bookBOMapper.toBO(books);
    }

    public BookBO getBookById(Long id){
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()){
            return bookBOMapper.toBO(book.get());
        } else {
            throw new NotFoundException("Book with " + id + " not found.");
        }
    }
}
