package com.ttms.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.ttms.domain.Seat;
import com.ttms.util.ResultInfo;

/** 
 * @author  作者:yiranblade E-mail: 
 * @date 创建时间：2016年12月15日 下午2:00:41 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
@Controller
public class SeatController extends BaseController{
    
    @RequestMapping(value = "/seat/delete/{id}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public @ResponseBody Object DeleteSeatById(@PathParam("id") String id){
        ResultInfo resultInfo=new ResultInfo();
        if(seatService.DeleteSeatById(id)){
            resultInfo.setCode(ResultInfo.SUCCESS_CODE);
            resultInfo.setData(ResultInfo.DELETE_SUCCESS);
        }else{
            resultInfo.setCode(ResultInfo.ERROR_CODE);
            resultInfo.setData(ResultInfo.DELETE_ERROR);
        }
        return JSON.toJSON(resultInfo);
            
    }
    @RequestMapping(value = "/seat/set", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public @ResponseBody Object SetSeatSell(@RequestBody List<String> ids){
        ResultInfo resultInfo=new ResultInfo();
        
        if(seatService.SeatHasSell(ids)){
            resultInfo.setCode(ResultInfo.SUCCESS_CODE);
            resultInfo.setData(ResultInfo.SET_SUCCESS);
        }else{
            resultInfo.setCode(ResultInfo.ERROR_CODE);
            resultInfo.setData(ResultInfo.SET_EOOR);
        }
        return JSON.toJSON(resultInfo);
    }
    @RequestMapping(value = "/seat/set/{id}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public @ResponseBody Object GetSeatByStudioId(@PathParam("id") String id){
        ResultInfo resultInfo=new ResultInfo();
        List<Seat> seats=null;
        seats=seatService.GetSeatByStudioId(id);
        if(seats!=null){
            resultInfo.setCode(ResultInfo.SUCCESS_CODE);
            resultInfo.setData(seats);
        }else{
            resultInfo.setCode(ResultInfo.ERROR_CODE);
            resultInfo.setData(ResultInfo.FIND_ERROR);
        }
        return JSON.toJSON(resultInfo);
    }
}
