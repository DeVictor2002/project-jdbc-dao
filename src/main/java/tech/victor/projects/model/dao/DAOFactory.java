package tech.victor.projects.model.dao;

import tech.victor.projects.db.DB;
import tech.victor.projects.model.dao.impl.DepartmentDAOimplJDBC;
import tech.victor.projects.model.dao.impl.SellerDAOimplJDBC;

public class DAOFactory {

    public static SellerDAO createSellerDAO() {
        return new SellerDAOimplJDBC(DB.getConnection());
    }

    public static DepartmentDAO createDepartmentDAO() {
        return new DepartmentDAOimplJDBC(DB.getConnection());
    }
}
