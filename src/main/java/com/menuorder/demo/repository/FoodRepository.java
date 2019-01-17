package com.menuorder.demo.repository;

import com.menuorder.demo.entity.Food;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends CrudRepository<Food, Long> {
    @Query("FROM Food")
    public List<Food> getAll();
}
