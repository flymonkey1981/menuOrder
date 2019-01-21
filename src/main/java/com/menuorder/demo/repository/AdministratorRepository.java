package com.menuorder.demo.repository;

import com.menuorder.demo.entity.Administrator;
import com.menuorder.demo.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AdministratorRepository extends CrudRepository<Administrator, Long> {

    @Query("FROM Administrator c WHERE c.userName = ?1 and c.password = ?2")
    Administrator findAdminByUsernameAndPassword(String userName, String password);
}
