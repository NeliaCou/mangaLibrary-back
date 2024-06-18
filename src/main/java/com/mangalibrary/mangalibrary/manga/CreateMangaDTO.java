package com.mangalibrary.mangalibrary.manga;

import com.mangalibrary.mangalibrary.library.Library;

public record CreateMangaDTO(
        String title,
        String author,
        String avatar,
        String volumeNumber,
        Long libraryId
) {
    public Manga toEntity(Library library) {
        Manga manga = new Manga();
        manga.setTitle(this.title);
        manga.setAuthor(this.author);
        manga.setAvatar(this.avatar);
        manga.setVolumeNumber(this.volumeNumber);
        manga.setLibrary(library);
        return manga;
    }
}
