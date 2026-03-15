package com.mycomp.krishi.persistence.specification;

import com.mycomp.krishi.persistence.entity.FarmerProduct;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FarmerProductSpecification {

    public static Specification<FarmerProduct> withFilters(Long excludeUserId, Map<String, String> filters) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Always exclude the requesting user's own listings
            predicates.add(cb.notEqual(root.get("userId"), excludeUserId));

            // Only unsold products
            predicates.add(cb.or(
                    cb.isNull(root.get("sold")),
                    cb.isFalse(root.get("sold"))
            ));

            Join<Object, Object> product = root.join("product", JoinType.LEFT);

            if (filters != null) {
                filters.forEach((key, value) -> {
                    if (value == null || value.trim().isEmpty()) return;
                    String upper = value.trim().toUpperCase();
                    switch (key) {
                        case "category":
                            predicates.add(cb.equal(cb.upper(product.get("category")), upper));
                            break;
                        case "city":
                            predicates.add(cb.equal(cb.upper(root.get("city")), upper));
                            break;
                        case "search":
                            String pattern = "%" + upper + "%";
                            predicates.add(cb.or(
                                    cb.like(cb.upper(product.get("name")), pattern),
                                    cb.like(cb.upper(root.get("description")), pattern)
                            ));
                            break;
                        case "minPrice":
                            predicates.add(cb.greaterThanOrEqualTo(
                                    root.get("pricePerUnit"), Double.parseDouble(value.trim())));
                            break;
                        case "maxPrice":
                            predicates.add(cb.lessThanOrEqualTo(
                                    root.get("pricePerUnit"), Double.parseDouble(value.trim())));
                            break;
                        case "quantityUnit":
                            predicates.add(cb.equal(cb.upper(root.get("quantityUnit")), upper));
                            break;
                        // add more filter keys here as needed
                    }
                });
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
