package cn.itcast.userservice.service;


import cn.itcast.userservice.mapper.UserMapper;
import cn.itcast.userservice.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;


@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User queryById(Long id){

        //睡眠,用于测试hystrix的超时熔断功能
        try {
            Thread.sleep(new Random().nextInt(2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return this.userMapper.selectByPrimaryKey(id);
    }



}