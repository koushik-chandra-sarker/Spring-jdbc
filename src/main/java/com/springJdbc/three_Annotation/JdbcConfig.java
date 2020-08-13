package com.springJdbc.three_Annotation;

import com.springJdbc.three_Annotation.DAO.EmployDAO;
import com.springJdbc.three_Annotation.DAO.EmployDAOImplement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.springJdbc.three_Annotation.DAO")
public class JdbcConfig {
    @Bean("ds")
    public DataSource getDatasource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3307/springJdbc");
        ds.setUsername("root");
        ds.setPassword("0000");
        return ds;
    }

    @Bean("jdbcTemplate")
    public JdbcTemplate getJdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(getDatasource());
        return jdbcTemplate;
    }

}
