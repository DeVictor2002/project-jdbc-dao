package tech.victor.projects;

import tech.victor.projects.model.dao.DAOFactory;
import tech.victor.projects.model.dao.SellerDAO;
import tech.victor.projects.model.entities.Department;
import tech.victor.projects.model.entities.Seller;

import java.util.Date;
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

        System.out.println("\n==== TEST 4: seller insert ====");
        Seller seller1 = new Seller(null, "Greg", "Greg@gmail.com", new Date(), 4000.0, department);
        sellerDAO.insert(seller1);
        System.out.println("Inserted! New id: " + seller1.getId());

        System.out.println("\n==== TEST 5: seller update ====");
        seller = sellerDAO.findById(1);
        seller.setName("Martha Wayne");
        sellerDAO.update(seller);
        System.out.println("Update Completed!");
    }
}