package com.springJdbc.three_Annotation.DAO;

import com.springJdbc.three_Annotation.Entity.Employ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("employDAO")
public class EmployDAOImplement implements EmployDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(Employ employ) {
        String query = "insert into employ(id,name,city) values(?, ?, ?)";
        return jdbcTemplate.update(query, employ.getId(),employ.getName(),employ.getCity());

    }

    @Override
    public int change(Employ employ) {
        String query = "update employ set name=?, city=? where id=?";
        return jdbcTemplate.update(query, employ.getName(),employ.getCity(),employ.getId());
    }

    @Override
    public int delete(int employId) {
        String query = "delete from employ where id=?";
        return jdbcTemplate.update(query, employId);
    }

    @Override
    public Employ getEmploy(int employId) {
        String query = "select * from employ where id=?";
        RowMapper<Employ> rowMapper = new rowMapperImplement();
        return jdbcTemplate.queryForObject(query, rowMapper,employId);

    }

    @Override
    public List<Employ> getAllEmploys() {
        String query = "select * from employ";
        return jdbcTemplate.query(query,new rowMapperImplement());

    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
