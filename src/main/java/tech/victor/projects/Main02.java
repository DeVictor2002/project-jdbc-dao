package tech.victor.projects;

import tech.victor.projects.db.DB;
import tech.victor.projects.model.dao.DAOFactory;
import tech.victor.projects.model.dao.DepartmentDAO;
import tech.victor.projects.model.entities.Department;

public class Main02 {
    public static void main(String[] args) {
        DepartmentDAO departmentDAO = DAOFactory.createDepartmentDAO();
        System.out.println("\n==== TEST 1: department insert ====");
        Department department = new Department(null, "Games");
        departmentDAO.insert(department);
        System.out.println("Inserted! New id: " + department.getId());
    }
}
