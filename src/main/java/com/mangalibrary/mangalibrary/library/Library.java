package com.mangalibrary.mangalibrary.library;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mangalibrary.mangalibrary.manga.Manga;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@RequiredArgsConstructor
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String genre;

    @OneToMany(mappedBy = "library")
    @JsonIgnoreProperties("library")
    private List<Manga> mangas = new ArrayList<>();

}
