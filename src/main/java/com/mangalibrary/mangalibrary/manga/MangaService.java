package com.mangalibrary.mangalibrary.manga;

import com.mangalibrary.mangalibrary.library.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MangaService {

    @Autowired
    private MangaRepository mangaRepository;


    public List<Manga> getAllMangas() {
        return mangaRepository.findAll();
    }

    public List<Manga> getMangasByGenre(String genre) {
        return mangaRepository.findByLibraryGenre(genre);
    }

    public Manga addManga(Manga manga) {
        return mangaRepository.save(manga);
    }
//
//    public Manga updateManga(Long id, Manga manga) {
//        Manga existingManga = mangaRepository.findById(id).orElseThrow(() -> new RuntimeException("Manga not found"));
//        existingManga.setTitle(manga.getTitle());
//        existingManga.setAuthor(manga.getAuthor());
//        existingManga.setDescription(manga.getDescription());
//        return mangaRepository.save(existingManga);
//    }
//
//    public void deleteManga(Long id) {
//        mangaRepository.deleteById(id);
//    }


}
