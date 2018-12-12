package com.ergou.jebrother.config.dao;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;

/**
 * @Author: 孙二狗
 * @Date: Created in 下午11:05 2018/7/23
 */
@Configuration
//设置mybatis扫描路径
@MapperScan("com.ergou.jebrother.dao")
public class DataSourceConfiguration {

    @Value("${jdbc.driver}")
    private String jdbcDriver;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.user}")
    private String jdbcUser;
    @Value("${jdbc.password}")
    private String jdbcPassword;

    @Bean(name = "dataSource")//c3p0
    public ComboPooledDataSource createDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();//数据库连接池

        //设置驱动
        dataSource.setDriverClass(jdbcDriver);

        //设置url
        dataSource.setJdbcUrl(jdbcUrl);

        //设置用户
        dataSource.setUser(jdbcUser);

        //设置密码
        dataSource.setPassword(jdbcPassword);

        // 配置c3p0连接池的私有属性
        // 连接池最大线程数
        dataSource.setMaxPoolSize(30);
        // 连接池最小线程数
        dataSource.setMinPoolSize(10);
        // 连接超时时间
        dataSource.setCheckoutTimeout(10000);
        // 连接失败重试次数
        dataSource.setAcquireRetryAttempts(2);

        return dataSource;


    }

    @Bean(name = "druidDataSource")//阿里巴巴druid
    public DruidDataSource createDruidDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(jdbcDriver);
        druidDataSource.setUrl(jdbcUrl);
        druidDataSource.setUsername(jdbcUser);
        druidDataSource.setPassword(jdbcPassword);

        //连接池参数配置
        //设置连接池初始值大小
        druidDataSource.setInitialSize(1);
        //设置连接池空闲大小
        druidDataSource.setMinIdle(10);
        //设置连接池峰值大小
        druidDataSource.setMaxActive(20);
        //设置连接池等待连接时间
        druidDataSource.setMaxWait(60000);
        //设置连接池检测空闲线程时间间隔
        druidDataSource.setTimeBetweenConnectErrorMillis(6000);

        return druidDataSource;
    }

}
