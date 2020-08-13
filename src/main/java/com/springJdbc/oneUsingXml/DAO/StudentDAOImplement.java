package com.springJdbc.oneUsingXml.DAO;

import com.springJdbc.oneUsingXml.Entity.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class StudentDAOImplement implements StudentDAO {
    private JdbcTemplate jdbcTemplate;


    @Override
    public int insert(Student student) {
        String query = "insert into student(id,name,city) values(?, ?, ?)";
        return jdbcTemplate.update(query, student.getId(),student.getName(),student.getCity());

    }

    @Override
    public int change(Student student) {
        String query = "update student set name=?, city=? where id=?";
        return jdbcTemplate.update(query, student.getName(),student.getCity(),student.getId());
    }

    @Override
    public int delete(int studentId) {
        String query = "delete from student where id=?";
        return jdbcTemplate.update(query, studentId);
    }

    @Override
    public Student getStudent(int studentId) {
        String query = "select * from student where id=?";
        RowMapper<Student> rowMapper = new rowMapperImplement();
        return (Student) jdbcTemplate.queryForObject(query, rowMapper,studentId);

    }

    @Override
    public List<Student> getAllStudents() {
        String query = "select * from student";
        return jdbcTemplate.query(query,new rowMapperImplement());

    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
