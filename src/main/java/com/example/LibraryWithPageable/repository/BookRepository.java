package com.example.LibraryWithPageable.repository;

import com.example.LibraryWithPageable.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
