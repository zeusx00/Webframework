package com.example.sample.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Room {
    @Id
    private int roomId;
    private String roomNo;
    private String roomType;
    private int roomPrice;
    private String roomAvl;
    public int getRoomId() {
        return roomId;
    }
    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
    public String getRoomNo() {
        return roomNo;
    }
    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }
    public String getRoomType() {
        return roomType;
    }
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
    public int getRoomPrice() {
        return roomPrice;
    }
    public void setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }
    public String getRoomAvl() {
        return roomAvl;
    }
    public void setRoomAvl(String roomAvl) {
        this.roomAvl = roomAvl;
    }
    public Room(int roomId, String roomNo, String roomType, int roomPrice, String roomAvl) {
        this.roomId = roomId;
        this.roomNo = roomNo;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
        this.roomAvl = roomAvl;
    }
    public Room() {
    }
    
}
