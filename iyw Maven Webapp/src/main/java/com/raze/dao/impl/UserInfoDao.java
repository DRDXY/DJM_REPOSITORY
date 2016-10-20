package com.raze.dao.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.raze.dao.IUserDao;
import com.raze.dao.base.impl.BaseDao;
import com.raze.domain.UserInfo;

/**
 * Copyright: Copyright (c) 2016 DJM
 * 
 * @ClassName: UserInfoDao.java
 * @Description: 用户DAO层实现类
 *
 * @version: v1.0.0
 * @author: DJM
 * @date: 2016-09-18 下午15:25:17
 */
@Repository
public class UserInfoDao extends BaseDao<UserInfo> implements IUserDao {

	private static final String NAME_SPACE = "UserInfoNamespace.";

	public UserInfoDao(){
		super.setNamespace(NAME_SPACE);
	}

	//暂未用到
//	@Override
//	public UserInfo findUserByUserName(String userName) {
//		return null;
//	}

	@Override
	public List<Map<String, Object>> obtainAuthorityCollentionByUserName(String username) {
		return super.getSqlSession().selectList(NAME_SPACE+"obtainAuthorityCollentionByUserName", username);
	}

	@Override
	public UserInfo obtainUserInfoByUserName(String username) {
		return (UserInfo) super.getSqlSession().selectOne(NAME_SPACE+"obtainUserInfoByUserName", username);
	}

	@Override
	public Collection<Map<String, Object>> obtainAllAuthority() {
		return super.getSqlSession().selectList(NAME_SPACE+"obtainAllAuthority");
	}

}
