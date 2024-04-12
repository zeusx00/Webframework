package com.example.sample.repository;

import java.util.List;

import com.example.sample.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoomRepo extends JpaRepository<Room,Integer>{
    @Query(value = "SELECT p FROM Room p WHERE p.roomNo = :roomNo")
    List<Room> filterbyrno(int roomNo);


}
