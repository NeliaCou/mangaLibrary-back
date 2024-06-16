package com.mangalibrary.mangalibrary.manga;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mangalibrary.mangalibrary.library.Library;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
public class Manga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String avatar;
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "library_id")
    @JsonIgnoreProperties("mangas")
    private Library library;
}
