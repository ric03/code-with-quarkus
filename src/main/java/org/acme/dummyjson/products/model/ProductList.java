package org.acme.dummyjson.products.model;

import java.util.List;

public record ProductList(
        Integer total,
        Integer skip,
        Integer limit,
        List<Product> products
) {
}
