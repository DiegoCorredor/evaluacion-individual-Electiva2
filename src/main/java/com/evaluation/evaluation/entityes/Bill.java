package com.evaluation.evaluation.entityes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "bill")
public class Bill {

    @Id
    @Column(length = 15)
    private String number;

    @Column(nullable = false)
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private Type_Pay typePay;

    @Column(nullable = false)
    private Double total;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Customer customer;

    public Bill(){}

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getDate_bill() {
        return date;
    }

    public void setDate_bill(LocalDate date_bill) {
        this.date = date_bill;
    }

    public Type_Pay getType_pay() {
        return typePay;
    }

    public void setType_pay(Type_Pay type_pay) {
        this.typePay = type_pay;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString(){
        return "Bill{"+"id='"+number+'\''+",date_bill='"+date+'\''+",type_pay='"+typePay+'\''+",total='"+total+'\''+",customer=\'"+customer+'}';
    }
}
