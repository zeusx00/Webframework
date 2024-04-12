package com.example.sample.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.sample.repository.RoomRepo;
import com.example.sample.model.Room;

@Service
public class RoomService {

    @Autowired
    RoomRepo rr;

    public Room create(Room re)
    {
        return rr.save(re);
    }

    public List<Room> getAllDetails(){
        return rr.findAll();
    }

    public Room getRoomById(int roomId)
    {
        return rr.findById(roomId).orElse(null);
    }
    public boolean updateDetails(int id,Room room)
        {
            if(this.getRoomById(id)==null)
            {
                return false;
            }
            try{
                rr.save(room);
            }
            catch(Exception e)
            {
                return false;
            }
            return true;
        }
public boolean deleteRoom(int id)
        {
            if(this.getRoomById(id) == null)
            {
                return false;
            }
            rr.deleteById(id);
            return true;
        }
        public List<Room> sort(String field)
        {
            Sort sort=Sort.by(Sort.Direction.ASC,field);
            return rr.findAll(sort);
        }
        public List<Room> page(int pageSize,int pageNumber)     
        {         
            Pageable page=PageRequest.of(pageNumber, pageSize);         
            return rr.findAll(page).getContent();     
        } 
    public List<Room> getSort(int pageSize,int pageNumber,String field)
    {
        return rr.findAll(PageRequest.of(pageSize,pageNumber).withSort(Sort.by(Sort.Direction.ASC,field))).getContent();
    }
  public List<Room> filterbyrno(int rno)
  {
    return rr.filterbyrno(rno);
}
}
