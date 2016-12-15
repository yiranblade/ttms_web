package com.ttms.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttms.dao.BaseDao;
import com.ttms.domain.Seat;
import com.ttms.service.SeatService;

/** 
 * @author  作者:yiranblade E-mail: 
 * @date 创建时间：2016年12月14日 下午8:46:43 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
@Service
public class SeatServiceImpl implements SeatService{
    
    @Autowired
    private BaseDao<Seat> baseDao;
    public List<Seat> GetSeatByStudioId(String id) {
        // TODO Auto-generated method stub
        if(id!=null){
            String hql = "from Studio WHERE studio_id = ?";  
            List<Object> params=new ArrayList<Object>();
            params.add(id);
                    
            return baseDao.Find(hql, params);
        }
        return null;
    }

    public boolean SeatHasSell(List<String> ids) {
        // TODO Auto-generated method stub
        if(ids!=null){
            String hql="UPDATE Seat set is_sell=1 where seat_id=?";
            for(String id: ids){
                List<Object> params=new ArrayList<Object>();
                params.add(id);
                baseDao.ExecuteHql(hql, params);
               }
            return true;
        }
            
        return false;
    }

    public boolean DeleteSeatById(String id) {
        // TODO Auto-generated method stub
        if(id!=null){
            String hql = "DELETE Seat WHERE seat_id = ?";  
            List<Object> params=new ArrayList<Object>();
            params.add(id);
            baseDao.ExecuteHql(hql, params);
            return true;
        }
        return false;
    }
    
    

}
