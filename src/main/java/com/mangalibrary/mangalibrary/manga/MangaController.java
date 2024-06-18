package com.mangalibrary.mangalibrary.manga;

import com.mangalibrary.mangalibrary.library.Library;
import com.mangalibrary.mangalibrary.library.LibraryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/mangas")
public class MangaController {

    @Autowired
    private MangaService mangaService;

    @Autowired
    private LibraryRepository libraryRepository;

    private static final Logger logger = Logger.getLogger(MangaController.class.getName());

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
    public ResponseEntity<MangaDTO> createManga(@RequestBody CreateMangaDTO createMangaDTO) {
        Library library = libraryRepository.findById(createMangaDTO.libraryId())
                .orElseThrow(() -> new EntityNotFoundException("Library not found"));

        Manga manga = createMangaDTO.toEntity(library);
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
        try {
            mangaService.deleteMangaById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EntityNotFoundException e) {
            logger.severe("Entity not found with id: " + id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
