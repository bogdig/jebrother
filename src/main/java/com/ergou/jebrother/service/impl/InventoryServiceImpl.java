package com.ergou.jebrother.service.impl;

import com.ergou.jebrother.dao.InventoryDao;
import com.ergou.jebrother.entity.Inventory;
import com.ergou.jebrother.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Author: 孙二狗
 * @Date: Created in 下午8:36 2018/7/25
 */

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryDao inventoryDao;

    @Override
    public List<Inventory> getInventoryList() {
        return inventoryDao.queryInventory();
    }

    @Override
    public Inventory getInventoryById(int inventoryId) {
        return inventoryDao.queryInventoryById(inventoryId);
    }

    @Transactional//添加事物控制
    @Override
    public boolean addInventory(Inventory inventory) {

        if (inventory.getInventoryName() != null && "".equals(inventory.getInventoryName())
                && inventory.getModel() != null && "".equals(inventory.getModel())
                && inventory.getTotalNum() != null && inventory.getTotalNum() != 0.0
                && inventory.getUnitPrice() != null
                && inventory.getTotalAmount() != null) {

            try {
                inventory.setPurchaseDate(new Date());
                int effectedNum = inventoryDao.insertInventory(inventory);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("库存仪器信息录入失败！");
                }
            } catch (RuntimeException ex) {
                throw new RuntimeException("库存仪器信息录入失败: " + ex.getMessage());
            }
        } else {
            throw new RuntimeException("库存仪器信息录入不全！");
        }

    }

    @Transactional//添加事物控制
    @Override
    public boolean modifyInventory(Inventory inventory) {

        if (inventory.getInventoryName() != null && "".equals(inventory.getInventoryName())
                && inventory.getModel() != null && "".equals(inventory.getModel())
                && inventory.getTotalNum() != null && inventory.getTotalNum() != 0.0
                && inventory.getUnitPrice() != null
                && inventory.getTotalAmount() != null) {

            try {
                int effectedNum = inventoryDao.updateInventory(inventory);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("库存仪器信息修改失败！");
                }
            } catch (RuntimeException ex) {
                throw new RuntimeException("库存仪器信息修改失败: " + ex.getMessage());
            }
        } else {
            throw new RuntimeException("库存仪器信息不全！");
        }
    }

    @Override
    public boolean deleteInventory(int inventoryId) {

        if (inventoryId > 0) {
            try {
                int effectedNum = inventoryDao.deleteInventory(inventoryId);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("库存仪器信息删除失败！");
                }
            } catch (RuntimeException ex) {
                throw new RuntimeException("库存仪器信息删除失败: " + ex.getMessage());
            }
        } else {
            throw new RuntimeException("请输入正确的库存信息id！");
        }
    }
}
