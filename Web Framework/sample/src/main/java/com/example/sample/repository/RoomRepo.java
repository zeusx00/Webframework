package com.example.sample.repository;

import com.example.sample.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepo extends JpaRepository<Room,Integer>{
    
}
