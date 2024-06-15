package com.mangalibrary.mangalibrary.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/libraries")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

//    @GetMapping
//    public List<Library> getAllLibraries() {
//        return libraryService.getAllLibraries();
//    }
//
//    @PostMapping
//    public Library createLibrary(@RequestBody Library library) {
//        return libraryService.saveLibrary(library);
//    }
}
