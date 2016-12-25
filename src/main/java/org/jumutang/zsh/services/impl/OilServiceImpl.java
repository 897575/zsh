package org.jumutang.zsh.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jumutang.zsh.dao.OilDaoI;
import org.jumutang.zsh.model.OilModel;
import org.jumutang.zsh.services.OilServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service("oilService")
public class OilServiceImpl implements OilServiceI {
	
	@Autowired
	private OilDaoI oilDaoI;
	/**
	 * 默认过期状态2
	 */
	private final static Short INVALID =2;
	
	/**
	 * 正常状态为1
	 */
	private final static Short NORMAL =1;
	
	/**
	 * 批量插入
	 * 
	 * @param list
	 * 
	 * @return int
	 */
	public int batchInsertOil(List<OilModel> list) {
		return oilDaoI.batchInsertOil(list); 
	}

	public int updateOil() {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("Invalid",INVALID);
		param.put("normal", NORMAL);
		return oilDaoI.updateOil(param);
	}

	/**
	 * 查询油价
	 * 
	 * @return list
	 */
	public List<OilModel> queryOil() {
		
		return oilDaoI.queryOil(NORMAL);
		 
	}
}
