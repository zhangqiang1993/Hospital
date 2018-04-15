/**
 * 
 */
package com.renji.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.renji.model.CommonDict;
import com.renji.service.CommonDictService;

/**
 * @author zhang
 *
 */
@Controller
@RequestMapping("/dict")
public class DictController {
	@Autowired
	private CommonDictService dictService;

	// 获取状态字典表
	@RequestMapping("/getStatusDict")
	@ResponseBody
	public Object getStatusDict(HttpServletResponse response, HttpServletRequest request) {
		try{
			List<CommonDict> list = dictService.getDictByName("NM", "MC", "XH", "BM_S_BEDSTATUS");
			return list;
		} catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
