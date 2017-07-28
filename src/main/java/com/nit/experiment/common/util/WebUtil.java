package com.nit.experiment.common.util;

import com.nit.experiment.dto.UserLoginDTO;
import com.nit.experiment.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by 江建平 on 2017/7/24.
 */
public class WebUtil {
    private static final String CURRENT_USER = "currentUser";
    /**
     * 得到当前用户
     * @return
     */
    public static User getCurrentUser(HttpServletRequest request){
        HttpSession session = request.getSession();
        return (User)session.getAttribute(CURRENT_USER);
    }

    /**
     * 销毁当前session
     * @param request
     */
    public static void logoutUser(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
    }

    /**
     * 存储当前登陆的用户
     * @param request
     * @param currentUser
     */
    public static void setCurrentUser(HttpServletRequest request, User currentUser){
        HttpSession session = request.getSession();
        session.setAttribute(CURRENT_USER, currentUser);
    }

    /**
     * 得到根路径
     * @param request
     * @return
     */
    public static String getBaseUrl(HttpServletRequest request){
        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
    }

    public static String getExcelTemplateUrl(HttpServletRequest request){
        return getBaseUrl(request) + "/" + "template" + "/add_member_template.xls";
    }

    public static String getUploadPath(HttpServletRequest request){
        return getBaseUrl(request) + "/upload";
    }
}
