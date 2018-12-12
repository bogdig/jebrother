package com.ergou.jebrother.web;

import com.ergou.jebrother.entity.Inventory;
import com.ergou.jebrother.service.InventoryService;
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
 * @Date: Created in 下午8:56 2018/7/26
 */
@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @RequestMapping(value = "/inventoryList", method = RequestMethod.GET)
    private Map<String,Object> getInventoryList(){
        Map<String, Object> inventoryMap = new HashMap<>();
        List<Inventory> inventoryList = inventoryService.getInventoryList();
        inventoryMap.put("success", inventoryList);
        return inventoryMap;
    }

    @RequestMapping(value = "/getIventoryById", method = RequestMethod.GET)
    private Map<String, Object> getInventoryById(Integer inventoryId){
        Map<String, Object> inventoryMap = new HashMap<>();
        Inventory inventory = inventoryService.getInventoryById(inventoryId);
        inventoryMap.put("success", inventory);
        return inventoryMap;
    }

    @RequestMapping(value = "/addInventory", method = RequestMethod.POST)
    //传入的数据可能不是inventory格式
    private Map<String, Object> addInventory(@RequestBody Inventory inventory){
        Map<String, Object> inventoryMap = new HashMap<>();
        inventoryMap.put("success", inventoryService.addInventory(inventory));
        return inventoryMap;
    }

    @RequestMapping(value = "/modifyInventory", method = RequestMethod.POST)
    private Map<String, Object> modifyInventory(@RequestBody Inventory inventory){
        Map<String, Object> inventoryMap = new HashMap<>();
        inventoryMap.put("success", inventoryService.modifyInventory(inventory));
        return inventoryMap;
    }

    @RequestMapping(value = "/removeInventory", method = RequestMethod.GET)
    private Map<String,Object> removeInventory(Integer inventoryId){
        Map<String, Object> inventoryMap = new HashMap<>();
        inventoryMap.put("success", inventoryService.deleteInventory(inventoryId));
        return inventoryMap;
    }

    @RequestMapping(value = "/aoptesti", method = RequestMethod.GET)
    private void testAop(){
        System.out.println("aoptestiiii");
    }


}
