package com.ttms.domain;

/** 
 * @author  作者:yiranblade E-mail: 
 * @date 创建时间：2016年12月14日 下午2:42:56 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
public class User {
    private int user_id;
    private String user_name;
    private String user_image;
    private int user_position;
    private String user_password;
    
    public int getUser_id() {
        return user_id;
    }
    
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
    public String getUser_name() {
        return user_name;
    }
    
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    
    public int getUser_position() {
        return user_position;
    }
    
    public void setUser_position(int user_position) {
        this.user_position = user_position;
    }
    
    public String getUser_password() {
        return user_password;
    }
    
    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    
    public String getUser_image() {
        return user_image;
    }

    
    public void setUser_image(String user_image) {
        this.user_image = user_image;
    }
    
    
}
