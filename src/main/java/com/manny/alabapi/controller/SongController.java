package com.manny.alabanzasapi.controller;

import com.manny.alabanzasapi.entity.songs;
import com.manny.alabanzasapi.service.SongService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/songs")
@CrossOrigin(origins = "http://localhost:4200")
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
}
