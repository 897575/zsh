package org.jumutang.zsh.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ʱ�������
 * 
 * @author ³��
 * @since 20161224
 * @version v1.0
 * 
 * copyright Luyu(18994139782@163.com)
 *
 */
public class DateUtil {

	/**
	 * ��ȡ��ǰʱ���ַ�
	 * @return string
	 */
	public static String getDate(){
		Date date = new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("YYYY/MM/dd");
		return sdf.format(date);
	}
}
