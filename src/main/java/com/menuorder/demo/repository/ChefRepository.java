package com.menuorder.demo.repository;

import com.menuorder.demo.entity.Chef;
import com.menuorder.demo.entity.Food;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChefRepository extends CrudRepository<Chef, Long> {
    @Query("FROM Chef")
    public List<Chef> getAll();
}
