package org.workshop.coffee.repository;

import org.workshop.coffee.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.List;
import java.util.Locale;

@Repository
public class SearchRepository {

    @Autowired
    EntityManager em;

    @Autowired
    DataSource dataSource;

    public List<Product> searchProduct (String input) {
        // lower the input
        var lowerInput = input.toLowerCase(Locale.ROOT);
        // create a query to search for the input in the product name or description using prepared statements
        var query = em.createNativeQuery(
            "SELECT * FROM Product WHERE lower(description) LIKE ? OR lower(product_name) LIKE ?",
            Product.class
        );
        query.setParameter(1, "%" + lowerInput + "%");
        query.setParameter(2, "%" + lowerInput + "%");

        // get the result list
        var resultList = (List<Product>) query.getResultList();
        return resultList;
    }

}
