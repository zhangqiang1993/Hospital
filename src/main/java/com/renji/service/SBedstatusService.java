/**
 * 
 */
package com.renji.service;

import java.util.List;
import java.util.Map;

import com.renji.model.BmSBedstatus;

/**
 * @author zhang
 *
 */
public interface SBedstatusService {
	public List<BmSBedstatus> getBmBedstatusList(Map<String, Object> params);
	
	public int updateBmSBedstatus(BmSBedstatus bedstatus);
	
	public int insertBmBedstatus(BmSBedstatus bedstatus);
	
	public int deleteBmSBedstatus(Map<String, Object> params);
}
