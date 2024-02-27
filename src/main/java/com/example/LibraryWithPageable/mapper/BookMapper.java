package com.example.LibraryWithPageable.mapper;

import com.example.LibraryWithPageable.dto.BookDto;
import com.example.LibraryWithPageable.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", uses = {AuthorMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BookMapper {

    BookDto toBookDto(Book book);

    Book toBook(BookDto bookDto);

    Book update(Book bookToUpdate);
}
