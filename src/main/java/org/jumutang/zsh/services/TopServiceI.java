package org.jumutang.zsh.services;

import java.util.List;
import java.util.Map;

import org.jumutang.zsh.model.TopModel;

/**
 * 排名的dao接口
 * 
 * @author 鲁雨
 * @since20161223
 * @version v1.0
 * 
 * copyright Luyu(18994139782@163.com)
 *
 */
public interface TopServiceI {
	
	/**
	 * 查询排名信息
	 * @return list
	 */
	public List<TopModel> queryAll();
	
	/**
	 * 根据类型查询排名信息
	 * @return list
	 */
	public List<TopModel> queryTopByType(Short type);
	
	/**
	 * 批量插入排名信息
	 * 
	 * @param list
	 * @return int
	 */
	public int batchInsertTop(List<TopModel> list);
	
	/**
	 * 批量更新
	 * 
	 * @return int
	 */
	public int updateTop();
}
