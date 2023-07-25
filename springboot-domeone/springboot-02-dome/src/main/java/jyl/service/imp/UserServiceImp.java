package jyl.service.imp;


import jyl.dao.UserDao;
import jyl.domain.User;
import jyl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public List<User> list() {
        return userDao.list();
    }

    @Override
    public void add(User guest) {
        userDao.add(guest);
    }

    @Override
    public void update(User guest) {
        userDao.update(guest);
    }

    @Override
    public User get(String name) {
        return userDao.get(name);
    }

    @Override
    public void delete(String name) {

        userDao.delete(name);
    }
}
