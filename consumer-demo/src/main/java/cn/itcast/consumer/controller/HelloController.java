package cn.itcast.consumer.controller;

import cn.itcast.consumer.pojo.User;
import cn.itcast.consumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {
    @Autowired
    private UserService userService;
    @GetMapping("/{id}")
    public User queryGetById(@PathVariable("id") Long id){
        return  this.userService.queryGetById(id);

    }
}
