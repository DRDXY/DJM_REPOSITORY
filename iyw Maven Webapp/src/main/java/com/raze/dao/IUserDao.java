package com.raze.dao;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.raze.dao.base.IBaseDao;
import com.raze.domain.UserInfo;

/**
 * Copyright: Copyright (c) 2016 DJM
 * 
 * @ClassName: IUserDao.java
 * @Description: 用户DAO层接口
 *
 * @version: v1.0.0
 * @author: DJM
 * @date: 2016-09-18 下午15:25:17
 */
public interface IUserDao extends IBaseDao<UserInfo> {

	//暂未用到
//	UserInfo findUserByUserName(String userName);

	List<Map<String, Object>> obtainAuthorityCollentionByUserName(String username);

	UserInfo obtainUserInfoByUserName(String username);

	Collection<Map<String, Object>> obtainAllAuthority();

}
