package com.menuorder.demo.repository;

import java.util.List;

import com.menuorder.demo.entity.SampleEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface SampleRepository extends CrudRepository<SampleEntity, Long> {

    @Query("FROM SampleEntity")
    public List<SampleEntity> getAll();
}
