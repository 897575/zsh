package org.jumutang.zsh.tools;

import java.util.UUID;

/**
 * ��Ŀ������
 * 
 * @author ³��
 * @since20161223
 * @version v1.0
 * 
 * copyright Luyu(18994139782@163.com)
 *
 */
public class ZshUtil {
	
	/**
	 * ��ȡΨһid
	 * @return string
	 */
	public static String createUuid(){
		String id = UUID.randomUUID().toString();
		return id.replace("-", "");
	}
	public static void main(String[] args) {
		System.out.println(ZshUtil.createUuid());
	}
}
