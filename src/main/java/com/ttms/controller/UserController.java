package com.ttms.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.ttms.domain.User;
import com.ttms.dto.PageBean;
import com.ttms.util.ResultInfo;

/** 
 * @author  作者:yiranblade E-mail: 
 * @date 创建时间：2016年12月14日 下午9:18:35 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */


@Controller
public class UserController extends BaseController{
    
    @RequestMapping(value = "/user/add", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public @ResponseBody Object AddUser(@RequestBody User user) {
        ResultInfo resultInfo=new ResultInfo();
        
        if(userService.AddUser(user)){
            resultInfo.setCode(ResultInfo.SUCCESS_CODE);
            resultInfo.setData(ResultInfo.ADD_SUCCESS);
        }else{
            resultInfo.setCode(ResultInfo.ERROR_CODE);
            resultInfo.setData(ResultInfo.ADD_ERROR);
        }
        return JSON.toJSON(resultInfo);
    }
    
    @RequestMapping(value = "/user/update", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public @ResponseBody Object UpdateUser(@RequestBody User user){
        ResultInfo resultInfo=new ResultInfo();
        
        if(userService.UpdateUser(user)){
            resultInfo.setCode(ResultInfo.SUCCESS_CODE);
            resultInfo.setData(ResultInfo.UPDATE_SUCCESS);
        }else{
            resultInfo.setCode(ResultInfo.ERROR_CODE);
            resultInfo.setData(ResultInfo.UPDATE_ERROR);
        }
        return JSON.toJSON(resultInfo);
    }
    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public @ResponseBody Object DeleteUser(@PathParam("id") String id){
        ResultInfo resultInfo=new ResultInfo();
        
        if(userService.DeleteUser(id)){
            resultInfo.setCode(ResultInfo.SUCCESS_CODE);
            resultInfo.setData(ResultInfo.DELETE_SUCCESS);
        }else{
            resultInfo.setCode(ResultInfo.ERROR_CODE);
            resultInfo.setData(ResultInfo.DELETE_ERROR);
        }
        return JSON.toJSON(resultInfo);
    }
    
    @RequestMapping(value = "/user/find/", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public @ResponseBody Object FindUser(){
        ResultInfo resultInfo=new ResultInfo();
        List<User> users=null;
        users=userService.ShowAllUser();
        if(users!=null){
            resultInfo.setCode(ResultInfo.SUCCESS_CODE);
            resultInfo.setData(users);
        }else{
            resultInfo.setCode(ResultInfo.ERROR_CODE);
            resultInfo.setData(ResultInfo.FIND_ERROR);
        }
        
        return JSON.toJSON(resultInfo);
    }
    @RequestMapping(value = "/user/find/{page}&{per_page}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public @ResponseBody Object FindUserByPage(@PathParam("page") String page,@PathParam("per_page")String per_page){
        ResultInfo resultInfo=new ResultInfo();
        List<User> users=null;
        PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(per_page),1);
      
        
        users=userService.ShowUserByPage(pageBean);
        if(users!=null){
            resultInfo.setCode(ResultInfo.SUCCESS_CODE);
            resultInfo.setData(users);
        }else{
            resultInfo.setCode(ResultInfo.ERROR_CODE);
            resultInfo.setData(ResultInfo.FIND_ERROR);
        }
        
        return JSON.toJSON(resultInfo);
        
    }
    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public @ResponseBody Object Login(@RequestParam("username") String userName,@RequestParam("userpassword") String userPassword){
        ResultInfo resultInfo=new ResultInfo();
        boolean flag=userService.ValiteUser(userName, userPassword);
        if(flag){
            User user=userService.GetUserByName(userName);
            session.setAttribute("user",user);
            resultInfo.setCode(ResultInfo.SUCCESS_CODE);
            resultInfo.setData(user);
        }else{
            resultInfo.setCode(ResultInfo.ERROR_CODE);
            resultInfo.setData(ResultInfo.LOGIN_ERROR);
        }
        
        return JSON.toJSON(resultInfo);
    }
}
