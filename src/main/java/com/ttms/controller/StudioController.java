package com.ttms.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.ttms.domain.Studio;
import com.ttms.util.ResultInfo;

/** 
 * @author  作者:yiranblade E-mail: 
 * @date 创建时间：2016年12月15日 下午1:30:33 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
@Controller
public class StudioController extends BaseController{
    
    @RequestMapping(value="/studio/add",method=RequestMethod.POST, produces="application/json; charset=UTF-8")
    public @ResponseBody Object AddStudio(@RequestBody Studio studio){
        ResultInfo resultInfo=new ResultInfo();
        if(studioService.AddStudio(studio)){
            resultInfo.setCode(ResultInfo.SUCCESS_CODE);
            resultInfo.setData(ResultInfo.ADD_SUCCESS);
        }else{
            resultInfo.setCode(ResultInfo.ERROR_CODE);
            resultInfo.setData(ResultInfo.ADD_ERROR);
        }
        return JSON.toJSON(resultInfo);
    }
    @RequestMapping(value="/studio/delete/{id}",method=RequestMethod.GET, produces="application/json; charset=UTF-8")
    public @ResponseBody Object DeleteStudio(@PathParam("id") String id){
        ResultInfo resultInfo=new ResultInfo();
        if(studioService.DeleteStudio(id)){
            resultInfo.setCode(ResultInfo.SUCCESS_CODE);
            resultInfo.setData(ResultInfo.DELETE_SUCCESS);
        }else{
            resultInfo.setCode(ResultInfo.ERROR_CODE);
            resultInfo.setData(ResultInfo.DELETE_ERROR);
        }
        return JSON.toJSON(resultInfo);
    }
    
    @RequestMapping(value="/studio/update",method=RequestMethod.POST, produces="application/json; charset=UTF-8")
    public @ResponseBody Object UpdateStudio(@RequestBody Studio studio){
        ResultInfo resultInfo=new ResultInfo();
        
        if(studioService.UpdateStudio(studio)){
            resultInfo.setCode(ResultInfo.SUCCESS_CODE);
            resultInfo.setData(ResultInfo.UPDATE_SUCCESS);
        }else{
            resultInfo.setCode(ResultInfo.ERROR_CODE);
            resultInfo.setData(ResultInfo.UPDATE_ERROR);
        }
        return JSON.toJSON(resultInfo);
    }
    @RequestMapping(value="/studio/all",method=RequestMethod.GET, produces="application/json; charset=UTF-8")
    public @ResponseBody Object GetAllStudio(){
        ResultInfo resultInfo=new ResultInfo();
        List<Studio> studios=null;
        studios=studioService.GetAllStudio();
        if(studios!=null){
            resultInfo.setCode(ResultInfo.SUCCESS_CODE);
            resultInfo.setData(studios);
        }else{
            resultInfo.setCode(ResultInfo.ERROR_CODE);
            resultInfo.setData(ResultInfo.FIND_ERROR);
        }
        return JSON.toJSON(resultInfo);
    }
    
}
