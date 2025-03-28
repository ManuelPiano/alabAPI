package com.manny.alabapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.manny.alabapi.entity.songs;

public interface SongRepo extends JpaRepository<songs, Long> {
}
