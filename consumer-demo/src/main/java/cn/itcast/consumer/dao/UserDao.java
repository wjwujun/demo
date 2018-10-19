package cn.itcast.consumer.dao;

import cn.itcast.consumer.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserDao {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "queryUserByIdFallback")
    public User queryGetById(Long id){
        //获取服务
        //List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
        //如果是多个,需要编写负载均衡算法
        //ServiceInstance instance = instances.get(0);

        //String url="http://"+instance.getHost()+":"+instance.getPort()+"/user/"+id;

        long begin=System.currentTimeMillis();

        String url="http://user-service/user/"+id;      //负载均衡


        User user = this.restTemplate.getForObject(url, User.class);
        long end=System.currentTimeMillis();

        System.out.println("time ="+(end-begin));

        return user;
    }

    public  User queryUserByIdFallback(Long id){
        User user=new User();
        user.setId(id);
        user.setName("用户信息查询异常！");
        return user;
    }

}



