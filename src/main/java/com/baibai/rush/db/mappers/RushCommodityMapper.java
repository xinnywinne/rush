package com.baibai.rush.db.mappers;

import com.baibai.rush.db.po.RushCommodity;

public interface RushCommodityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RushCommodity record);

    int insertSelective(RushCommodity record);

    RushCommodity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RushCommodity record);

    int updateByPrimaryKey(RushCommodity record);
}