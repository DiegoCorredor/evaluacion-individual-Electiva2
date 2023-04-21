package com.evaluation.evaluation.controllers;

import com.evaluation.evaluation.entityes.Bill;
import com.evaluation.evaluation.entityes.Customer;
import com.evaluation.evaluation.response.ResponseHandler;
import com.evaluation.evaluation.services.ServiceBill;
import com.evaluation.evaluation.services.ServiceCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/bills")
public class BillController {
    @Autowired
    private ServiceBill serviceBill;

    @Autowired
    private ServiceCustomer serviceCustomer;

    public BillController(ServiceBill serviceBill){this.serviceBill = serviceBill;}

    @GetMapping
    public ResponseEntity<Object> getBills(){

        try{
            List<Bill> result = serviceBill.findAll();
            return new ResponseHandler().generateResponse("Success Completed!", HttpStatus.OK,result);
        }catch( Exception e ){
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,null);
        }
    }

    @GetMapping("/{number}")
    public ResponseEntity<Object> findById(@PathVariable String number){

        try{
            Bill result = serviceBill.findById(number);
            return new ResponseHandler().generateResponse("Success Completed!",HttpStatus.OK,result);
        }catch( Exception e ){
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,null);
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<Object> save( @RequestBody Bill bill, @PathVariable Integer id ){
        if( serviceCustomer.findById( id ) != null ){
            try{
                Bill result = serviceBill.save( bill, id);
                return new ResponseHandler().generateResponse("Success Completed!",HttpStatus.OK,result);
            }catch(Exception e){
                return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,null);
            }
        }
        return new ResponseHandler().generateResponse("Fail Author not Found", HttpStatus.NOT_ACCEPTABLE,null);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable String id, @RequestBody Bill bill){
        try{
            Bill result = serviceBill.update(id,bill);
            return new ResponseHandler().generateResponse("Update Completed!", HttpStatus.OK,result);
        }catch(Exception e ){

            return new ResponseHandler().generateResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity update(@PathVariable String id){
        try{
            Boolean result = serviceBill.delete(id);
            return new ResponseHandler().generateResponse("Delete Completed!", HttpStatus.OK,result);
        }catch(Exception e ){

            return new ResponseHandler().generateResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,null);
        }
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity getBillByCustomer(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(serviceBill.findByCustomer(id));
    }

    @GetMapping("/pay/{id}")
    public ResponseEntity getBillByPay(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(serviceBill.findByPay(id));
    }
    @GetMapping("/datebill/{start}/{end}")
    public ResponseEntity getBillByDate(@PathVariable LocalDate start,@PathVariable LocalDate end) {
        return ResponseEntity.status(HttpStatus.OK).body(serviceBill.findByDate(start,end));
    }
}
