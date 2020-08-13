package com.springJdbc.three_Annotation.DAO;

import com.springJdbc.three_Annotation.Entity.Employ;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class rowMapperImplement implements RowMapper<Employ> {

    @Override
    public Employ mapRow(ResultSet resultSet, int i) throws SQLException {
        Employ employ = new Employ();
        employ.setId(resultSet.getInt(1));
        employ.setName(resultSet.getString(2));
        employ.setCity(resultSet.getString(3));
        return employ;
    }
}
