package org.jumutang.zsh.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jumutang.zsh.dao.TopDaoI;
import org.jumutang.zsh.model.OilModel;
import org.jumutang.zsh.model.TopModel;
import org.jumutang.zsh.services.OilServiceI;
import org.jumutang.zsh.services.TopServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("topService")
public class TopServiceImpl implements TopServiceI {

	@Autowired
	private TopDaoI topDaoI;
	
	/**
	 * 默认失效状态
	 */
	private final static Short LOSE_EFFICACY=2;
	
	/**
	 * 默认正常状态
	 */
	private final static Short OK_STATUS=1;
	/**
	 * 查询排名信息
	 * @return list
	 */
	public List<TopModel> queryAll() {

		return topDaoI.queryAll(OK_STATUS);
	}

	/**
	 * 批量插入排名信息
	 * 
	 * @param list
	 * @return int
	 */
	public int batchInsertTop(List<TopModel> list) {
		return topDaoI.batchInsertTop(list);	
	}
	
	/**
	 * 批量更新
	 * 
	 * @param param
	 * 
	 * @return int
	 */
	public int updateTop() {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("osEfficacy", LOSE_EFFICACY);
		param.put("now", OK_STATUS);
		return topDaoI.updateTop(param);
	}

	public List<TopModel> queryTopByType(Short type) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("status", OK_STATUS);
		param.put("type", type);
		return topDaoI.queryTopByType(param);
	}
}
