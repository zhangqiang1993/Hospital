/**
 * 
 */
package com.renji.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renji.dao.BedDictMapper;
import com.renji.model.CommonDict;
import com.renji.service.CommonDictService;

/**
 * @author zhang
 *
 */
@Service
public class CommonDictServiceImpl implements CommonDictService {
	
	@Autowired
	private BedDictMapper bedDictMapper;
	
	/* (non-Javadoc)
	 * @see com.renji.service.CommonDictService#getDictByName(java.util.Map)
	 */
	public List<CommonDict> getDictByName(String fieldID, String fieldName, String fieldXH, String tableName) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new LinkedHashMap<String, Object>();
		params.put("fieldID", fieldID);
		params.put("fieldName", fieldName);
		params.put("fieldXH", fieldXH);
		params.put("tableName", tableName);
		return bedDictMapper.select(params);
	}

}
