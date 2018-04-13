/**
 * 
 */
package com.renji.controller;

import java.util.ArrayList;
import java.util.Date;
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

import com.renji.model.BmBedstatus;
import com.renji.service.BedstatusService;
import com.renji.utils.date.DateUtil;
import com.renji.utils.result.Result;
import com.renji.utils.result.ResultCode;

import net.sf.json.JSONObject;

/**
 * @author zhang
 *
 */
@Controller
@RequestMapping("/bed")
public class BedManagerController {
	
	@Autowired
	private BedstatusService bedstatusService;
	
	private static final String[] WEEK_DAYS = {"周一", "周二", "周三", "周四", "周五", "周六", "周日"};
	
	
	@RequestMapping("/saveBedStatus")
	@ResponseBody
	public Object saveBedStatus(HttpServletResponse response, HttpServletRequest request) {
	   String bedStatusStr = request.getParameter("bedStatus");
	   
	   try{
		   BmBedstatus bedstatus = (BmBedstatus) JSONObject.toBean(JSONObject.fromObject(bedStatusStr), BmBedstatus.class);
		   bedstatusService.saveBmBedstatus(bedstatus);
		   return new Result<Boolean>(ResultCode.SUCCESS, "请求成功", true);
	   } catch (Exception e){
		   e.printStackTrace();
		   return new Result<Boolean>(ResultCode.FAIL, "请求失败", false);
	   }
	}
	
	@RequestMapping("/getBedStatus")
	@ResponseBody
	public Object getBedStatus(HttpServletResponse response, HttpServletRequest request) {
	   JSONObject resJS = new JSONObject();
	   String begtime = request.getParameter("begtime");
	   String endtime = request.getParameter("endtime");
	   String bedIndexkey = request.getParameter("bedIndexkey");
	   
	   try{
		   Map<String, Object> params = new LinkedHashMap<String, Object>();
		   params.put("begtime", begtime);
		   params.put("endtime", endtime);
		   if(!StringUtils.isEmpty(bedIndexkey)){
				params.put("bedIndexkey", "%" + bedIndexkey + "%");
			}
		   List<BmBedstatus> bedStatusList = bedstatusService.getBmBedstatusList(params);
		   List<String> weekTitle = getWeekTitle(begtime, endtime);
		   resJS.put("dateData", weekTitle);
		   resJS.put("bedData", bedStatusList);
		   return new Result<JSONObject>(ResultCode.SUCCESS, "请求成功", resJS);
	   } catch (Exception e){
		   e.printStackTrace();
		   return new Result<JSONObject>(ResultCode.FAIL, "请求失败", null);
	   }
	}
	
	private List<String> getWeekTitle(String begtime, String endtime){
		List<String> weekTitle = new ArrayList<String>();
		Date begDate = DateUtil.convert2Date(begtime, "yyyy-MM-dd");
		for(int i = 0;i < WEEK_DAYS.length;i++){
			String dateStr = "(" + DateUtil.convert2String(DateUtil.addDays(begDate, i), "M.d") + ")";
			weekTitle.add(WEEK_DAYS[i] + dateStr);
		}
		return weekTitle;
	}
	
	@RequestMapping("/getRecordList")
	@ResponseBody
	public Object getRecordList(HttpServletResponse response, HttpServletRequest request) {
		String begtime = request.getParameter("begtime");
		String endtime = request.getParameter("endtime");

		Map<String, Object> params = new LinkedHashMap<String, Object>();
		params.put("begtime", begtime);
		params.put("endtime", endtime);
		try{
			List<Map<String, String>> resList = bedstatusService.getDistinctRecords(params);
			return new Result<List<Map<String, String>>>(ResultCode.SUCCESS, "请求成功", resList);
		} catch(Exception e){
			e.printStackTrace();
			return new Result<List<Map<String, String>>>(ResultCode.FAIL, e.getMessage(), null);
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
		   int num = bedstatusService.getBedRecordsNum(params);
		   if(num != 0){
			   return new Result<Boolean>(ResultCode.FAIL, "记录已存在", false);
		   }
		   bedstatusService.addRecord(begtime, endtime);
		   return new Result<Integer>(ResultCode.SUCCESS, "请求成功", num);
	   } catch(Exception e){
		   e.printStackTrace();
		   return new Result<Integer>(ResultCode.FAIL, e.getMessage(), 0);
	   }
	}
	
	@RequestMapping("/deleteRecord")
	@ResponseBody
	public Object deleteRecord(HttpServletResponse response, HttpServletRequest request){
		String bedindex = request.getParameter("bedindex");
		String begtime = request.getParameter("begtime");
		String endtime = request.getParameter("endtime");
		
		Map<String, Object> params = new LinkedHashMap<String, Object>();
		params.put("bedindex", bedindex);
		params.put("begtime", begtime);
		params.put("endtime", endtime);
		try{
			bedstatusService.deleteRecord(params);
			return new Result<Boolean>(ResultCode.SUCCESS, "删除床位成功", true);
		} catch(Exception e){
			e.printStackTrace();
			return new Result<Boolean>(ResultCode.FAIL, e.getMessage(), false);
		}
	}
}
