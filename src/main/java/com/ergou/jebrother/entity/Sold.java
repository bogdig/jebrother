package com.ergou.jebrother.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: 孙二狗
 * @Date: Created in 下午9:00 2018/7/23
 */
public class Sold {

    //主键id
    private Integer soldId;

    //机器名称
    private String soldName;

    //机器型号
    private String model;

    //出货日期
    private Date shipDate;

    //经手人
    private String handPerson;

    //卖价
    private BigDecimal sellPrice;

    //利润
    private BigDecimal profit;

    public Integer getSoldId() {
        return soldId;
    }

    public void setSoldId(Integer soldId) {
        this.soldId = soldId;
    }

    public String getSoldName() {
        return soldName;
    }

    public void setSoldName(String soldName) {
        this.soldName = soldName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getShipDate() {
        return shipDate;
    }

    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }

    public String getHandPerson() {
        return handPerson;
    }

    public void setHandPerson(String handPerson) {
        this.handPerson = handPerson;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }
}
