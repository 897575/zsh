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
	 * Ĭ��ʧЧ״̬
	 */
	private final static Short LOSE_EFFICACY=2;
	
	/**
	 * Ĭ������״̬
	 */
	private final static Short OK_STATUS=1;
	/**
	 * ��ѯ������Ϣ
	 * @return list
	 */
	public List<TopModel> queryAll() {

		return topDaoI.queryAll(OK_STATUS);
	}

	/**
	 * ��������������Ϣ
	 * 
	 * @param list
	 * @return int
	 */
	public int batchInsertTop(List<TopModel> list) {
		return topDaoI.batchInsertTop(list);	
	}
	
	/**
	 * ��������
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
