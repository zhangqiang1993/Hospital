/**
 * 
 */
package com.renji.controller;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.renji.model.BmBedstatus;
import com.renji.model.EmBedindex;
import com.renji.service.BedindexService;
import com.renji.service.BedstatusService;
import com.renji.utils.result.Result;
import com.renji.utils.result.ResultCode;

import net.sf.json.JSONObject;

/**
 * @author zhang
 *
 */
@Controller
@RequestMapping("/bedmotify")
public class BedModifyController {
	@Autowired
	private BedindexService bedindexService;
	@Autowired
	private BedstatusService bedstatusService;
	
	
	@RequestMapping("/addBed")
	@ResponseBody
	public Object addBed(HttpServletResponse response, HttpServletRequest request){
		String newBedStr = request.getParameter("bedData");
		try{
			JSONObject json = JSONObject.fromObject(newBedStr);
			String bedIndex = json.getString("bedIndex");
			String isTemp = json.getString("isTemp");
			String begtime = json.getString("begtime");
			String endtime = json.getString("endtime");
			
			Map<String, Object> params = new LinkedHashMap<String, Object>();
			params.put("bedindex", bedIndex);
			params.put("begtime", begtime);
			params.put("endtime", endtime);
			List<BmBedstatus> statusList = bedstatusService.getBmBedstatusList(params);
			if(statusList != null && statusList.size() > 0){
				return new Result<Boolean>(ResultCode.FAIL, "已存在床位编号", false);
			}
			// 不是临时床位，检查是否插入新床位
			if("0".equals(isTemp)){
				params.clear();
				params.put("bedindex", bedIndex);
				List<EmBedindex> indexList = bedindexService.getBmBedindexList(params);
				if(indexList == null || indexList.size() == 0){
					bedindexService.insert(new EmBedindex(bedIndex, new Date()));
				}
			}
			BmBedstatus bedstatus = new BmBedstatus();
			bedstatus.setBedindex(bedIndex);
			bedstatus.setBegtime(begtime);
			bedstatus.setEndtime(endtime);
			bedstatusService.insertBmBedstatus(bedstatus);
			return new Result<Boolean>(ResultCode.SUCCESS, "新增床位成功", true);
		} catch (Exception e){
			e.printStackTrace();
			return new Result<Boolean>(ResultCode.FAIL, "新增床位失败", false);
		}
	}
}
