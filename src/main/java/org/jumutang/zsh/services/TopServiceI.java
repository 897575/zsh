package org.jumutang.zsh.services;

import java.util.List;
import java.util.Map;

import org.jumutang.zsh.model.TopModel;

/**
 * ������dao�ӿ�
 * 
 * @author ³��
 * @since20161223
 * @version v1.0
 * 
 * copyright Luyu(18994139782@163.com)
 *
 */
public interface TopServiceI {
	
	/**
	 * ��ѯ������Ϣ
	 * @return list
	 */
	public List<TopModel> queryAll();
	
	/**
	 * �������Ͳ�ѯ������Ϣ
	 * @return list
	 */
	public List<TopModel> queryTopByType(Short type);
	
	/**
	 * ��������������Ϣ
	 * 
	 * @param list
	 * @return int
	 */
	public int batchInsertTop(List<TopModel> list);
	
	/**
	 * ��������
	 * 
	 * @return int
	 */
	public int updateTop();
}
