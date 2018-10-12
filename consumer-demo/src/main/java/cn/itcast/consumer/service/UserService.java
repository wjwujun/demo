package cn.itcast.consumer.service;


import cn.itcast.consumer.dao.UserDao;
import cn.itcast.consumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User queryGetById(Long id){
        return this.userDao.queryGetById(id);

    }

}
