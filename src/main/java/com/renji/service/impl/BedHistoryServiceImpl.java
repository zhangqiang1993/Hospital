/**
 * 
 */
package com.renji.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.renji.dao.BmBedstatusMapper;
import com.renji.dao.EmBedindexMapper;
import com.renji.dao.EmHistoryMapper;
import com.renji.model.BmBedstatus;
import com.renji.model.EmBedindex;
import com.renji.model.EmHistory;
import com.renji.service.BedHistoryService;

/**
 * @author zhang
 *
 */
@Service
public class BedHistoryServiceImpl implements BedHistoryService {
	
	@Autowired
	private EmHistoryMapper historyMapper;
	@Autowired
	private BmBedstatusMapper bedstatusMapper;
	@Autowired
	private EmBedindexMapper bedindexMapper;

	public List<EmHistory> getEmHistoryList(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return historyMapper.select(params);
	}

	
	// 添加日期记录
	@Transactional
	public void insert(EmHistory history) {
		// TODO Auto-generated method stub
		historyMapper.insert(history);
		Map<String, Object> params = new LinkedHashMap<String, Object>();
		List<EmBedindex> beedindexList = bedindexMapper.select(params);
		List<BmBedstatus> bedStatusList = new ArrayList<BmBedstatus>();
		for(EmBedindex emBedindex : beedindexList){
			bedStatusList.add(new BmBedstatus(emBedindex.getBedindex(), 
					history.getBegtime(), history.getEndtime()));
		}
		if(bedStatusList != null && bedStatusList.size() > 0){
			bedstatusMapper.insertByBatch(bedStatusList);
		}
	}
}
