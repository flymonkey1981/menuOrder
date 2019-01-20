package com.menuorder.demo.repository;

import com.menuorder.demo.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Customer findByUserName(String userName);

    @Query("FROM Customer c WHERE c.userName = ?1 and c.password = ?2")
    Customer findCustomerByUsernameAndPassword(String userName, String password);
}
