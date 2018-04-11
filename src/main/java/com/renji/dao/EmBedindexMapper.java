package com.renji.dao;

import java.util.List;
import java.util.Map;

import com.renji.model.EmBedindex;

public interface EmBedindexMapper {
	List<EmBedindex> select(Map<String, Object> params);
	
    int delete(Map<String, Object> params);

    int insert(EmBedindex record);
    
    int update(EmBedindex record);
}