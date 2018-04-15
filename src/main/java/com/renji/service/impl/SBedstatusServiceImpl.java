/**
 * 
 */
package com.renji.service.impl;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.renji.dao.BmSBedstatusMapper;
import com.renji.model.BmSBedstatus;
import com.renji.service.SBedstatusService;

/**
 * @author zhang
 *
 */
@Service
public class SBedstatusServiceImpl implements SBedstatusService {
	
	private static final Logger logger = Logger.getLogger(SBedstatusServiceImpl.class.getName());
	
	@Autowired
	private BmSBedstatusMapper sBedstatusMapper;

	public List<BmSBedstatus> getBmBedstatusList(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return sBedstatusMapper.select(params);
	}
	
	// 更新床位状态
	@Transactional
	public int updateBmSBedstatus(BmSBedstatus bedstatus) {
		// TODO Auto-generated method stub
		return sBedstatusMapper.update(bedstatus);
	}
	
	// 插入一条床位信息
	public int insertBmBedstatus(BmSBedstatus bedstatus) {
		// TODO Auto-generated method stub
		return sBedstatusMapper.insert(bedstatus);
	}

	
	// 删除记录和床位信息
	@Transactional
	public int deleteBmSBedstatus(Map<String, Object> params) {
		// TODO Auto-generated method stub
		int resColor = sBedstatusMapper.delete(params);
		logger.info("deleteColor: resColor = " + resColor);
		return resColor;
	}
	
}
