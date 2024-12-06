package tech.victor.projects;

import tech.victor.projects.model.dao.DAOFactory;
import tech.victor.projects.model.dao.SellerDAO;
import tech.victor.projects.model.entities.Seller;

public class Main {
    public static void main(String[] args) {
        SellerDAO sellerDAO = DAOFactory.createSellerDAO();
        Seller seller = sellerDAO.findById(3);
        System.out.println(seller);
    }
}