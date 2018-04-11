/**
 * 
 */
package com.renji.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.renji.dao.EmBedindexMapper;
import com.renji.model.EmBedindex;
import com.renji.service.BedindexService;

/**
 * @author zhang
 *
 */
@Service
public class BedindexServiceImpl implements BedindexService {
	
	@Autowired
	private EmBedindexMapper bedindexMapper;

	public List<EmBedindex> getBmBedindexList(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return bedindexMapper.select(params);
	}

	
	// 添加日期记录
	@Transactional
	public void insert(EmBedindex bedindex) {
		// TODO Auto-generated method stub
		bedindexMapper.insert(bedindex);
	}
}
