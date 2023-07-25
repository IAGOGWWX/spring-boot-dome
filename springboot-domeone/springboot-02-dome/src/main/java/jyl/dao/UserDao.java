package jyl.dao;


import jyl.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {
    static List<User> userList = new ArrayList<>();
    static {
        userList.add(new User("张三","蓝球，足球，排球"));
        userList.add(new User("李四","围棋，国际象棋"));
        userList.add(new User("王五","阅读，古典音乐"));
        userList.add(new User("赵六","跆拳道"));
        userList.add(new User("钱七","演讲，辩论"));
    }


    public List<User> list(){
        return userList;
    }


    public void add(User user){
//        System.out.println(user);
        userList.add(user);
    }

    public void update(User newUser){

       User oldUser = get(newUser.getName());
       oldUser.setHobby(newUser.getHobby());
    }
    public void delete(String name){

        userList.remove(get(name));

    }


    public User get(String name){

        for (User user : userList) {
            if (user.getName().equals(name)){
                return user;
            }
        }
        return new User("","");
    }
}
