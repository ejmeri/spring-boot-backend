package com.curse.business.products.control;

import java.util.List;

import com.curse.business.categories.entity.Category;
import com.curse.business.products.entity.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT DISTINCT obj FROM  Product obj INNER JOIN obj.categories cat WHERE obj.name LIKE %:name% AND cat IN :categories")
    Page<Product> findByNameAndCategoriesIn(@Param("name") String name, @Param("categories") List<Category> categories,
            Pageable pageRequest);
}
