package com.study.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.study.dto.User;
import com.study.dto.UserQueryCondition;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gf on 2018/9/7.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    //处理创建请求
    @PostMapping
    public User create(User user){
        user.setId("1");

        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        return user;
    }

    @GetMapping
    @JsonView(User.UserSimpleView.class)
    public List<User> query(UserQueryCondition userQueryCondition, @PageableDefault(page = 1,size = 20,sort = "username,asc") Pageable pageable){
        System.out.println(userQueryCondition);

        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getSort());
        System.out.println(pageable.getOffset());

        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    @GetMapping("/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getInfo(@PathVariable(name = "id") String id){
        System.out.println("--->"+id);

        User user = new User();
        user.setUsername("tom");
        return user;
    }
}
