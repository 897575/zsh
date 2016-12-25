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
 * �͵ķ����
 * 
 * @author ³��
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
	 * Ĭ�Ϲ���״̬2
	 */
	private final static Short INVALID =2;
	
	/**
	 * ����״̬Ϊ1
	 */
	private final static Short NORMAL =1;
	
	/**
	 * ��������
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
	 * ��ѯ�ͼ�
	 * 
	 * @return list
	 */
	public List<OilModel> queryOil() {
		
		return oilDaoI.queryOil(NORMAL);
		 
	}
}
