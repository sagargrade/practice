package edu.practice.svc.bo.mapper;


import edu.practice.svc.bo.BookBO;
import edu.practice.svc.entity.Book;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(builder= @Builder(disableBuilder = true), componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface BookBOMapper {
    BookBO toBO(Book book);
    List<BookBO> toBO(List<Book> books);
}
