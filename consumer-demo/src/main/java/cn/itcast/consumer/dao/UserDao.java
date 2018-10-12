package cn.itcast.consumer.dao;

import cn.itcast.consumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserDao {

    @Autowired
    private RestTemplate restTemplate;

    public User queryGetById(Long id){
        String url="http://localhost:8081/user/"+id;
        return this.restTemplate.getForObject(url,User.class);
    }

}



