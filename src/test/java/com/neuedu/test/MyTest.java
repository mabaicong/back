package com.neuedu.test;

import com.neuedu.pojo.User;
import com.neuedu.service.UserService;
import com.neuedu.util.DESUTIL;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by mabaicong on 2019/4/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class MyTest {
    @Resource
    UserService userService;
    @Test
    public void method() {
        User user = new User();
        user.setName("王五");
        user.setPassword(DESUTIL.encode("abcdefg"));
        user.setLoginId("admin");
        user.setPhone("13172182512");
        user.setSex(1);
        user.setCreatDate(new Date());
        user.setEmail("2801666833@qq.com");
        System.out.println(userService.add(user));
    }
}
