package com.jjp;

import com.nit.experiment.entity.User;
import com.nit.experiment.service.UserService;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by 江建平 on 2017/7/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class UserServiceTest {
    private static Logger logger = Logger.getLogger(UserServiceTest.class);
    @Autowired
    private UserService userService;

    @Test
    public void test1(){
        User user = new User();
        user.setUserName("aaa");
        user.setPassword("123");
        logger.info(userService.queryUser(user));
    }
}
