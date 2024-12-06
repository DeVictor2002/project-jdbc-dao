package tech.victor.projects;

import tech.victor.projects.model.dao.DAOFactory;
import tech.victor.projects.model.dao.SellerDAO;
import tech.victor.projects.model.entities.Department;
import tech.victor.projects.model.entities.Seller;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SellerDAO sellerDAO = DAOFactory.createSellerDAO();
        System.out.println("==== TEST 1: seller findById ====");
        Seller seller = sellerDAO.findById(3);
        System.out.println(seller);

        System.out.println("\n==== TEST 2: seller findByDepartment ====");
        Department department = new Department(2, null);
        List<Seller> list = sellerDAO.findByDepartment(department);
        for (Seller s : list) {
            System.out.println(s);
        }

        System.out.println("\n==== TEST 3: seller findAll ====");
        list = sellerDAO.findAll();
        for (Seller s : list) {
            System.out.println(s);
        }
    }
}