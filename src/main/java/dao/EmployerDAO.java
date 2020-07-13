package dao;

import entity.Emp;

import java.sql.SQLException;
import java.util.List;

public interface EmployerDAO {

    //create
    void add(Emp emp) throws SQLException;

    //read
    List<Emp> getAll() throws SQLException;

    List<Emp> getEmpByID(int id, boolean p) throws SQLException;
    //update
    void update(Emp emp) throws SQLException;

    //delete
    void remove(int id) throws SQLException;







}
