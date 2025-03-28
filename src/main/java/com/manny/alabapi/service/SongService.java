package com.manny.alabapi.service;

import com.manny.alabapi.entity.songs;
import com.manny.alabapi.repo.SongRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {
    private final SongRepo songRepo;
    public SongService(SongRepo songRepository) {
        this.songRepo = songRepository;
    }

    public List<songs> getAllSongs() {
        return songRepo.findAll();
    }

    public Optional<songs> getSongById(Long id) {
        return songRepo.findById(id);
    }

    public songs createSong(songs newSong) { return songRepo.save(newSong);}
    public songs updateSong(Long id, songs updatedSong) {
        return songRepo.findById(id).map(song -> {
            song.setTitle(updatedSong.getTitle());
            song.setAuthor(updatedSong.getAuthor());
            song.setLyrics(updatedSong.getLyrics());
            song.setActive(updatedSong.isActive());
            return songRepo.save(song);
        }).orElseThrow(() -> new RuntimeException("Song not found with id " + id));
    }

}
