package com.mangalibrary.mangalibrary.manga;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MangaRepository extends JpaRepository<Manga, Long> {
    List<Manga> findByLibraryGenre(String genre);
}
