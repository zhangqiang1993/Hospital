/**
 * 
 */
package com.renji.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.renji.model.EmHistory;
import com.renji.service.BedHistoryService;
import com.renji.utils.result.Result;
import com.renji.utils.result.ResultCode;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author zhang
 *
 */
@Controller
@RequestMapping("/history")
public class BedHistoryController {
	
	@Autowired
	private BedHistoryService bedHistoryService;
	
	
	@RequestMapping("/getRecordList")
	@ResponseBody
	public Object getRecordList(HttpServletResponse response, HttpServletRequest request) {
		JSONArray jsonArr = new JSONArray();
		String begtime = request.getParameter("begtime");
		String endtime = request.getParameter("endtime");

		Map<String, Object> params = new LinkedHashMap<String, Object>();
		params.put("begtime", begtime);
		params.put("endtime", endtime);
		try{
			List<EmHistory> resList = bedHistoryService.getEmHistoryList(params);
			for(EmHistory history : resList){
				JSONObject json = JSONObject.fromObject(history);
				json.put("recordName", history.getBegtime() + "~" + history.getEndtime());
				jsonArr.add(json);
			}
			return new Result<JSONArray>(ResultCode.SUCCESS, "请求成功", jsonArr);
		} catch(Exception e){
			e.printStackTrace();
			return new Result<JSONArray>(ResultCode.FAIL, e.getMessage(), null);
		}
	}
	
	@RequestMapping("/addRecord")
	@ResponseBody
	public Object addRecord(HttpServletResponse response, HttpServletRequest request) {
	   String begtime = request.getParameter("begtime");
	   String endtime = request.getParameter("endtime");
	   if(StringUtils.isEmpty(begtime) || StringUtils.isEmpty(endtime)){
		   return new Result<Boolean>(ResultCode.FAIL, "参数错误", false);
	   }
	   Map<String, Object> params = new LinkedHashMap<String, Object>();
	   params.put("begtime", begtime);
	   params.put("endtime", endtime);
	   try{
		   List<EmHistory> resList = bedHistoryService.getEmHistoryList(params);
		   if(resList != null && resList.size() > 0){
			   return new Result<Boolean>(ResultCode.FAIL, "记录已存在", false);
		   }
		   EmHistory history = new EmHistory();
		   history.setBegtime(begtime);
		   history.setEndtime(endtime);
		   bedHistoryService.insert(history);
		   return new Result<Boolean>(ResultCode.SUCCESS, "保存成功", true);
	   } catch(Exception e){
		   e.printStackTrace();
		   return new Result<Boolean>(ResultCode.FAIL, e.getMessage(), false);
	   }
	}
}
