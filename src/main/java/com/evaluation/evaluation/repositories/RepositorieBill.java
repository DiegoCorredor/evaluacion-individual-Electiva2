package com.evaluation.evaluation.repositories;

import com.evaluation.evaluation.entityes.Bill;
import com.evaluation.evaluation.entityes.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RepositorieBill extends JpaRepository<Bill, String> {
    List<Bill> findByCustomer(Customer customer);
    List<Bill> findByDateBetween(LocalDate startDate, LocalDate endDate);
    List<Bill> findByTypePay(String pay);
}
