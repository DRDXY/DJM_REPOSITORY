package com.raze.security;

import java.util.Collection;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

/**
 * Copyright: Copyright (c) 2016 DJM
 * 
 * @ClassName: MyUserDetailService.java
 * @Description: 自定义决策管理区,判断当前用户是否拥有访问该资源的权限
 *
 * @version: v1.0.0
 * @author: DJM
 * @date: 2016-09-18 下午15:25:17
 */
@Service
public class MyAccessDecisionManager implements AccessDecisionManager {
	
	private static final Logger logger = LoggerFactory.getLogger(MyAccessDecisionManager.class);

	@Override
	public void decide(Authentication authentication, Object object,
			Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		if(null==configAttributes){
			return;
		}
		logger.info("The parameter of object {} is a URL.", object);
        Iterator<ConfigAttribute> iterator = configAttributes.iterator();
        while (iterator.hasNext()) {
            ConfigAttribute configAttribute = iterator.next();
            // 访问所请求资源所需要的权限
            String needPermission = configAttribute.getAttribute();
            logger.info("Access request resource requires permission {}.", needPermission);
            // 用户所拥有的权限authentication
            for (GrantedAuthority granted : authentication.getAuthorities()) {
                if (needPermission.equals(granted.getAuthority())) {
                    return;
                }
            }
        }
        // 没有权限
        throw new AccessDeniedException(" 没有权限访问！ ");
	}

	@Override
	public boolean supports(ConfigAttribute attribute) {
		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

}
