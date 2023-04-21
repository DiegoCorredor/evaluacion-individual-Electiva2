package com.evaluation.evaluation.repositories;

import com.evaluation.evaluation.entityes.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RepositorieCustomer extends JpaRepository<Customer, Integer> {
}
