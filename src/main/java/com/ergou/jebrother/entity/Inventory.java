package com.ergou.jebrother.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: 孙二狗
 * @Date: Created in 下午9:01 2018/7/23
 */
public class Inventory {

    //主键id
    private Integer inventoryId;

    //名称
    private String inventoryName;

    //机器型号
    private String model;

    //总数
    private Integer totalNum;

    //卖出数
    private Integer soldNum;

    //进货日期
    private Date purchaseDate;

    //单价
    private BigDecimal unitPrice;

    //总价
    private BigDecimal totalAmount;

    public Integer getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getInventoryName() {
        return inventoryName;
    }

    public void setInventoryName(String inventoryName) {
        this.inventoryName = inventoryName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getSoldNum() {
        return soldNum;
    }

    public void setSoldNum(Integer soldNum) {
        this.soldNum = soldNum;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
