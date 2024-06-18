package com.mangalibrary.mangalibrary.util;

import com.mangalibrary.mangalibrary.library.Library;
import com.mangalibrary.mangalibrary.library.LibraryRepository;
import com.mangalibrary.mangalibrary.manga.CreateMangaDTO;
import com.mangalibrary.mangalibrary.manga.Manga;
import com.mangalibrary.mangalibrary.manga.MangaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private LibraryRepository libraryRepository;

    @Autowired
    private MangaRepository mangaRepository;

    @Override
    public void run(String... args) throws Exception {
        Library shojo = new Library();
        shojo.setGenre("Shojo");
        libraryRepository.save(shojo);

        Library shonen = new Library();
        shonen.setGenre("Shonen");
        libraryRepository.save(shonen);

        Library josei = new Library();
        josei.setGenre("Josei");
        libraryRepository.save(josei);

        Manga blueSpringRide = new Manga();
        blueSpringRide.setTitle("Blue Spring Ride");
        blueSpringRide.setAuthor("Sakisaka Io");
        blueSpringRide.setAvatar("https://www.nautiljon.com/images/manga/00/67/blue_spring_ride_1276.webp?1716886332");
        blueSpringRide.setVolumeNumber("13/13");
        blueSpringRide.setLibrary(shojo);
        mangaRepository.save(blueSpringRide);

        Manga attackOnTitan = new Manga();
        attackOnTitan.setTitle("L'attaque des Titans");
        attackOnTitan.setAuthor("Isayama Hajime");
        attackOnTitan.setAvatar("https://www.nautiljon.com/images/manga/00/17/l_attaque_des_titans_1471.webp?1697917975");
        attackOnTitan.setVolumeNumber("34/34");
        attackOnTitan.setLibrary(shonen);
        mangaRepository.save(attackOnTitan);

        Manga chihayafuru = new Manga();
        chihayafuru.setTitle("Chihayafuru");
        chihayafuru.setAuthor("Suetsugu Yuki");
        chihayafuru.setAvatar("https://www.nautiljon.com/images/manga/00/11/chihayafuru_1811.webp?1717499170");
        chihayafuru.setVolumeNumber("45/50");
        chihayafuru.setLibrary(shojo);
        mangaRepository.save(chihayafuru);

        Manga tsubasa = new Manga();
        tsubasa.setTitle("Tsubasa RESERVoir CHRoNiCLE");
        tsubasa.setAuthor("CLAMP");
        tsubasa.setAvatar("https://www.nautiljon.com/images/manga/00/31/tsubasa_reservoir_chronicle_13.webp?1699870929");
        tsubasa.setVolumeNumber("28/28");
        tsubasa.setLibrary(shonen);
        mangaRepository.save(tsubasa);

        Manga nana = new Manga();
        nana.setTitle("Nana");
        nana.setAuthor("Yazawa Ai");
        nana.setAvatar("https://www.nautiljon.com/images/manga/00/73/nana_37.webp?1668339329");
        nana.setVolumeNumber("21/21");
        nana.setLibrary(josei);
        mangaRepository.save(nana);

        Manga kimiWaPet = new Manga();
        kimiWaPet.setTitle("Kimi wa Pet");
        kimiWaPet.setAuthor("Ogawa Yayoi");
        kimiWaPet.setAvatar("https://www.nautiljon.com/images/manga/00/14/kimi_wa_pet_341.webp?1669671070");
        kimiWaPet.setVolumeNumber("14/14");
        kimiWaPet.setLibrary(josei);
        mangaRepository.save(kimiWaPet);

        System.out.println("Bibliothèques et mangas initiaux ajoutés à la base de données.");
    }
}