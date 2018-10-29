package cn.itcast.consumer.dao;


import cn.itcast.consumer.pojo.User;
import org.springframework.stereotype.Component;

/*Fegin使用,熔断方法*/
@Component
public class  UserFeignClientFallback  implements UserClient{
        @Override
        public  User queryById(Long id){
                User user=new User();
                user.setId(id);
                user.setName("用户信息查询异常！");
                return user;
        }
}
