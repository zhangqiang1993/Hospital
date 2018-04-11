/**
 * 
 */
package com.renji.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.renji.dao.BmBedstatusMapper;
import com.renji.dao.EmBedindexMapper;
import com.renji.model.BmBedstatus;
import com.renji.model.EmBedindex;
import com.renji.service.BedstatusService;

/**
 * @author zhang
 *
 */
@Service
public class BedstatusServiceImpl implements BedstatusService {
	
	@Autowired
	private BmBedstatusMapper bedstatusMapper;
	@Autowired
	private EmBedindexMapper bedindexMapper;

	public List<BmBedstatus> getBmBedstatusList(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return bedstatusMapper.select(params);
	}
	
	// 获取历史记录
	public List<Map<String, String>> getDistinctRecords(Map<String, Object> params) {
		// TODO Auto-generated method stub
		List<Map<String, String>> distinctRecords = new ArrayList<Map<String, String>>();
		List<Map<String, String>> reccordList = bedstatusMapper.selectDistinct(params);
		if(reccordList != null){
			for(Map<String, String> map : reccordList){
				Map<String, String> recordsMap = new HashMap<String, String>();
				recordsMap.put("recordName", map.get("begtime") + "~" + map.get("endtime"));
				recordsMap.put("begtime", map.get("begtime"));
				recordsMap.put("endtime", map.get("endtime"));
				distinctRecords.add(recordsMap);
			}
		}
		return distinctRecords;
	}
	
	// 查询是否存在日期相关记录
	public int getBedRecordsNum(Map<String, Object> params) {
		// TODO Auto-generated method stub
		List<Map<String, String>> reccordList = bedstatusMapper.selectDistinct(params);
		return reccordList == null ? 0 : reccordList.size();
	}
	
	// 添加日期记录
	@Transactional
	public void addRecord(String begtime, String endtime) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new LinkedHashMap<String, Object>();
		List<EmBedindex> beedindexList = bedindexMapper.select(params);
		List<BmBedstatus> bedStatusList = new ArrayList<BmBedstatus>();
		for(EmBedindex emBedindex : beedindexList){
			bedStatusList.add(new BmBedstatus(emBedindex.getBedindex(), begtime, endtime));
		}
		bedstatusMapper.insertByBatch(bedStatusList);
	}
	
	// 更新床位状态
	@Transactional
	public int saveBmBedstatus(BmBedstatus bedstatus) {
		// TODO Auto-generated method stub
		return bedstatusMapper.update(bedstatus);
	}
	
	// 插入一条床位信息
	public int insertBmBedstatus(BmBedstatus bedstatus) {
		// TODO Auto-generated method stub
		return bedstatusMapper.insert(bedstatus);
	}
	
}
