package com.baibai.rush.db.dao;

import com.baibai.rush.db.mappers.RushActivityMapper;
import com.baibai.rush.db.po.RushActivity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Repository
public class RushActivityDaoImpl implements RushActivityDao {

    @Resource
    private RushActivityMapper rushActivityMapper;

    @Override
    public List<RushActivity> queryRushActivitysByStatus(int activityStatus) {
        return rushActivityMapper.queryRushActivitysByStatus(activityStatus);
    }

    @Override
    public void inertRushActivity(RushActivity rushActivity) {
        rushActivityMapper.insert(rushActivity);
    }

    @Override
    public RushActivity queryRushActivityById(long activityId) {
        return rushActivityMapper.selectByPrimaryKey(activityId);
    }

    @Override
    public void updateRushActivity(RushActivity rushActivity) {
        rushActivityMapper.updateByPrimaryKey(rushActivity);
    }

   @Override
    public boolean lockStock(Long rushActivityId) {
        //int result = rushActivityMapper.lockStock( rushActivityId );FIXME
       int result = 1;
        if (result < 1) {
            log.error("锁定库存失败");
            return false;
        }
        return true;
    }

    @Override
    public boolean deductStock(Long rushActivityId) {
        //int result = rushActivityMapper.deductStock(rushActivityId);FIXME
        int result = 1;
        if (result < 1) {
            log.error("扣减库存失败");
            return false;
        }
        return true;
    }

    @Override
    public void revertStock(Long rushActivityId) {
        //rushActivityMapper.revertStock(rushActivityId);FIXME
    }
}
