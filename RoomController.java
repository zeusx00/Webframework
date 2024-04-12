package com.example.sample.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.sample.model.Room;
import com.example.sample.repository.RoomRepo;
import com.example.sample.service.RoomService;

@RestController
public class RoomController {
    @Autowired
    RoomService rs;
    @Autowired
    RoomRepo rr;
@PostMapping("/api/room")
    public ResponseEntity<Room> createLogin(@RequestBody Room room) {
        Room obj = rs.create(room);
        return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }

    @GetMapping("/api/rooms")
    public ResponseEntity<List<Room>> getAllRooms() {
        List<Room> rooms = rs.getAllDetails();
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @GetMapping("/api/room/{roomId}")
    public ResponseEntity<Room> getRoomById(@PathVariable Integer roomId) {
        Room room = rs.getRoomById(roomId);
        return new ResponseEntity<>(room, HttpStatus.OK);    
    }

    @PutMapping("api/room/{roomId}")
    public ResponseEntity<Room> updateProductsController(@PathVariable int roomId, @RequestBody Room re)
    {
        if(rs.updateDetails(roomId, re)==true)
            return new ResponseEntity<>(re, HttpStatus.OK);
        else
            return new ResponseEntity<>(re,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("api/room/{roomId}")
    public ResponseEntity<Boolean> deleteProductsController(@PathVariable int roomId)
    {
        if(rs.deleteRoom(roomId)==true)
            return new ResponseEntity<>(true,HttpStatus.OK);
        else
            return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
    @GetMapping("/{page}/{size}/{sortField}")
    public ResponseEntity<List<Room>> getRoomsPaginatedAndSorted(
            @PathVariable int page,
            @PathVariable int size,
            @PathVariable String sortField) {
        List<Room> rooms = rs.getSort(page, size, sortField);
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }
    @GetMapping("/{page}/{size}")
    public ResponseEntity<List<Room>> getRoomsPaginated(
            @PathVariable int page,
            @PathVariable int size
            ) {
        List<Room> rooms = rs.page(page, size);
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }
    @GetMapping("/{sortField}")
    public ResponseEntity<List<Room>> getRoomsSorted(
            
            @PathVariable String sortField) {
        List<Room> rooms = rs.sort(sortField);
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @GetMapping("rooms/{roomNo}")
    public ResponseEntity<List<Room>> getRoomsByName(@PathVariable int roomNo) {
        List<Room> rooms = rr.filterbyrno(roomNo);
        return new ResponseEntity<>(rooms, HttpStatus.OK);}

}