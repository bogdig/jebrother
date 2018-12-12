package com.ergou.jebrother.web;

import com.ergou.jebrother.entity.Sold;
import com.ergou.jebrother.service.SoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 孙二狗
 * @Date: Created in 下午6:51 2018/7/26
 */

@RestController
@RequestMapping("/sold")
public class SoldController {

    @Autowired
    private SoldService soldService;

    @RequestMapping(value = "/soldList", method = RequestMethod.GET)
    private Map<String, Object> getSoldList(){
        Map<String, Object> soldMap = new HashMap<>();
        List<Sold> soldList = soldService.getSoldList();
        soldMap.put("soldList", soldList);
        return soldMap;
    }

    @RequestMapping(value = "/getSoldById", method = RequestMethod.GET)
    private Map<String, Object> getSoldById(Integer soldId){
        Map<String, Object> soldMap = new HashMap<>();
        Sold sold = soldService.getSoldById(soldId);
        soldMap.put("sold", sold);
        return soldMap;
    }

    @RequestMapping(value = "/addSold", method = RequestMethod.POST)
    //添加@RequestBody注解防止前台传来的数据类型不是sold
    private Map<String, Object> addSold(@RequestBody Sold sold){
        Map<String, Object> soldMap = new HashMap<>();
        soldMap.put("success", soldService.addSold(sold));
        return soldMap;
    }

    @RequestMapping(value = "/modifySold", method = RequestMethod.POST)
    private Map<String, Object> modifySold(@RequestBody Sold sold){
        Map<String, Object> soldMap = new HashMap<>();
        soldMap.put("success", soldService.modifySold(sold));
        return soldMap;
    }

    @RequestMapping(value = "/removeSold", method = RequestMethod.GET)
    private Map<String, Object> removeSold(Integer soldId){
        Map<String, Object> soldMap = new HashMap<>();
        soldMap.put("success", soldService.deleteSold(soldId));
        return soldMap;
    }

    @RequestMapping(value = "/aoptests", method = RequestMethod.GET)
    private void testAop(){
        System.out.println("aoptestssss");
    }

}
