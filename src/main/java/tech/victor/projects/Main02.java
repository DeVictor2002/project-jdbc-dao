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

        System.out.println("\n==== TEST 3: department findById ====");
        Department department2 = departmentDAO.findById(3);
        System.out.println(department2);

        System.out.println("\n==== TEST 4: department update ====");
        department = departmentDAO.findById(3);
        department.setName("TI");
        departmentDAO.update(department);
        System.out.println("Update completed!");
    }
}
