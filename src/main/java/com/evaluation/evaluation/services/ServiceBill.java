package com.evaluation.evaluation.services;

import com.evaluation.evaluation.entityes.Bill;
import com.evaluation.evaluation.entityes.Customer;
import com.evaluation.evaluation.repositories.RepositorieBill;
import com.evaluation.evaluation.repositories.RepositorieCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceBill {
    @Autowired
    private RepositorieBill repositorieBill;

    @Autowired
    private RepositorieCustomer repositorieCustomer;

    public ServiceBill(RepositorieBill repositorieBill){
        this.repositorieBill = repositorieBill;
    }


    public List<Bill> findAll(){
        return repositorieBill.findAll();
    }

    public Bill findById(String number){
        Optional<Bill> bill = repositorieBill.findById(number);
        return bill.isPresent() ? bill.get() : null;
    }

    public Bill save(Bill bill, Integer idCustomer){
        Customer customer = repositorieCustomer.findById(idCustomer).get();
        bill.setCustomer(customer);
        return repositorieBill.save(bill);
    }

    public  Bill update(String id, Bill billN){
        Bill bill = repositorieBill.findById(id).get();

        if (bill!=null){
            bill.setDate_bill(billN.getDate_bill());
            bill.setCustomer(billN.getCustomer());
            bill.setTotal(billN.getTotal());
            bill.setType_pay(billN.getType_pay());
            return repositorieBill.save(bill);
        }else{
            return null;
        }
    }

    public boolean delete(String id){
        Optional<Bill> optional = repositorieBill.findById(id);

        if (optional.isPresent()){
            repositorieBill.delete(optional.get());
            return true;
        }else{
            return false;
        }
    }

    public List<Bill> findByCustomer(Integer id){
        Optional<Customer> optional = repositorieCustomer.findById(id);
        if (optional.isPresent()){
            return repositorieBill.findByCustomer(optional.get());
        }else{
            return null;
        }
    }

    public List<Bill> findByPay(String id){
        return repositorieBill.findByTypePay(id);
    }

    public List<Bill> findByDate(LocalDate start,LocalDate end){
        return repositorieBill.findByDateBetween(start,end);
    }
}
