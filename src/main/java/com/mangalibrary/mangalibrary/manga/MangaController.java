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

//    @GetMapping("/genre/{genre}")
//    public List<Manga> getMangasByGenre(@PathVariable String genre) {
//        return mangaService.getMangasByGenre(genre);
//    }
//
    @PostMapping("/add")
    public ResponseEntity<MangaDTO> createManga(@RequestBody Manga manga) {
        Manga addedManga = mangaService.addManga(manga);
        MangaDTO mangaDTO = MangaDTO.mapFromEntity(addedManga);
        return new ResponseEntity<>(mangaDTO, HttpStatus.OK);
    }
//
//    @PutMapping("/{id}")
//    public Manga updateManga(@PathVariable Long id, @RequestBody Manga manga) {
//        return mangaService.updateManga(id, manga);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteManga(@PathVariable Long id) {
//        mangaService.deleteManga(id);
//    }
}
