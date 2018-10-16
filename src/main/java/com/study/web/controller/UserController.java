package com.study.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.study.dto.User;
import com.study.dto.UserQueryCondition;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Field;
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
    public User create(@Valid @RequestBody User user, BindingResult errors){
        if (errors.hasErrors()){
            errors.getAllErrors().forEach(error -> System.out.println(error.getDefaultMessage()));
        }
        user.setId("1");

        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthday());
        return user;
    }

    //处理修改请求
    @PutMapping("/{id:\\d+}")
    public User update(@Valid @RequestBody User user, BindingResult errors){
        if (errors.hasErrors()){
            errors.getAllErrors().forEach(error -> {
                FieldError fieldError = (FieldError) error;
                String message = fieldError.getField() +":"+ error.getDefaultMessage();
                System.out.println(message);
            });
        }
        user.setId("1");

        System.out.println(user.getId());
        System.out.println(user.getBirthday());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        return user;
    }

    //处理删除
    @DeleteMapping("/{id:\\d+}")
    public void delete(@PathVariable(name = "id") String id){
        System.out.println("--->"+id);
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
