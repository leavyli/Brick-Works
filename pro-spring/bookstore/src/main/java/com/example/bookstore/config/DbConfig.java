package com.example.bookstore.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

/**
 * @author: saino
 * @date: 2022/5/14 16:23
 */
@Configuration
public class DbConfig {

    @Bean
    @Profile("test")
    public DataSource h2DataSource() {
        //h2 datasource
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:h2:mem:mydb");
        dataSourceBuilder.username("sa");
        dataSourceBuilder.password("");
        return dataSourceBuilder.build();
    }

    @Bean
    @Primary
    @Profile("dev")
    public DataSource mysqlDevDataSource() {
        //mysql datasource
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:mysql://192.168.11.9:3306/bookstore?useUnicode=true&characterEncoding=utf8&useSSL=false");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("example");
        return dataSourceBuilder.build();
    }


}
