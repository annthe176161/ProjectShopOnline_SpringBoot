package org.shoponline.shoponline.repository;

import org.shoponline.shoponline.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Dung de giao tiep voi database
public interface CategoryRepository extends JpaRepository<Category, Integer> { // Kieu du lieu cua khoa chinh la Integer
}
