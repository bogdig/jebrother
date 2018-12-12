package com.ergou.jebrother.dao;

import com.ergou.jebrother.entity.Sold;

import java.util.List;

/**
 * @Author: 孙二狗
 * @Date: Created in 下午7:54 2018/7/24
 */
public interface SoldDao {

    /**
     * 查询所有已售仪器
     * @return
     */
    List<Sold> querySold();

    /**
     * 通过soldId查询已售仪器
     * @param soldId
     * @return
     */
    Sold querySoldById(int soldId);

    /**
     * 插入已售仪器
     * @param sold
     * @return
     */
    int insertSold(Sold sold);

    /**
     * 修改已售仪器
     * @param sold
     * @return
     */
    int updateSold(Sold sold);

    /**
     * 删除已售仪器
     * @param soldId
     * @return
     */
    int deleteSold(int soldId);

}
