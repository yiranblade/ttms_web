package com.ttms.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttms.dao.BaseDao;
import com.ttms.domain.Studio;
import com.ttms.service.StudioService;

/** 
 * @author  作者:yiranblade E-mail: 
 * @date 创建时间：2016年12月14日 下午8:24:36 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
@Service
public class StudioServiceImpl implements StudioService{
    
    @Autowired
    private BaseDao<Studio> baseDao;
    
    public List<Studio> GetAllStudio() {
        // TODO Auto-generated method stub
        
        return baseDao.Find("FROM Studio");
    }

    public boolean UpdateStudio(Studio studio) {
        // TODO Auto-generated method stub
        if(studio!=null){
            baseDao.Update(studio);
        }
        return false;
    }

    public boolean AddStudio(Studio studio) {
        // TODO Auto-generated method stub
        if(studio!=null){
            baseDao.Save(studio);
        }
        return false;
    }

    public boolean DeleteStudio(String id) {
        // TODO Auto-generated method stub
        if(id!=null){
            String hql = "DELETE Studio WHERE studio_id = ?";  
            List<Object> params=new ArrayList<Object>();
            params.add(id);
            baseDao.ExecuteHql(hql, params);
            return true;
        }
        return false;
    }
    

}
