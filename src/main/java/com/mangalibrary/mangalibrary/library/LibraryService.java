package com.mangalibrary.mangalibrary.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;

//    public List<Library> getAllLibraries() {
//        return libraryRepository.findAll();
//    }
//
//    public Library saveLibrary(Library library) {
//        return libraryRepository.save(library);
//    }




}
