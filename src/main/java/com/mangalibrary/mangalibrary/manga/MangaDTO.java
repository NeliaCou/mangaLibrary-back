package com.mangalibrary.mangalibrary.manga;


public record MangaDTO(
        Long id,
        String title,
        String author,
        String avatar,
        String description,
        Long libraryId
) {
    public static MangaDTO mapFromEntity(Manga manga) {
        return new MangaDTO(
                manga.getId(),
                manga.getTitle(),
                manga.getAuthor(),
                manga.getAvatar(),
                manga.getDescription(),
                manga.getLibrary().getId()
        );
    }
}
