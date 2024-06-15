package com.mangalibrary.mangalibrary.library;

import com.mangalibrary.mangalibrary.manga.Manga;
import com.mangalibrary.mangalibrary.manga.MangaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/libraries")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping("get/all")
    public ResponseEntity<List<LibraryDTO>> getAllLibraries() {
        List<Library> mangas = libraryService.getAllLibraries();
        List<LibraryDTO> libraryDTOS = mangas.stream().map(LibraryDTO::mapFromEntity).toList();
        return new ResponseEntity<>(libraryDTOS, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<LibraryDTO> getLibraryById(@PathVariable("id") Long id) {
        Library getLibrary = libraryService.getLibraryById(id);
        LibraryDTO libraryDTO = LibraryDTO.mapFromEntity(getLibrary);
        return new ResponseEntity<>(libraryDTO, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<LibraryDTO> createLibrary(@RequestBody Library library) {
        Library addedLibrary = libraryService.addLibrary(library);
        LibraryDTO libraryDTO = LibraryDTO.mapFromEntity(addedLibrary);
        return new ResponseEntity<>(libraryDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<LibraryDTO> updateLibrary(@PathVariable("id") Long id, @RequestBody Library library) {
        Library libraryUpdated = libraryService.updateLibrary(id, library);
        LibraryDTO libraryDTO = LibraryDTO.mapFromEntity(libraryUpdated);
        return new ResponseEntity<>(libraryDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteLibrary(@PathVariable("id") Long id) {
        libraryService.deleteLibraryById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
