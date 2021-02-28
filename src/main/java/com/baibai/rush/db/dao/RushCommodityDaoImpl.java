package com.baibai.rush.db.dao;

import com.baibai.rush.db.mappers.RushCommodityMapper;
import com.baibai.rush.db.po.RushCommodity;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class RushCommodityDaoImpl implements RushCommodityDao {

    @Resource
    private RushCommodityMapper rushCommodityMapper;

    @Override
    public RushCommodity queryRushCommodityById(long commodityId) {
        return rushCommodityMapper.selectByPrimaryKey(commodityId);
    }
}
