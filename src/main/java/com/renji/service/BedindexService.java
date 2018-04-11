/**
 * 
 */
package com.renji.service;

import java.util.List;
import java.util.Map;

import com.renji.model.EmBedindex;

/**
 * @author zhang
 *
 */
public interface BedindexService {
	
	public List<EmBedindex> getBmBedindexList(Map<String, Object> params);
	
	public void insert(EmBedindex bedindex);
}
