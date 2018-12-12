package com.ergou.jebrother.service;

import com.ergou.jebrother.entity.Sold;

import java.util.List;

/**
 * @Author: 孙二狗
 * @Date: Created in 下午7:15 2018/7/25
 */
public interface SoldService {

    List<Sold> getSoldList();

    Sold getSoldById(int soldId);

    boolean addSold(Sold sold);

    boolean modifySold(Sold sold);

    boolean deleteSold(int soldId);

}
