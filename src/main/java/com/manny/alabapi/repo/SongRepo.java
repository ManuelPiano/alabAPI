package com.manny.alabanzasapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.manny.alabanzasapi.entity.songs;

public interface SongRepo extends JpaRepository<songs, Long> {
}
