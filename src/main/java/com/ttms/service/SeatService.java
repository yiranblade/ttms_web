package com.ttms.service;

import java.util.List;

import com.ttms.domain.Seat;

/** 
 * @author  作者:yiranblade E-mail: 
 * @date 创建时间：2016年12月14日 下午3:45:56 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
public interface SeatService {
    public List<Seat> GetSeatByStudioId(String id);
    public boolean SeatHasSell(List<String> ids);
    public boolean DeleteSeatById(String id);
}
