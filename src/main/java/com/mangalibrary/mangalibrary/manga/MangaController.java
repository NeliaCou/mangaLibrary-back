package com.mangalibrary.mangalibrary.manga;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mangas")
public class MangaController {

    @Autowired
    private MangaService mangaService;

    @GetMapping("/get/all")
    public ResponseEntity<List<MangaDTO>> getAllMangas() {
        List<Manga> mangas = mangaService.getAllMangas();
        List<MangaDTO> mangaDTOS = mangas.stream().map(MangaDTO::mapFromEntity).toList();
        return new ResponseEntity<>(mangaDTOS, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<MangaDTO> getMangaById(@PathVariable("id") Long id) {
       Manga getManga = mangaService.getMangaById(id);
       MangaDTO mangaDTO = MangaDTO.mapFromEntity(getManga);
        return new ResponseEntity<>(mangaDTO, HttpStatus.OK);
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<MangaDTO>> getMangasByGenre(@PathVariable String genre) {
        List<Manga> mangas = mangaService.getMangasByGenre(genre);
        List<MangaDTO> mangaDTOS = mangas.stream().map(MangaDTO::mapFromEntity).toList();
        return new ResponseEntity<>(mangaDTOS, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<MangaDTO> createManga(@RequestBody Manga manga) {
        Manga addedManga = mangaService.addManga(manga);
        MangaDTO mangaDTO = MangaDTO.mapFromEntity(addedManga);
        return new ResponseEntity<>(mangaDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MangaDTO> updateManga(@PathVariable("id") Long id, @RequestBody Manga manga) {
        Manga mangaUpdated = mangaService.updateManga(id, manga);
        MangaDTO mangaDTO = MangaDTO.mapFromEntity(mangaUpdated);
        return new ResponseEntity<>(mangaDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteManga(@PathVariable("id") Long id) {
        mangaService.deleteMangaById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
