package com.mangalibrary.mangalibrary.library;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;

    public List<Library> getAllLibraries() {
        return libraryRepository.findAll();
    }

    public Library getLibraryById(Long id){
        return libraryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found"));
    }

    public Library addLibrary(Library library) {
        return libraryRepository.save(library);
    }

    public Library updateLibrary(Long id, Library library) {
    Library existingLibrary = getLibraryById(id);

    existingLibrary.setGenre(library.getGenre());

    return libraryRepository.save(existingLibrary);
}

    public void deleteLibraryById(Long id) {
        if(libraryRepository.findById(id).isPresent()){
            libraryRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Entity with id " + id + " cannot be found");
        }
    }
}
