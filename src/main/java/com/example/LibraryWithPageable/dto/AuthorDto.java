package com.example.LibraryWithPageable.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class AuthorDto {
    private long id;

    @NotBlank
    @NotNull
    @NotEmpty
    private String firstName;

    @NotBlank
    @NotNull
    @NotEmpty
    private String secondName;

    @NotBlank
    @NotNull
    @NotEmpty
    private String surname;

    @NotNull
    @Past
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd")
    private LocalDate birth;
}
