package com.ergou.jebrother.service.impl;

import com.ergou.jebrother.dao.SoldDao;
import com.ergou.jebrother.entity.Sold;
import com.ergou.jebrother.service.SoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Author: 孙二狗
 * @Date: Created in 下午7:18 2018/7/25
 */

@Service
public class SoldServiceImpl implements SoldService {

    @Autowired
    private SoldDao soldDao;

    @Override
    public List<Sold> getSoldList() {
        return soldDao.querySold();
    }

    @Override
    public Sold getSoldById(int soldId) {
        return soldDao.querySoldById(soldId);
    }

    @Transactional//添加事物控制
    @Override
    public boolean addSold(Sold sold) {

        if (sold.getSoldName() != null && !"".equals(sold.getSoldName())
                && sold.getModel() != null && !"".equals(sold.getModel())
                && sold.getHandPerson() != null && !"".equals(sold.getHandPerson())
                && sold.getSellPrice() != null && sold.getSellPrice() != new BigDecimal(0.0)
                && sold.getProfit() != null && sold.getProfit() != new BigDecimal(0.0)) {
            try {
                sold.setShipDate(new Date());
                int effectedNum = soldDao.insertSold(sold);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入已售仪器信息失败！");
                }
            } catch (RuntimeException ex) {
                throw new RuntimeException("插入已售仪器信息失败: " + ex.getMessage());
            }

        } else {
            throw new RuntimeException("录入的已售仪器信息不完整！");
        }
    }

    @Transactional//添加事物控制
    @Override
    public boolean modifySold(Sold sold) {
        if (sold.getSoldName() != null && !"".equals(sold.getSoldName())
                && sold.getModel() != null && !"".equals(sold.getModel())
                && sold.getHandPerson() != null && !"".equals(sold.getHandPerson())
                && sold.getSellPrice() != null && sold.getSellPrice() != new BigDecimal(0.0)
                && sold.getProfit() != null && sold.getProfit() != new BigDecimal(0.0)) {
            try {
                int effectedNum = soldDao.updateSold(sold);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("修改已售仪器信息失败!");
                }
            } catch (RuntimeException ex) {
                throw new RuntimeException("修改已售仪器信息失败: " + ex.getMessage());
            }

        } else {
            throw new RuntimeException("需要修改的已售仪器信息不完整！");
        }
    }

    @Transactional//添加事物控制
    @Override
    public boolean deleteSold(int soldId) {
        if (soldId > 0) {
            try {
                int effectedNum = soldDao.deleteSold(soldId);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除已售仪器信息失败！");
                }
            } catch (RuntimeException ex) {
                throw new RuntimeException("删除已售仪器信息失败: " + ex.getMessage());
            }
        } else {
            throw new RuntimeException("请传入正确的已售仪器信息！");
        }
    }
}
