package com.example.LibraryWithPageable.mapper;

import com.example.LibraryWithPageable.dto.AuthorDto;
import com.example.LibraryWithPageable.model.Author;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorDto toAuthorDto(Author author);

    Author toAuthor(AuthorDto authorDto);
}
