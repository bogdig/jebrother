package com.ergou.jebrother.aop;

import org.aspectj.lang.annotation.Pointcut;

/**
 * @Author: 孙二狗
 * @Date: Created in 7:22 PM 2018/12/11
 */
public class AopPointConfig {

    @Pointcut(value = "execution(* com.ergou.jebrother.web.InventoryController.*(..))")
    public void inventoryExecution(){}

//    @Pointcut(value = "execution(* com.ergou.jebrother.web.SoldController.*(..))")
//    public void soldExecution(){}
}
