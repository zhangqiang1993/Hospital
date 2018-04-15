/**
 * 
 */
package com.renji.service;

import java.util.List;
import java.util.Map;

import com.renji.model.EmHistory;

/**
 * @author zhang
 *
 */
public interface BedHistoryService {
	
	public List<EmHistory> getEmHistoryList(Map<String, Object> params);
	
	public void insert(EmHistory history);
}
