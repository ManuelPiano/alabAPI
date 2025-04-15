package com.manny.alabapi.controller;

import com.manny.alabapi.entity.songs;
import com.manny.alabapi.service.SongService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/songs")
@CrossOrigin(origins = {"https://manuelpiano.github.io", "http://localhost:4200"})
public class SongController {
    private final SongService songService;
    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping
    public List<songs> getAllSongs() {
        return songService.getAllSongs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<songs> getSongById(@PathVariable Long id) {
        return songService.getSongById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping("/create")
    public ResponseEntity<songs> createSong(
            @RequestParam String title,
            @RequestParam String author,
            @RequestParam String lyrics,
            @RequestParam boolean active,
            @RequestParam boolean ofrenda,
            @RequestParam boolean comodin
    ){
        try{
            songs newSong = new songs();
            newSong.setTitle(title);
            newSong.setAuthor(author);
            newSong.setLyrics(lyrics);
            newSong.setActive(active);
            newSong.setOfrenda(ofrenda);
            newSong.setComodin(comodin);
            songs createSong = songService.createSong(newSong);
            return ResponseEntity.ok(createSong);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<songs> updateSong(
            @PathVariable Long id,
            @RequestParam String title,
            @RequestParam String author,
            @RequestParam String lyrics,
            @RequestParam boolean active,
            @RequestParam boolean ofrenda,
            @RequestParam boolean comodin
            ) {
        try {
            songs updatedSong = new songs();
            updatedSong.setTitle(title);
            updatedSong.setAuthor(author);
            updatedSong.setLyrics(lyrics);
            updatedSong.setActive(active);
            updatedSong.setOfrenda(ofrenda);
            updatedSong.setComodin(comodin);
            songs song = songService.updateSong(id, updatedSong);
            return ResponseEntity.ok(song);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

}
