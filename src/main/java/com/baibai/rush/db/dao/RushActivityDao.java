package com.baibai.rush.db.dao;

import com.baibai.rush.db.po.RushActivity;

import java.util.List;

public interface RushActivityDao {

    public List<RushActivity> queryRushActivitysByStatus(int activityStatus);

    public void inertRushActivity(RushActivity rushActivity);

    public RushActivity queryRushActivityById(long activityId);

    public void updateRushActivity(RushActivity rushActivity);

    boolean lockStock(Long rushActivityId);

    boolean deductStock(Long rushActivityId);

    void revertStock(Long rushActivityId);
}
