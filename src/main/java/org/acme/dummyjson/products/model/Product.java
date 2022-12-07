package org.acme.dummyjson.products.model;

public record Product(
        Integer id,
        String title,
        String description,
        Integer price,
        Double discountPercentage,
        Double rating,
        Integer stock,
        String brand,
        String category,
        String thumbnail
//        List<Images> images
) {
}
