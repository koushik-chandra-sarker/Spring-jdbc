package com.springJdbc.two_withoutXml.DAO;

import com.springJdbc.two_withoutXml.Entity.Employ;

import java.util.List;

public interface EmployDAO {
    public int insert(Employ employ);
    public int change(Employ employ);
    public int delete(int employId);
    public Employ getEmploy(int employId);
    public List<Employ> getAllEmploys();
}
