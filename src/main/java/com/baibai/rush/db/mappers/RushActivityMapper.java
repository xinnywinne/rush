package com.baibai.rush.db.mappers;

import com.baibai.rush.db.po.RushActivity;
import java.util.List;

public interface RushActivityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RushActivity record);

    int insertSelective(RushActivity record);

    RushActivity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RushActivity record);

    int updateByPrimaryKey(RushActivity record);

    List<RushActivity> queryRushActivitysByStatus(int activityStatus);
}