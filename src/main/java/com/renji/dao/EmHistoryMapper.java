package com.renji.dao;

import java.util.List;
import java.util.Map;

import com.renji.model.EmHistory;

public interface EmHistoryMapper {
    int delete(Map<String, Object> params);

    int insert(EmHistory record);

    List<EmHistory> select(Map<String, Object> params);
}