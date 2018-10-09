package cn.itcast.service;

import cn.itcast.mapper.UserMapper;
import cn.itcast.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

    @Autowired
    private UserMapper  userMapper;

    public User getById(Long id){
      //return this.userMapper.selectByPrimaykey(id);
      return  null  ;
    };

    public User DeleteById(Long id){
        //return this.userMapper.deleteByPrimaykey(id);
        return  null  ;
    };




}
