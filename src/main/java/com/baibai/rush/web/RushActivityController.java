package com.baibai.rush.web;

import com.baibai.rush.db.dao.RushActivityDao;
import com.baibai.rush.db.dao.RushCommodityDao;
import com.baibai.rush.db.po.RushActivity;
import com.baibai.rush.db.po.RushCommodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Controller
public class RushActivityController {
    @RequestMapping("/addRushActivity")
    public String addRushActivity() {
        return "add_activity";
    }

    @Autowired

    private RushActivityDao rushActivityDao;
    @RequestMapping("/addRushActivityAction")
    public String addRushActivityAction(
            @RequestParam("name") String name,
            @RequestParam("commodityId") long commodityId,
            @RequestParam("rushPrice") BigDecimal rushPrice,
            @RequestParam("oldPrice") BigDecimal oldPrice,
            @RequestParam("rushNumber") long rushNumber,
            @RequestParam("startTime") String startTime,
            @RequestParam("endTime") String endTime,
            Map<String, Object> resultMap
    ) throws ParseException, java.text.ParseException {
        startTime = startTime.substring(0, 10) + startTime.substring(11);
        endTime = endTime.substring(0, 10) + endTime.substring(11);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-ddhh:mm");
        RushActivity rushActivity = new RushActivity();
        rushActivity.setName(name);
        rushActivity.setCommodityId(commodityId);
        rushActivity.setRushPrice(rushPrice);
        rushActivity.setOldPrice(oldPrice);
        rushActivity.setTotalStock(rushNumber);
        rushActivity.setAvailableStock(new Integer("" + rushNumber));
        rushActivity.setLockStock(0L);
        rushActivity.setActivityStatus(1);
        rushActivity.setStartTime(format.parse(startTime));
        rushActivity.setEndTime(format.parse(endTime));
        rushActivityDao.inertRushActivity(rushActivity);
        resultMap.put("rushActivity", rushActivity);
        return "add_success";
    }
    @RequestMapping("/rush")
    public String activityList(Map<String, Object> resultMap) {
        List<RushActivity> rushActivities =
                rushActivityDao.queryRushActivitysByStatus(1);
        resultMap.put("rushActivities", rushActivities);
        return "rush_activity";
    }

    @Autowired
    private RushCommodityDao rushCommodityDao;
    @RequestMapping("/item/{rushActivityId}")
    public String itemPage(Map<String, Object> resultMap, @PathVariable long
            rushActivityId) {
        RushActivity rushActivity =
                rushActivityDao.queryRushActivityById(rushActivityId);
        RushCommodity rushCommodity =
                rushCommodityDao.queryRushCommodityById(rushActivity.getCommodityId());
        resultMap.put("rushActivity", rushActivity);
        resultMap.put("rushCommodity", rushCommodity);
        resultMap.put("rushPrice", rushActivity.getRushPrice());
        resultMap.put("oldPrice", rushActivity.getOldPrice());
        resultMap.put("commodityId", rushActivity.getCommodityId());
        resultMap.put("commodityName", rushCommodity.getCommodityName());
        resultMap.put("commodityDesc", rushCommodity.getCommodityDesc());
        return "rush_item";
    }
}

