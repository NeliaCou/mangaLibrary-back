package com.mangalibrary.mangalibrary.manga;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class MangaService {

    @Autowired
    private MangaRepository mangaRepository;

    private static final Logger logger = Logger.getLogger(MangaService.class.getName());

    public List<Manga> getAllMangas() {
        return mangaRepository.findAll();
    }

    public Manga getMangaById(Long id){
        return mangaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found"));
    }

    public List<Manga> getMangasByGenre(String genre) {
        return mangaRepository.findByLibraryGenre(genre);
    }

    public List<Manga> getMangasByTitle(String title) {
        return mangaRepository.findByTitleContainingIgnoreCase(title);
    }

    public Manga addManga(Manga manga) {
        return mangaRepository.save(manga);
    }

    public Manga updateManga(Long id, Manga manga) {
        Manga existingManga = getMangaById(id);

        existingManga.setTitle(manga.getTitle());
        existingManga.setAuthor(manga.getAuthor());
        existingManga.setAvatar(manga.getAvatar());
        existingManga.setVolumeNumber(manga.getVolumeNumber());

        return mangaRepository.save(existingManga);
    }

    public void deleteMangaById(Long id) {
        if (mangaRepository.findById(id).isPresent()) {
            mangaRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Manga with id " + id + " not found");
        }
    }

}
