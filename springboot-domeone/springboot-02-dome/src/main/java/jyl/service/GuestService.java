package jyl.service;

import jyl.domain.Guest;

import java.util.List;

public interface GuestService {

    List<Guest> list();
    public void add(Guest guest);
    public void update(Guest guest);
    public Guest get(String name);
    public void delete(String name);
}
