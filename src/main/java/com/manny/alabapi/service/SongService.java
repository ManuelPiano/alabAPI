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


}
