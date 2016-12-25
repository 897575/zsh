package org.jumutang.zsh.controller;

import java.util.List;

import org.jumutang.zsh.model.TopModel;
import org.jumutang.zsh.services.TopServiceI;
import org.jumutang.zsh.tools.ResResult;
import org.jumutang.zsh.tools.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * �������Ʋ�
 * 
 * @author ³��
 * @since 20161225
 * @version v1.0
 * 
 * copyright Luyu(18994139782@163.com)
 *
 */
@Controller
@RequestMapping("/top")
public class TopController {
	@Autowired
	private TopServiceI topService;
	/**
	 * ��ѯ����������Ϣ
	 * @return resResult
	 */
	@ResponseBody
	@RequestMapping("/query")
	public ResResult queryTop(Short type){
		List<TopModel> list = topService.queryAll();
		if(list.size()==0){
			return ResponseModel.errorActive("��������");
		}
		return ResponseModel.returnDate(list);
	}
}
