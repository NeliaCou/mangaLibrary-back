package com.mangalibrary.mangalibrary.manga;


public record MangaDTO(
        Long id,
        String title,
        String author,
        String description,
        Long libraryId
) {
    public static MangaDTO mapFromEntity(Manga manga) {
        return new MangaDTO(
                manga.getId(),
                manga.getTitle(),
                manga.getAuthor(),
                manga.getDescription(),
                manga.getLibrary().getId()
        );
    }
}
