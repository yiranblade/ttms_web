package com.ttms.dao;

import java.io.Serializable;
import java.util.List;

import com.ttms.dto.PageBean;

/** 
 * @author  作者:yiranblade E-mail: 
 * @date 创建时间：2016年7月29日 上午10:55:57 
 * @version 1.0 
 * @parameter  
 * @since  基础数据库操作类
 * @return  
 */
public interface BaseDao<T> {
    /**
     * @Description 保存一个对象
     * @param o
     * @return  序列化的对象
     */
    public Serializable Save(T o);
    /**
     * @Description 删除一个对象
     * @param o
     */
    public void Delete(T o);
    
    /**
     * @Description 更新对象
     * @param o
     */
    public void Update(T o);
    
    /**
     * @Description 保存或更新对象
     * @param o
     */
    public void SaveOrUpdate(T o);
    /**
     * @Description 合并对象
     * @param o
     */
    public void Merge(T o);
    
    /**
     * @Description 查询
     * @param hql
     * @return
     */
    public List<T> Find(String hql);
    
    /**
     * @Description 查询集合
     * @param hql
     * @param param
     * @return
     */
    public List<T> Find(String hql,Object[] param);
    
    /**
     * @Description 查询集合
     * @param hql
     * @param param
     * @return
     */
    public List<T> Find(String hql,List<Object> param);
    
    /**
     * @Description 查询集合带分页
     * @param hql
     * @param param
     * @param pagebean　分页信息
     * @return
     */
    public List<T> Find(String hql,Object[] param,PageBean pageBean);
    
    /**
     * @Description 查询集合带分页
     * @param hql
     * @param param
     * @param pageBean　分页信息
     * @return
     */
    public List<T> Find(String hql,List<Object> param,PageBean pageBean);
    
    /**
     * @Description 获得一个对象
     * @param c
     * @param id
     * @return
     */
    public T Get(Class<T> c,Serializable id);
    
    
    
    /**
     * @Description 获得一个对象
     * @param hql
     * @param param
     * @return
     */
    public T Get(String hql,Object[] param);
    
    /**
     * @Description 获得一个对象
     * @param hql
     * @param param
     * @return
     */
    public T Get(String hql,List<Object> param);
    
    /**
     * @Description select count(*) form
     * @param hql
     * @return
     */
    public Long Count(String hql);
    
    /**
     * @Description 统计
     * @param hql
     * @param param
     * @return
     */
    public Long Count(String hql,Object[] param);
    
    /**
     * @Description 统计
     * @param hql
     * @param param
     * @return
     */
    public Long Count(String hql,List<Object> param);
    
    /**
     * @Description 执行hql语句
     * @param hql
     * @return
     */
    public Integer ExecuteHql(String hql);
    
    /**
     * @Description 执行hql语句
     * @param hql
     * @param param
     * @return 
     */
    public Integer ExecuteHql(String hql,Object[] param);
    
    /**
     * @Description 执行hql语句
     * @param hql
     * @param param
     * @return
     */
    public Integer ExecuteHql(String hql,List<Object> param);
   
    
    public Integer executeSql(String sql);
    
    public List<T> findTopN(String hql, List<Object> param, int N);
}
