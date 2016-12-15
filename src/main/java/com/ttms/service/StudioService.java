package com.ttms.service;

import java.util.List;

import com.ttms.domain.Studio;

/** 
 * @author  作者:yiranblade E-mail: 
 * @date 创建时间：2016年12月14日 下午3:45:15 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
public interface StudioService {
    public List<Studio> GetAllStudio();
    public boolean UpdateStudio(Studio studio);
    public boolean AddStudio(Studio studio);
    public boolean DeleteStudio(String id);
}
