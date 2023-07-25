package jyl.service;


import jyl.domain.User;

import java.util.List;

public interface UserService {
    List<User> list();
    public void add(User guest);
    public void update(User guest);
    public User get(String name);
    public void delete(String name);
}
