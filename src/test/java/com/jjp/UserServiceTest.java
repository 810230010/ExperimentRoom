package com.jjp;

import com.github.pagehelper.PageInfo;
import com.nit.experiment.dao.QuestionMapper;
import com.nit.experiment.entity.User;
import com.nit.experiment.service.QuestionService;
import com.nit.experiment.service.UserService;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by 江建平 on 2017/7/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class UserServiceTest {
    private static Logger logger = Logger.getLogger(UserServiceTest.class);
    @Autowired
    private QuestionMapper questionMapper;

    @Test
    public void test1(){
       logger.info(questionMapper.queryUserWithQuestionOperation(1, 2));
    }
}
