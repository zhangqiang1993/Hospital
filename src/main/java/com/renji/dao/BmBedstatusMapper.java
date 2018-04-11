package com.renji.dao;

import java.util.List;
import java.util.Map;

import com.renji.model.BmBedstatus;

public interface BmBedstatusMapper {
	
	/*@Resource
    private SqlSessionTemplate sqlSessionTemplate;
	
    public int insert(BmBedstatus record){
    	return sqlSessionTemplate.insert(this.getClass().getName() + ".insert", record);
    }
    
    public List<BmBedstatus> select(Map<String, Object> params){
    	return sqlSessionTemplate.selectList(this.getClass().getName() + ".select", params);
    }

    public int update(BmBedstatus record){
    	return sqlSessionTemplate.update(this.getClass().getName() + ".update", record);
    }

    public int delete(Map<String, Object> params){
    	return sqlSessionTemplate.delete(this.getClass().getName() + ".delete", params);
    }*/
	
	int insert(BmBedstatus record);
	
	void insertByBatch(List<BmBedstatus> list);

    List<BmBedstatus> select(Map<String, Object> params);
    
    List<Map<String, String>> selectDistinct(Map<String, Object> params);

    int update(BmBedstatus record);

    int delete(Map<String, Object> params);
}