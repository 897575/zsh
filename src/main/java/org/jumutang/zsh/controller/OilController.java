package org.jumutang.zsh.controller;

import java.util.List;

import org.jumutang.zsh.model.OilModel;
import org.jumutang.zsh.services.OilServiceI;
import org.jumutang.zsh.tools.ResResult;
import org.jumutang.zsh.tools.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 油控制层
 * 
 * @author 鲁雨
 * @since 20161225
 * @version v1.0
 * 
 * copyright Luyu(18994139782@163.com)
 *
 */
@Controller
@RequestMapping("/oil")
public class OilController {
	@Autowired
	private OilServiceI oilService;

	/**
	 * 查询所有排名信息
	 * @return resResult
	 */
	@ResponseBody
	@RequestMapping("/query")
	public ResResult queryOil(){
		
	   List<OilModel> list = oilService.queryOil();
	   if(list.size()==0){
		   return ResponseModel.errorActive("暂无数据");
	   }
		return ResponseModel.returnDate(list);
	}
}
