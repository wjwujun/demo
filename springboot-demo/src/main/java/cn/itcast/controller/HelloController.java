package cn.itcast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
@RequestMapping
public class HelloController {
        @Autowired
        private DataSource dataSource;

        @GetMapping("hello")
        public String hello(){
            return  "hello this is 大哥！"+dataSource;
        }


}
