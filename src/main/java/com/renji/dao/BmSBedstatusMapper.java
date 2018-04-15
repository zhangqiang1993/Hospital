package com.renji.dao;

import java.util.List;
import java.util.Map;

import com.renji.model.BmSBedstatus;

public interface BmSBedstatusMapper {
	
	int insert(BmSBedstatus record);

    List<BmSBedstatus> select(Map<String, Object> params);

    int update(BmSBedstatus record);

    int delete(Map<String, Object> params);
}