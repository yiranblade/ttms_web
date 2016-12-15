package com.ttms.util;

/** 
 * @author  作者:yiranblade E-mail: 
 * @date 创建时间：2016年12月14日 下午9:40:06 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
public class ResultInfo {
    public static final String ADD_ERROR ="添加发生未知错误";
    public static final int ERROR_CODE=500;
    public static final int SUCCESS_CODE=200;
    public static final String ADD_SUCCESS="添加成功";
    public static final String UPDATE_ERROR ="更新发生未知错误";
    public static final String UPDATE_SUCCESS="更新成功";
    public static final String DELETE_SUCCESS="删除成功";
    public static final String DELETE_ERROR="删除发生未知错误";
    public static final String FIND_ERROR="查找发生未知错误";
    public static final String LOGIN_ERROR="账户名或密码错误";
    public static final String LOGIN_SUCCESS="登录成功";
    public static final String SET_SUCCESS="设置成功";
    public static final String SET_EOOR="设置失败";
    public static final String LOGIN="请登录后在进行此操作哦";
    public static final String NO_ACCESS="无权限";
    
    private int code;
    private Object data;
    
    public int getCode() {
        return code;
    }
    
    public void setCode(int code) {
        this.code = code;
    }
    
    public Object getData() {
        return data;
    }
    
    public void setData(Object data) {
        this.data = data;
    }
    
    
}
