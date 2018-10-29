package cn.itcast.consumer.dao;


import cn.itcast.consumer.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/*Fegin使用*/
@FeignClient(value ="user-service",path = "user",fallback = UserFeignClientFallback.class)  //path是指服务端的请求路径
public interface UserClient {
        @GetMapping("/{id}")
        User queryById(@PathVariable("id") Long id);
}
