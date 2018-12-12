package com.ergou.jebrother.service;

import com.ergou.jebrother.entity.Inventory;

import java.util.List;

/**
 * @Author: 孙二狗
 * @Date: Created in 下午8:28 2018/7/25
 */
public interface InventoryService {

    List<Inventory> getInventoryList();

    Inventory getInventoryById(int inventoryId);

    boolean addInventory(Inventory inventory);

    boolean modifyInventory(Inventory inventory);

    boolean deleteInventory(int inventoryId);

}
