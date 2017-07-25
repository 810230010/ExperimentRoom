package com.nit.experiment.common.controller;

import com.nit.experiment.common.util.WebUtil;
import com.nit.experiment.entity.User;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 江建平 on 2017/7/24.
 */
@ControllerAdvice(basePackages = {"com.nit.experiment.controller"})
public class AdminGlobalHandler{
    @ModelAttribute("currentUser")
    public User setCurrentUser(HttpServletRequest request){
      User currentUser = WebUtil.getCurrentUser(request);
      return currentUser;
   }

}
