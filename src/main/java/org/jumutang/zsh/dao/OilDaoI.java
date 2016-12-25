package org.jumutang.zsh.dao;

import java.util.List;
import java.util.Map;

import org.jumutang.zsh.model.OilModel;

/**
 * 油的dao接口
 * 
 * @author 鲁雨
 * @since20161223
 * @version v1.0
 * 
 * copyright Luyu(18994139782@163.com)
 *
 */
public interface OilDaoI {

	/**
	 * 查询今日油价
	 * 
	 * @param dateTime
	 * 
	 * @return string
	 */
	public List<OilModel> queryOil(Short status);
	
	/**
	 * 批量插入
	 * 
	 * @param list
	 * 
	 * @return int
	 */
	public int batchInsertOil(List<OilModel> list);
	
	/**
	 * 更新油价状态
	 * 
	 * @param param
	 * 
	 * @return int
	 */
	public int updateOil(Map<String,Object> param);
}
