package org.jumutang.zsh.tools;

import java.util.UUID;

/**
 * 项目工具类
 * 
 * @author 鲁雨
 * @since20161223
 * @version v1.0
 * 
 * copyright Luyu(18994139782@163.com)
 *
 */
public class ZshUtil {
	
	/**
	 * 获取唯一id
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
