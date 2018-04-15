/**
 * 
 */
package com.renji.dao;

import java.util.List;
import java.util.Map;

import com.renji.model.CommonDict;

/**
 * @author zhang
 *
 */
public interface BedDictMapper {
	public List<CommonDict> select(Map<String, Object> params);
}
