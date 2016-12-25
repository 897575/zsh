package org.jumutang.zsh.services;

import java.util.List;

import org.jumutang.zsh.model.OilModel;

/**
 * 油的服务层
 * 
 * @author 鲁雨
 * @since20161223
 * @version v1.0
 * 
 * copyright Luyu(18994139782@163.com)
 *
 */
public interface OilServiceI {
	
	/**
	 * 查询油价
	 * 
	 * @return list
	 */
	public List<OilModel> queryOil();

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
	 * @return int
	 */
	public int updateOil();
}
