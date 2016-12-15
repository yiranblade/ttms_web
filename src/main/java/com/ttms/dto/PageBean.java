package com.ttms.dto;

/** 
 * @author  作者:yiranblade E-mail: 
 * @date 创建时间：2016年12月14日 下午2:35:29 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
public class PageBean {
    private int page;
    private int pageSize;
    private int start;
    public PageBean(int page, int pageSize, int start) {
        super();
        this.page = page;
        this.pageSize = pageSize;
        this.start = start;
    }
    
    public int getPage() {
        return page;
    }
    
    public void setPage(int page) {
        this.page = page;
    }
    
    public int getPageSize() {
        return pageSize;
    }
    
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    
    public int getStart() {
        return (page-1)*pageSize;
    }
}
