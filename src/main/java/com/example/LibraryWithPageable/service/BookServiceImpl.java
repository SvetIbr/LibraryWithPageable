package com.example.LibraryWithPageable.service;

import com.example.LibraryWithPageable.dto.BookDto;
import com.example.LibraryWithPageable.error.BookNotFoundException;
import com.example.LibraryWithPageable.mapper.BookMapper;
import com.example.LibraryWithPageable.model.Book;
import com.example.LibraryWithPageable.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository repository;
    private final BookMapper mapper;
    @Override
    public BookDto create(BookDto bookDto) {
        return mapper.toBookDto(repository.save(mapper.toBook(bookDto)));
    }

    @Override
    public BookDto getById(Long bookId) {
        return mapper.toBookDto(repository.findById(bookId).orElseThrow( () ->
                new BookNotFoundException(String.format("Книга с идентификатором %d не найдена", bookId))));

    }

    @Override
    public BookDto update(Long bookId, BookDto bookDto) {
        checkBook(bookId);
        Book bookToUpdate = repository.findById(bookId).orElseThrow( () ->
                new BookNotFoundException(String.format("Книга с идентификатором %d не найдена", bookId)));

        bookToUpdate = mapper.update(bookToUpdate);

        return mapper.toBookDto(repository.save(bookToUpdate));
    }

    @Override
    public void deleteById(Long id) {
        checkBook(id);
        repository.deleteById(id);
    }

    @Override
    public List<BookDto> getAll(Integer from, Integer size) {
        Pageable pageable = PageRequest.of(from / size, size,
                Sort.by("author.surname").ascending());
        return repository.findAll(pageable).stream()
                .map(mapper::toBookDto)
                .collect(Collectors.toList());
    }

    private void checkBook(Long id) {
        if (!repository.existsById(id)) {
            throw new BookNotFoundException(String.format("Книга с идентификатором %d не найдена", id));
        }
    }
}
