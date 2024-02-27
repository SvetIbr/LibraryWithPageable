package com.example.LibraryWithPageable.service;

import com.example.LibraryWithPageable.dto.BookDto;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface BookService {
    BookDto create(BookDto bookDto);


    BookDto getById(Long bookId);

    BookDto update(Long bookId, BookDto bookDto);

    void deleteById(Long id);

    List<BookDto> getAll(Integer from, Integer size);
}
