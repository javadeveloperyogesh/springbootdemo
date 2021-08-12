package com.restfull.yogesh.restfull_demo.dao;

import com.restfull.yogesh.restfull_demo.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

@Component
public class UserDaoService {
    private static ArrayList<User> users = new ArrayList<>();
    private static int userCount = 3;

    static {
        users.add(new User(1, "Yogesh", new Date()));
        users.add(new User(2, "Avinash", new Date()));
        users.add(new User(3, "Deepak", new Date()));
    }

    public ArrayList<User> findAll() {
        return users;
    }

    public User save(User user){
        if (user.getId()==null){
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id){
        for (User user: users){
            if (user.getId() == id){
                return user;
            }
        }
        return null;
    }

    public User deleteUser(int id){
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()){
            User user = iterator.next();
            if (user.getId() == id){
                iterator.remove();
                return user;
            }
        }
        return null;
    }
}
