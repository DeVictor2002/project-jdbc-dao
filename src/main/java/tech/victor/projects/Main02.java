package tech.victor.projects;

import tech.victor.projects.model.dao.DAOFactory;
import tech.victor.projects.model.dao.DepartmentDAO;
import tech.victor.projects.model.entities.Department;

import java.util.List;

public class Main02 {
    public static void main(String[] args) {
        DepartmentDAO departmentDAO = DAOFactory.createDepartmentDAO();
        System.out.println("\n==== TEST 1: department insert ====");
        Department department = new Department(null, "Games");
        departmentDAO.insert(department);
        System.out.println("Inserted! New id: " + department.getId());

        System.out.println("\n==== TEST 2: department findAll ====");
        List<Department> departments = departmentDAO.findAll();
        for (Department department1 : departments) {
            System.out.println(department1);
        }
    }
}
