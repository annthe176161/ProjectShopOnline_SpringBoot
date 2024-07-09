package org.shoponline.shoponline.repository;

import org.shoponline.shoponline.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Page<Product> findByCategoryID_Id(int categoryId, Pageable pageable); // Tìm kiếm sản phẩm theo categoryId với phân trang

    Page<Product> findByProductNameContainingIgnoreCase(String name, Pageable pageable); // Tìm kiếm sản phẩm theo tên với phân trang
}
