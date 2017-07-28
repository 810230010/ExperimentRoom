package com.nit.experiment.controller;

import com.nit.experiment.common.controller.PageResult;
import com.nit.experiment.common.controller.RestResult;
import com.nit.experiment.common.util.StringUtils;
import com.nit.experiment.common.util.WebUtil;
import com.nit.experiment.entity.User;
import com.nit.experiment.service.UserService;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.Multipart;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
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
    public String view2MemberListPage(Model model, HttpServletRequest request){
        model.addAttribute("baseUrl", WebUtil.getExcelTemplateUrl(request));
        return "member/member_list";
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

    /**
     * 成员详细信息页面
     * @param userId
     * @return
     */
    @RequestMapping("/memberDetailPage")
    public String view2MemberDetailPage(Integer userId, Model model){
        model.addAttribute("member", userService.findUserByPrimaryKey(userId));
        return "member/member_detail";
    }

    /**
     * 编辑成员信息页面
     * @param model
     * @param userId
     * @return
     */
    @RequestMapping("/editMemberPage")
    public String view2memberEditPage(Model model, Integer userId){
        model.addAttribute("userId", userId);
        return "member/member_edit_role";
    }

    /**
     * 管理员修改成员角色
     * @param userId
     * @param role
     * @return
     */
    @RequestMapping("/editMemberRole")
    @ResponseBody
    public Object editMemberRole(Integer userId, String role){
       RestResult result = new RestResult();
       int affectedRow = userService.updateMemberRole(userId, role);
       return result;
    }

    /**
     * 上传excel文件页面
     * @return
     */
    @RequestMapping("/addMemberPage")
    public String view2addMember(){
        return "member/add_member";
    }

    /**
     * 上传excel文件
     * @param model
     * @param file
     * @return
     */
    @RequestMapping("/uploadExcel")
    public String addMemberByExcel(Model model,
                                   @RequestParam(value = "file", required = true) MultipartFile file,
                                   HttpServletRequest request) throws Exception{
        InputStream in = file.getInputStream();
        int affedtedRows = userService.addMemberByExcel(in);
        model.addAttribute("result","success");
        return "member/add_member";
    }
}
