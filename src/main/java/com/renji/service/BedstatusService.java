/**
 * 
 */
package com.renji.service;

import java.util.List;
import java.util.Map;

import com.renji.model.BmBedstatus;

/**
 * @author zhang
 *
 */
public interface BedstatusService {
	public List<BmBedstatus> getBmBedstatusList(Map<String, Object> params);
	
	public List<Map<String, String>> getDistinctRecords(Map<String, Object> params);
	
	public int getBedRecordsNum(Map<String, Object> params);
	
	public void addRecord(String begtime, String endtime);
	
	public int saveBmBedstatus(BmBedstatus bedstatus);
	
	public int insertBmBedstatus(BmBedstatus bedstatus);
}
