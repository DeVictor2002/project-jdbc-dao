package tech.victor.projects.model.dao;

import tech.victor.projects.model.entities.Department;
import tech.victor.projects.model.entities.Seller;

import java.util.List;

public interface SellerDAO {

    void insert(Seller seller);

    void update(Seller seller);

    void deleteById(Integer id);

    Department findById(Integer id);

    List<Department> findAll();
}
