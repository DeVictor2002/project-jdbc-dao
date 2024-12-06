package tech.victor.projects.model.dao;

import tech.victor.projects.model.dao.impl.SellerDAOimplJDBC;

public class DAOFactory {

    public static SellerDAO createSellerDAO() {
        return new SellerDAOimplJDBC();
    }
}
