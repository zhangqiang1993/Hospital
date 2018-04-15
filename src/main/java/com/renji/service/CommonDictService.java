package com.renji.service;

import java.util.List;

import com.renji.model.CommonDict;

public interface CommonDictService {
	public List<CommonDict> getDictByName(String fieldID, String fieldName, String fieldXH, String tableName);
}
