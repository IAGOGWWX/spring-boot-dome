package jyl.dao;


import jyl.domain.Guest;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GuestDao {
    static List<Guest> guestList = new ArrayList<>();
    static {
        guestList.add(new Guest("黄晓明","店长"));
        guestList.add(new Guest("秦海璐","财务"));
        guestList.add(new Guest("林述巍","总厨"));
        guestList.add(new Guest("王俊凯","经理"));
        guestList.add(new Guest("杨紫","前台"));
    }


    public List<Guest> list(){
        return guestList;
    }


    public void add(Guest guest){
        guestList.add(guest);
    }

    public void update(Guest guest){

        Guest oldGuest = get(guest.getName());
        oldGuest.setRole(guest.getRole());
    }
    public void delete(String name){

        guestList.remove(get(name));

    }

    
    public Guest get(String name){

        for (Guest guest : guestList) {
            if (guest.getName().equals(name)){
                return guest;
            }
        }
        return new Guest("","");
    }
}
