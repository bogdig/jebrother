package com.ergou.jebrother.dao;


import com.ergou.jebrother.entity.Inventory;

import java.util.List;

/**
 * @Author: 孙二狗
 * @Date: Created in 下午7:54 2018/7/24
 */
public interface InventoryDao {

    /**
     * 查询库存仪器
     * @return
     */
    List<Inventory> queryInventory();

    /**
     * 通过id查询库存仪器
     * @param inventoryId
     * @return
     */
    Inventory queryInventoryById(int inventoryId);

    /**
     * 插入库存仪器
     * @param inventoryDao
     * @return
     */
    int insertInventory(Inventory inventory);

    /**
     * 修改库存仪器
     * @param inventoryDao
     * @return
     */
    int updateInventory(Inventory inventory);

    /**
     * 删除库存数据
     * @param inventoryId
     * @return
     */
    int deleteInventory(int inventoryId);
}
