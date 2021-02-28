package com.baibai.rush.DaoTest;
import com.baibai.rush.db.dao.RushActivityDao;
import com.baibai.rush.db.mappers.RushActivityMapper;
import com.baibai.rush.db.po.RushActivity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
@SpringBootTest
public class DaoTest {
    @Resource
    private RushActivityMapper rushActivityMapper;
    @Autowired
    private RushActivityDao rushActivityDao;
    @Test
    void RushActivityTest() {
        RushActivity rushActivity = new RushActivity();
        rushActivity.setName("测试");
        rushActivity.setCommodityId(999L);
        rushActivity.setTotalStock(100L);
        rushActivity.setRushPrice(new BigDecimal(99));
        rushActivity.setActivityStatus(16);
        rushActivity.setOldPrice(new BigDecimal(99));
        rushActivity.setAvailableStock(100);
        rushActivity.setLockStock(0L);
        rushActivityMapper.insert(rushActivity);
        System.out.println("====>>>>" +
                rushActivityMapper.selectByPrimaryKey(28L));
    }
    @Test
    void setRushActivityQuery(){
        List<RushActivity> rushActivitys =
                rushActivityDao.queryRushActivitysByStatus(0);
        System.out.println(rushActivitys.size());
        rushActivitys.stream().forEach(rushActivity ->
                System.out.println(rushActivity.toString()));
    }
}
