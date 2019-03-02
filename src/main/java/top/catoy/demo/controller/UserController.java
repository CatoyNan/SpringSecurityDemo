package top.catoy.demo.controller;

import org.springframework.web.bind.annotation.*;
import top.catoy.demo.bean.User;

import java.util.*;

/**
 * @description:
 * @author: xjn
 * @create: 2019-02-28 12:52
 **/
@RestController
public class UserController {
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public List<User> query(User u) {
        List<User> list = new ArrayList<User>();
        list.add(u);
        list.add(u);
        list.add(u);
        return  list;
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public User getInfo(@PathVariable(name = "id") String id){
        User user = new User();
        user.setName("tom");
        return user;
    }

}
