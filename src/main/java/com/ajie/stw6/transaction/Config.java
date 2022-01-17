package com.ajie.stw6.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author wyj
 * @since 2022/1/17
 */
@Configuration
@EnableTransactionManagement
public class Config {
    @Autowired
    DataSource dataSource;

}
