package com.evaluation.evaluation.services;

import com.evaluation.evaluation.entityes.Customer;
import com.evaluation.evaluation.repositories.RepositorieCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ServiceCustomer {
    @Autowired
    private RepositorieCustomer repositorieCustomer;

    public ServiceCustomer(RepositorieCustomer repositorieCustomer){

        this.repositorieCustomer = repositorieCustomer;
    }

    public List<Customer> findAll(){

        return repositorieCustomer.findAll();
    }

    public Customer findById(Integer idCustomer){
        Optional<Customer> customer= repositorieCustomer.findById(idCustomer);
        return customer.isPresent() ? customer.get() : null;
    }

    public Customer save(Customer customer){

        return repositorieCustomer.save(customer);
    }

    public Customer update(Integer id, Customer customer) {
        Customer customerS = repositorieCustomer.findById(id).get();
        if (customerS!=null){
            customer.setBirthday(customer.getBirthday());
            customer.setGender(customer.getGender());
            customer.setName(customer.getName());
            return repositorieCustomer.save(customer);
        }else{
            return null;
        }
    }

    public boolean delete(Integer id) {
        Optional<Customer> optional = repositorieCustomer.findById(id);
        if (optional.isPresent()){
            repositorieCustomer.delete(optional.get());
            return true;
        }else{
            return false;
        }
    }
}
