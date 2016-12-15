package com.ttms.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttms.dao.BaseDao;
import com.ttms.domain.User;
import com.ttms.dto.PageBean;
import com.ttms.service.UserService;

/** 
 * @author  作者:yiranblade E-mail: 
 * @date 创建时间：2016年12月14日 下午4:17:58 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private BaseDao<User> baseDao;
    
    public boolean DeleteUser(String id) {
        // TODO Auto-generated method stub
        if(id!=null){
            String hql = "DELETE User WHERE user_id = ?";  
            List<Object> params=new ArrayList<Object>();
            params.add(id);
            baseDao.ExecuteHql(hql, params);
            return true;
        }
        return false;
    }

    public boolean UpdateUser(User user) {
        // TODO Auto-generated method stub
        if(user!=null){
            baseDao.Update(user);
            return true;
            
        }
        return false;
    }

    public List<User> ShowAllUser() {
        // TODO Auto-generated method stub
        
        return baseDao.Find("from User");
    }

    public boolean AddUser(User user) {
        // TODO Auto-generated method stub
        if(user!=null){
            baseDao.Save(user);
            return true;
        }
        return false;
    }

    public boolean ValiteUser(String userName, String password) {
        // TODO Auto-generated method stub
        List<Object> params=new ArrayList<Object>();
        params.add(userName);
        User user=baseDao.Get("from User where user_name=?", params);
        if(user.getUser_password().equals(password))
            return true;
        return false;
    }

    public List<User> ShowUserByPage(PageBean pageBean) {
        // TODO Auto-generated method stub
        if(pageBean!=null){
            List<Object> params=null;
            return baseDao.Find("from User",params, pageBean);
        };
        return null;
    }

    public User GetUserByName(String name) {
        // TODO Auto-generated method stub
        User user=null; 
        if(name!=null){
             
             String hql = "from User WHERE user_name = ?";  
             List<Object> params=new ArrayList<Object>();
             params.add(name);
             user=baseDao.Find(hql, params).get(0);
         }
        return user;
    }
    
    

}
