package com.ttms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ttms.service.SeatService;
import com.ttms.service.StudioService;
import com.ttms.service.UserService;

/** 
 * @author  作者:yiranblade E-mail: 
 * @date 创建时间：2016年12月14日 下午9:10:39 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */

public class BaseController {
    protected HttpServletRequest request=null;
    protected HttpServletResponse response=null;
    protected HttpSession session=null;
    
    @Autowired
    protected  SeatService seatService;
    @Autowired
    protected  StudioService studioService;
    @Autowired
    protected  UserService userService;
    
    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request,HttpServletResponse response){
        this.request=request;
        this.response=response;
        this.session=request.getSession();
    }
}
