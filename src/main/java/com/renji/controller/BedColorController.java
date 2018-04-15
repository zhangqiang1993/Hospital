package com.renji.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.renji.model.BmSBedstatus;
import com.renji.service.SBedstatusService;
import com.renji.utils.result.Result;
import com.renji.utils.result.ResultCode;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/color")
public class BedColorController {
	
	@Autowired
	private SBedstatusService sBedstatusService;
	
	
	// 保存状态和颜色
	@RequestMapping("/saveColor")
	@ResponseBody
	public Object saveColor(HttpServletResponse response, HttpServletRequest request) {
	   String sBedStatusStr = request.getParameter("sBedStatus");
	   
	   try{
		   BmSBedstatus bedstatus = (BmSBedstatus) JSONObject.toBean(JSONObject.fromObject(sBedStatusStr), BmSBedstatus.class);
		   if(bedstatus.getNm() != null && !bedstatus.getNm().equals(-1)){
			   sBedstatusService.updateBmSBedstatus(bedstatus);
		   } else {
			   sBedstatusService.insertBmBedstatus(bedstatus);
		   }
		   return new Result<Boolean>(ResultCode.SUCCESS, "保存状态成功", true);
	   } catch (Exception e){
		   e.printStackTrace();
		   return new Result<Boolean>(ResultCode.FAIL, "保存状态失败", false);
	   }
	}
	
	// 获取颜色和状态
	@RequestMapping("/getColors")
	@ResponseBody
	public Object getColors(HttpServletResponse response, HttpServletRequest request) {
	   
	   try{
		   Map<String, Object> params = new LinkedHashMap<String, Object>();
		   List<BmSBedstatus> statuslist = sBedstatusService.getBmBedstatusList(params);
		   return new Result<List<BmSBedstatus>>(ResultCode.SUCCESS, "请求成功", statuslist);
	   } catch (Exception e){
		   e.printStackTrace();
		   return new Result<List<BmSBedstatus>>(ResultCode.FAIL, "请求失败", null);
	   }
	}
	
	
	// 删除颜色和状态
	@RequestMapping("/deleteColor")
	@ResponseBody
	public Object deleteColor(HttpServletResponse response, HttpServletRequest request) {
		
		String nmStr = request.getParameter("nm");
	   
	   try{
		   Integer nm = Integer.parseInt(nmStr);
		   Map<String, Object> params = new LinkedHashMap<String, Object>();
		   params.put("nm", nm);
		   sBedstatusService.deleteBmSBedstatus(params);
		   return new Result<Boolean>(ResultCode.SUCCESS, "删除状态成功", true);
	   } catch (Exception e){
		   e.printStackTrace();
		   return new Result<Boolean>(ResultCode.FAIL, "删除状态失败", false);
	   }
	}

}
