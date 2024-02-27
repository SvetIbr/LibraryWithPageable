package com.example.LibraryWithPageable.controller;

import com.example.LibraryWithPageable.dto.BookDto;
import com.example.LibraryWithPageable.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/books")
public class LibraryController {
    private final BookService service;

    @PostMapping
    public BookDto create(@Valid @RequestBody BookDto bookDto) {
        return new ResponseEntity<>(service.create(bookDto), HttpStatus.CREATED).getBody();
    }

    @GetMapping("/{bookId}")
    public BookDto getById(@PathVariable Long bookId) {
        return service.getById(bookId);
    }

    @PatchMapping("/{bookId}")
    public BookDto update(@RequestBody BookDto bookDto,
                          @PathVariable Long bookId) {
        return service.update(bookId, bookDto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    @GetMapping()
    public List<BookDto> findAll(@RequestParam(required = false) Pageable pageable) {
        return service.getAll(pageable);
    }
}
