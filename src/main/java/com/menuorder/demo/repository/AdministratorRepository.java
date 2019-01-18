package com.menuorder.demo.repository;

import com.menuorder.demo.entity.Administrator;
import com.menuorder.demo.entity.Chef;
import org.springframework.data.repository.CrudRepository;

public interface AdministratorRepository extends CrudRepository<Administrator, Long> {
}
