package com.mangalibrary.mangalibrary.manga;

import com.mangalibrary.mangalibrary.library.Library;

public record CreateMangaDTO(
        String title,
        String author,
        String avatar,
        String description,
        Long libraryId
) {
    public Manga toEntity(Library library) {
        Manga manga = new Manga();
        manga.setTitle(this.title);
        manga.setAuthor(this.author);
        manga.setDescription(this.description);
        manga.setLibrary(library);
        return manga;
    }
}
