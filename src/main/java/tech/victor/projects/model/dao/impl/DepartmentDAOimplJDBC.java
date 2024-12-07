package tech.victor.projects.model.dao.impl;

import tech.victor.projects.db.DB;
import tech.victor.projects.db.DbException;
import tech.victor.projects.model.dao.DepartmentDAO;
import tech.victor.projects.model.entities.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepartmentDAOimplJDBC implements DepartmentDAO {
    private Connection conn;

    public DepartmentDAOimplJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Department department) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "INSERT INTO department "
                    + "(Name) "
                    + "VALUES "
                    + "(?)", Statement.RETURN_GENERATED_KEYS
            );
            st.setString(1, department.getName());
            int rowsAffected = st.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    department.setId(id);
                }
                DB.closeResultSet(rs);
            } else {
                throw new DbException("Unexpected error ! No rows affected.");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void update(Department department) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Department findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT * from department "
                    + "WHERE Id = ?"
            );
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                Department department = new Department();
                department.setId(rs.getInt("Id"));
                department.setName(rs.getString("Name"));
                return department;
            }
            return null;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
    }

    @Override
    public List<Department> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT * FROM department"
            );
            rs = st.executeQuery();
            List<Department> departments = new ArrayList<Department>();
            Map<Integer, Department> map = new HashMap<Integer, Department>();
            while (rs.next()) {
                Department department = map.get(rs.getInt("Id"));
                if (department == null) {
                    department = new Department();
                    department.setId(rs.getInt("Id"));
                    department.setName(rs.getString("Name"));
                    map.put(department.getId(), department);
                    departments.add(department);
                }
            }
            return departments;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
    }
}
