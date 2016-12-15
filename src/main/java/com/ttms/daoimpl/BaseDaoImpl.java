package com.ttms.daoimpl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ttms.dao.BaseDao;
import com.ttms.dto.PageBean;

/** 
 * @author  作者:yiranblade E-mail: 
 * @date 创建时间：2016年7月29日 下午12:08:11 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
@Repository("baseDao")
public class BaseDaoImpl<T> implements BaseDao<T>{
    private SessionFactory sessionFactory;
    
    

    
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    private Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }
    public Serializable Save(T o) {
        // TODO Auto-generated method stub
        
        return this.getCurrentSession().save(o);
    }

    public void Delete(T o) {
        // TODO Auto-generated method stub
        this.getCurrentSession().delete(o);
        
    }

    public void Update(T o) {
        // TODO Auto-generated method stub
        this.getCurrentSession().update(o);
    }

    public void SaveOrUpdate(T o) {
        // TODO Auto-generated method stub
        this.getCurrentSession().saveOrUpdate(o);
        
    }
    
   
    public void Merge(T o) {
        // TODO Auto-generated method stub
        this.getCurrentSession().merge(o);
    }

    public List<T> Find(String hql) {
        // TODO Auto-generated method stub
        return this.getCurrentSession().createQuery(hql).list();
        
    }

    public List<T> Find(String hql, Object[] param) {
        // TODO Auto-generated method stub
        Query q=this.getCurrentSession().createQuery(hql);
        if(param!=null&&param.length>0){
            for(int i=0;i<param.length;i++){
                q.setParameter(i, param[i]);
            }
        }
        return q.list();
    }

    public List<T> Find(String hql, List<Object> param) {
        // TODO Auto-generated method stub
        
        Query q = this.getCurrentSession().createQuery(hql);
        if (param != null && param.size() > 0) {
            for (int i = 0; i < param.size(); i++) {
                q.setParameter(i, param.get(i));
            }
        }
        return q.list();
    }

    public List<T> Find(String hql, Object[] param, PageBean pageBean) {
        // TODO Auto-generated method stub
        Query q = this.getCurrentSession().createQuery(hql);
        if (param != null && param.length > 0) {
            for (int i = 0; i < param.length; i++) {
                q.setParameter(i, param[i]);
            }
        }
        return q.setFirstResult(pageBean.getStart()).setMaxResults(pageBean.getPageSize()).list();
    }

    public List<T> Find(String hql, List<Object> param, PageBean pageBean) {
        // TODO Auto-generated method stub
        Query q = this.getCurrentSession().createQuery(hql);
        if (param != null && param.size() > 0) {
            for (int i = 0; i < param.size(); i++) {
                q.setParameter(i, param.get(i));
            }
        }
        return q.setFirstResult(pageBean.getStart()).setMaxResults(pageBean.getPageSize()).list();
    }

    public T Get(Class<T> c, Serializable id) {
        // TODO Auto-generated method stub
        
        return (T)this.getCurrentSession().get(c, id);
       
    }

    public T Get(String hql, Object[] param) {
        // TODO Auto-generated method stub
        List<T> l=this.Find(hql,param);
        if(l!=null&&l.size()>0){
            return l.get(0);
        }else{
            return null;
        }
        
    }

    public T Get(String hql, List<Object> param) {
        // TODO Auto-generated method stub
        
        List<T> l = this.Find(hql, param);
        if (l != null && l.size() > 0) {
            return l.get(0);
        } else {
            return null;
        }
    }

    public Long Count(String hql) {
        // TODO Auto-generated method stub
        return  (Long) this.getCurrentSession().createQuery(hql).uniqueResult();
    }

    public Long Count(String hql, Object[] param) {
        // TODO Auto-generated method stub
        Query q = this.getCurrentSession().createQuery(hql);
        if (param != null && param.length > 0) {
            for (int i = 0; i < param.length; i++) {
                q.setParameter(i, param[i]);
            }
        }
        return (Long) q.uniqueResult();
    }

    public Long Count(String hql, List<Object> param) {
        // TODO Auto-generated method stub
        Query q = this.getCurrentSession().createQuery(hql);
        if (param != null && param.size() > 0) {
            for (int i = 0; i < param.size(); i++) {
                q.setParameter(i, param.get(i));
            }
        }
        return (Long) q.uniqueResult();
    }

    public Integer ExecuteHql(String hql) {
        // TODO Auto-generated method stub
        return this.getCurrentSession().createQuery(hql).executeUpdate();
    }

    public Integer ExecuteHql(String hql, Object[] param) {
        // TODO Auto-generated method stub
        Query q = this.getCurrentSession().createQuery(hql);
        if (param != null && param.length > 0) {
            for (int i = 0; i < param.length; i++) {
                q.setParameter(i, param[i]);
            }
        }
        return q.executeUpdate();
    }

    public Integer ExecuteHql(String hql, List<Object> param) {
        // TODO Auto-generated method stub
        Query q = this.getCurrentSession().createQuery(hql);
        if (param != null && param.size() > 0) {
            for (int i = 0; i < param.size(); i++) {
                q.setParameter(i, param.get(i));
            }
        }
        return q.executeUpdate();
    }

    public Integer executeSql(String sql) {
        // TODO Auto-generated method stub
        Query q = this.getCurrentSession().createSQLQuery(sql);
        return q.executeUpdate();
    }

    public List<T> findTopN(String hql, List<Object> param, int N) {
        // TODO Auto-generated method stub
        Query q = this.getCurrentSession().createQuery(hql);
        if (param != null && param.size() > 0) {
            for (int i = 0; i < param.size(); i++) {
                q.setParameter(i, param.get(i));
            }
        }
        q.setFirstResult(0);
        q.setMaxResults(N);
        return q.list();
    }

    
    

}
