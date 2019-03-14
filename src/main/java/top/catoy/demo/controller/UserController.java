package top.catoy.demo.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import top.catoy.demo.bean.User;

import javax.validation.Valid;
import java.util.*;

/**
 * @description:
 * @author: xjn
 * @create: 2019-02-28 12:52
 **/
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @PostMapping
    public User create(@Valid @RequestBody User user, BindingResult errors){
        if(errors.hasErrors()){
            errors.getAllErrors().stream().forEach(error->System.out.println(error.getDefaultMessage()));
        }
        System.out.println(user.getId());
        System.out.println(user.getPassword());
        System.out.println(user.getUserName());
        System.out.println(user.getBirthday());
        user.setId(1);
        return user;
    }

    @GetMapping
    @JsonView(User.UserSimpleView.class)
    public List<User> query(User u) {
        List<User> list = new ArrayList<User>();
        list.add(u);
        list.add(u);
        list.add(u);
        return  list;
    }

    @GetMapping(value = "/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getInfo(@PathVariable(name = "id") String id){
        User user = new User();
        user.setUserName("tom");
        return user;
    }

}
