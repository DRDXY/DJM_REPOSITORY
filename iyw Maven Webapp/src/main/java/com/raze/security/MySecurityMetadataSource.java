package com.raze.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;

import com.raze.service.IUserService;

/**
 * Copyright: Copyright (c) 2016 DJM
 * 
 * @ClassName: MyUserDetailService.java
 * @Description: 自定义资源源数据,将所有的资源和权限对应关系建立起来,即定义某一资源可以被哪些角色访问
 *
 * @version: v1.0.0
 * @author: DJM
 * @date: 2016-09-18 下午15:25:17
 */
@Service
public class MySecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
	
	@Autowired
	private IUserService userService;
	
	/**
	 * 加载所有的资源以及与权限关联的权限
	 */
	public Map<String, Collection<ConfigAttribute>> initResourceDefine() {
		// 存储所有的资源和权限的映射
		Map<String, Collection<ConfigAttribute>> resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
		
		//存储所有资源
		Collection<String> resourcesSet = new HashSet<String>();
		
		//读取所有的资源以及与权限关联的权限
		Collection<Map<String, Object>> allAuthority = userService.obtainAllAuthority();
		//遍历,并将角色信息保存至allAttribute中
		if(allAuthority!=null&&allAuthority.size()>0){
			for (Map<String, Object> map : allAuthority) {
				if(map.get("INTERCEPTURL")==null||map.get("INTERCEPTURL").toString().isEmpty()){
					continue;
				}
				String interceptUrl = map.get("INTERCEPTURL").toString();
				resourcesSet.add(interceptUrl);
			}
		}
		if(resourcesSet!=null&&resourcesSet.size()>0){
			for (String resource : resourcesSet) {
				Collection<ConfigAttribute> roleCollection = new ArrayList<ConfigAttribute>();
				if(allAuthority!=null&&allAuthority.size()>0){
					for (Map<String, Object> map : allAuthority) {
						if(map.get("INTERCEPTURL")==null||map.get("INTERCEPTURL").toString().isEmpty()){
							continue;
						}
						String interceptUrl = map.get("INTERCEPTURL").toString();
						if(resource.equalsIgnoreCase(interceptUrl)){
							if(map.get("ROLENAME")==null||map.get("ROLENAME").toString().isEmpty()){
								continue;
							}
							String roleName = map.get("ROLENAME").toString();
							SecurityConfig attrConfig = new SecurityConfig(roleName);
							roleCollection.add(attrConfig);
						}
					}
				}
				resourceMap.put(resource, roleCollection);
			} 
		}
		return resourceMap;
    }

	@Override
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
		
		FilterInvocation filterInvocation = (FilterInvocation) object;
		String url = filterInvocation.getRequestUrl();
		return initResourceDefine().get(url);
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

}
