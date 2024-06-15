package com.mangalibrary.mangalibrary.library;

import com.mangalibrary.mangalibrary.manga.Manga;

import java.util.List;

public record LibraryDTO(
        Long id,
        String genre,
        List<Long> mangasIds
) {
    public static LibraryDTO mapFromEntity(Library library) {
        return new LibraryDTO(
                library.getId(),
                library.getGenre(),
                library.getMangas().stream().map(Manga::getId).toList()
        );
    }
}
