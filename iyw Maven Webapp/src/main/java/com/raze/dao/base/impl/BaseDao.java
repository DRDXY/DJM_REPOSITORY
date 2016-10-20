package com.raze.dao.base.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.raze.dao.base.IBaseDao;

/**
 * @author DJM
 */
public class BaseDao<T> implements IBaseDao<T> {
	
	@Autowired
	private SqlSession	sqlSession;
	
	private String namespace;
	
	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}
	
	public SqlSession getSqlSession() {
		return sqlSession;
	}

	// 单条插入记录
	@Override
	public int insert(T record) {
		return sqlSession.insert(namespace.concat(".insert"), record);
	}

	// 批量插入数据
	@Override
	public void batchInsert(List<T> records) {
		sqlSession.insert(namespace.concat(".batchInsert"), records);
	}

	// 通过编号编号(类型为Long或者Integer)删除单条记录
	@Override
	public void deleteByPrimaryKey(Long idLong, Integer idInteger) {
		if(idLong==null){
			sqlSession.delete(namespace.concat(".deleteByPrimaryKey"), idInteger);
		}else{
			sqlSession.delete(namespace.concat(".deleteByPrimaryKey"), idLong);
		}
	}

	// 更新记录
	@Override
	public int update(T record) {
		return sqlSession.update(namespace.concat(".update"), record);
	}

	// 通过编号(类型为Long或者Integer)查询记录
	@Override
	public T selectByPrimaryKey(Long idLong, Integer idInteger) {
		if(idLong==null){
			return sqlSession.selectOne(namespace.concat(".selectByPrimaryKey"), idInteger);
		}else{
			return sqlSession.selectOne(namespace.concat(".selectByPrimaryKey"), idLong);
		}
	}

	// 获取结果集
	@Override
	public List<T> obtainList(Map<String, Object> conditions) {
		return sqlSession.selectList(namespace.concat(".obtainList"), conditions);
	}

	// 统计记录数
	@Override
	public int count(Map<String, Object> conditions) {
		return sqlSession.selectOne(namespace.concat(".count"), conditions);
	}

	// 获取分页结果集
	@Override
	public List<T> obtainListByPagination(Map<String, Object> conditions) {
		return sqlSession.selectList(namespace.concat(".obtainListByPagination"), conditions);
	}

}
