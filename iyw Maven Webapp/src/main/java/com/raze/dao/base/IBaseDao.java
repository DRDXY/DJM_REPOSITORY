package com.raze.dao.base;

import java.util.List;
import java.util.Map;

/**
 * @author DJM
 */
public interface IBaseDao<T> {
	
	// 单条插入记录
	public int insert(T record);
	
	// 批量插入数据
	public void batchInsert(List<T> records);
	
	// 通过编号编号(类型为Long或者Integer)删除单条记录
	public void deleteByPrimaryKey(Long idLong, Integer idInteger);
	
	// 更新记录
	public int update(T record);
	
	// 通过编号(类型为Long或者Integer)查询记录
	public T selectByPrimaryKey(Long idLong, Integer idInteger);
	
	// 获取结果集
	public List<T> obtainList(Map<String, Object> conditions);
	
	// 统计记录数
	public int count(Map<String, Object> conditions);
	
	// 获取分页结果集
	public List<T> obtainListByPagination(Map<String, Object> conditions);
	
}
