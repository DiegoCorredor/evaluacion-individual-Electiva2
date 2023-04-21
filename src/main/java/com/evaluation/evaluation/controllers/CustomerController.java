package com.evaluation.evaluation.controllers;

import com.evaluation.evaluation.entityes.Customer;
import com.evaluation.evaluation.repositories.RepositorieCustomer;
import com.evaluation.evaluation.response.ResponseHandler;
import com.evaluation.evaluation.services.ServiceCustomer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private ServiceCustomer serviceCustomer;

    public CustomerController(ServiceCustomer serviceCustomer){ this.serviceCustomer = serviceCustomer; }

    @GetMapping
    public ResponseEntity<Object> findAll(){
        try{
            List<Customer> result = serviceCustomer.findAll();
            return new ResponseHandler().generateResponse("success completed", HttpStatus.OK, result);
        }catch (Exception e){
            return new ResponseHandler().generateResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Integer id){
        try{
            Customer result = serviceCustomer.findById( id );

            return new ResponseHandler().generateResponse("Success Completed!", HttpStatus.OK,result);
        }catch(Exception e ){

            return new ResponseHandler().generateResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,null);
        }
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Customer customer ){
        if(customer.getGender().toString() == "M" || customer.getGender().toString() == "F"){
            try{
                Customer result = serviceCustomer.save( customer );
                return new ResponseHandler().generateResponse("Success Completed!", HttpStatus.OK,result);
            }catch(Exception e ){
                return new ResponseHandler().generateResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,null);
            }
        }
        return new ResponseHandler().generateResponse("Error in gender, the value maybe be M or F. Try again.",HttpStatus.NOT_ACCEPTABLE,null);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody Customer customer, @PathVariable int id){
        try{
            Customer result = serviceCustomer.update(id,customer);
            return new ResponseHandler().generateResponse("Update Completed!", HttpStatus.OK,result);
        }catch(Exception e ){

            return new ResponseHandler().generateResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity update(@PathVariable int id){
        try{
            Boolean result = serviceCustomer.delete(id);
            return new ResponseHandler().generateResponse("Delete Completed!", HttpStatus.OK,result);
        }catch(Exception e ){

            return new ResponseHandler().generateResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,null);
        }
    }


}
