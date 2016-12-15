package com.ttms.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSONObject;
import com.ttms.domain.User;
import com.ttms.util.ResultInfo;

public class CommonInterceptor extends HandlerInterceptorAdapter{  
    PrintWriter out=null;
    ResultInfo resultInfo=new ResultInfo();
    
   
    @Override    
    public boolean preHandle(HttpServletRequest request,    
            HttpServletResponse response, Object handler) throws Exception {       
          
         User user=(User)request.getSession().getAttribute("user");
         String requestUri = request.getRequestURI();  
         String contextPath = request.getContextPath();  
         String url = requestUri.substring(contextPath.length());
         if(user== null){  
             
             response.setCharacterEncoding("utf-8");
             response.setContentType("application/json");
             out=response.getWriter();
             resultInfo.setCode(ResultInfo.ERROR_CODE);
             resultInfo.setData(ResultInfo.LOGIN);
             out.println(JSONObject.toJSON(resultInfo));
            return false;  
        }else{
            
            
            int position=user.getUser_position();
            if(position==1&&(!url.equals("/user/update"))){
                response.setCharacterEncoding("utf-8");
                response.setContentType("application/json");
                out=response.getWriter();
                resultInfo.setCode(ResultInfo.ERROR_CODE);
                resultInfo.setData(ResultInfo.NO_ACCESS);
                out.println(JSONObject.toJSON(resultInfo));
                return false;
            }else{
                return true;
            }
        }
               
    }    
    
    
  
}    