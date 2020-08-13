package com.springJdbc.two_withoutXml;

import com.springJdbc.two_withoutXml.DAO.EmployDAO;
import com.springJdbc.two_withoutXml.DAO.EmployDAOImplement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class JdbcConfig {
    @Bean("ds")
    public DataSource getDatasource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
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

    @Bean("employDAO")
    public EmployDAO getEmployDAO(){
       EmployDAOImplement employDAOImplement = new EmployDAOImplement();
        employDAOImplement.setJdbcTemplate(getJdbcTemplate());
        return employDAOImplement;
    }
}
