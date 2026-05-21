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
        // lowercase the input
        var lowerInput = input.toLowerCase(Locale.ROOT);
        // create a native query to search for products by name or description
        var query = em.createNativeQuery(
            "SELECT * FROM Product WHERE lower(description) LIKE :term OR lower(product_name) LIKE :term",
            Product.class);
        query.setParameter("term", "%" + lowerInput + "%");
        // get and return result list
        return query.getResultList();
    }
}
