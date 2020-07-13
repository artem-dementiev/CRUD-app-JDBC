package service;

import java.sql.*;
import java.util.*;
import connect.DatabaseConnection;
import dao.EmployerDAO;
import entity.Emp;

public class EmployerService extends DatabaseConnection implements EmployerDAO {

    Connection conn = initializeDatabase();

    @Override
    public void add(Emp emp) throws SQLException {
        PreparedStatement ps = null;

//        String sql = "INSERT INTO employer (id_emp, name_emp, surname_emp, id_e_role, employment_date, phone_number_emp, id_e_department) VALUES(?,?,?,?,?,?,?)";
        String sql = "INSERT INTO employer (name_emp, surname_emp, id_e_role, employment_date, phone_number_emp, id_e_department) VALUES(?,?,?,?,?,?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, emp.getName_emp());
            System.out.println("+++\n"+emp.getName_emp());
            ps.setString(2, emp.getSurname_emp());
            System.out.println(emp.getSurname_emp());
            ps.setInt(3,emp.getId_e_role());
            System.out.println(emp.getId_e_role());
            ps.setString(4, emp.getEmployment_date());
            System.out.println(emp.getEmployment_date());
            ps.setString(5, emp.getPhone_number_emp());
            System.out.println(emp.getPhone_number_emp());
            ps.setInt(6,emp.getId_e_department());
            System.out.println(emp.getId_e_department());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(ps != null){
                ps.close();
            }
            if(conn != null){
                conn.close();
            }
        }
    }

    @Override
    public List<Emp> getAll() throws SQLException {
        List<Emp> empList = new ArrayList<>();

//        String sql = "Select * FROM employer";
        String sql = "Select id_emp, name_emp,surname_emp, id_e_role, employment_date, phone_number_emp, id_e_department, name_role, name_department " +
                "FROM employer JOIN role ON employer.id_e_role = role.id_role " +
                "JOIN department ON department.id_department = employer.id_e_department " +
                "ORDER BY employer.id_emp";

        Statement statement = null;
        try {
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()){
                Emp emp = new Emp();
                emp.setId_emp(rs.getInt("id_emp"));
                emp.setName_emp(rs.getString("name_emp"));
                emp.setSurname_emp(rs.getString("surname_emp"));
                emp.setId_e_role(rs.getInt("id_e_role"));
                emp.setName_department(rs.getString("name_department"));
                emp.setName_role(rs.getString("name_role"));
                emp.setEmployment_date(rs.getString("employment_date"));
                emp.setPhone_number_emp(rs.getString("phone_number_emp"));
                emp.setId_e_department(rs.getInt("id_e_department"));

                empList.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(statement != null){
                statement.close();
            }
            if(conn != null){
                conn.close();
            }
        }
        return empList;
    }
    //second parametr is which query to use
    @Override
    public List<Emp> getEmpByID(int id, boolean p) throws SQLException{
        List<Emp> empList = new LinkedList<>();
        PreparedStatement ps = null;
        String sql;
        if(p == false){ sql = "Select * FROM employer where id_emp=?";}
        else{ sql = "Select id_emp, name_emp,surname_emp, id_e_role, employment_date, phone_number_emp, id_e_department, name_role, name_department " +
                "FROM employer JOIN role ON employer.id_e_role = role.id_role " +
                "JOIN department ON department.id_department = employer.id_e_department "+
                "where id_emp=?";}
        Emp emp = new Emp();
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                emp.setId_emp(rs.getInt("id_emp"));
                emp.setName_emp(rs.getString("name_emp"));
                emp.setSurname_emp(rs.getString("surname_emp"));
                emp.setId_e_role(rs.getInt("id_e_role"));
                emp.setEmployment_date(rs.getString("employment_date"));
                emp.setPhone_number_emp(rs.getString("phone_number_emp"));
                emp.setId_e_department(rs.getInt("id_e_department"));
                if(p){
                    emp.setName_department(rs.getString("name_department"));
                    emp.setName_role(rs.getString("name_role"));
                }
                empList.add(emp);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(ps != null){
                ps.close();
            }
            if(conn != null){
                conn.close();
            }
        }
        return empList;
    }

    @Override
    public void update(Emp emp) throws SQLException {
        PreparedStatement ps = null;
        String sql = "UPDATE employer SET name_emp=?,surname_emp=?, id_e_role=?, employment_date=?, phone_number_emp=?, id_e_department=? where id_emp=?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, emp.getName_emp());
            ps.setString(2, emp.getSurname_emp());
            ps.setInt(3,emp.getId_e_role());
            ps.setString(4, emp.getEmployment_date());
            ps.setString(5, emp.getPhone_number_emp());
            ps.setInt(6,emp.getId_e_department());
            ps.setInt(7,emp.getId_emp());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(ps != null){
                ps.close();
            }
            if(conn != null){
                conn.close();
            }
        }
    }

    @Override
    public void remove(int id) throws SQLException {
        PreparedStatement ps = null;
        String sql = "DELETE FROM employer where id_emp=?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(ps != null){
                ps.close();
            }
            if(conn != null){
                conn.close();
            }
        }
    }
}
