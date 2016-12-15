package com.ttms.service;

import java.util.List;

import com.ttms.domain.User;
import com.ttms.dto.PageBean;

/** 
 * @author  作者:yiranblade E-mail: 
 * @date 创建时间：2016年12月14日 下午2:39:28 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
public interface UserService {
    public boolean DeleteUser(String id);
    public boolean UpdateUser(User user);
    public List<User> ShowAllUser();
    public boolean AddUser(User user);
    public List<User> ShowUserByPage(PageBean pageBean);
    public User GetUserByName(String name);
    public boolean ValiteUser(String userName, String password);
}
