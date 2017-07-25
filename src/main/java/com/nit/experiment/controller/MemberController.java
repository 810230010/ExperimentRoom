package com.nit.experiment.controller;

import com.nit.experiment.common.controller.PageResult;
import com.nit.experiment.common.controller.RestResult;
import com.nit.experiment.common.util.StringUtils;
import com.nit.experiment.entity.User;
import com.nit.experiment.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 江建平 on 2017/7/25.
 */
@Controller
@RequestMapping("/member")
public class MemberController {
    private static  Logger logger = Logger.getLogger(MemberController.class);
    @Autowired
    private UserService userService;
    /**
     * 实验室成员列表页面
     * @return
     */
    @RequestMapping("/memberListPage")
    public String view2MemberListPage(){
        return "member_list";
    }

    /**
     * 查询所有用户
     * @param draw
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/searchAllUsers")
    @ResponseBody
    public Object searchAllUsers( @RequestParam("draw") int draw,
                                  @RequestParam(value = "searchKey", required = false) String searchKey,
                                  @RequestParam(value = "orderColumn", required = false) String orderColumn,
                                  @RequestParam(value = "orderType", required = false) String orderType,
                                  @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                  @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize){
        orderColumn = StringUtils.camelToUnderline(orderColumn);
        List<User> userList= userService.searchAllUsers(page, pageSize, searchKey, orderColumn, orderType);
        return new PageResult<User>(userList, draw);
    }

    /**
     * 删除某个用户
     * @param userId
     * @return
     */
    @RequestMapping("/delete/{userId}")
    @ResponseBody
    public Object deleteMember(@PathVariable Integer userId){
        RestResult result = new RestResult();
        int affectedRow = userService.deleteOneUser(userId);
        return result;
    }

}
