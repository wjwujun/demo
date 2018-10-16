package cn.itcast.consumer.dao;

import cn.itcast.consumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class UserDao {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    public User queryGetById(Long id){
        //获取服务
        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
        //如果是多个,需要编写负载均衡算法
        ServiceInstance instance = instances.get(0);

         String url="http://"+instance.getHost()+":"+instance.getPort()+"/user/"+id;
        return this.restTemplate.getForObject(url,User.class);
    }

}



