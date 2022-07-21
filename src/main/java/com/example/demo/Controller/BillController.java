package com.example.demo.Controller;

import com.example.demo.Entity.Bill;
import com.example.demo.Repository.BillRepo;
import com.example.demo.Service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/bill")
public class BillController  {

    @Autowired
    private BillService billService;

    @PostMapping("/")
    public Bill addBill( @RequestBody  Bill bill) {
        return billService.addBill(bill);
    }

    @PutMapping("/")
    public Bill updateBill(@RequestBody  Bill bill) {
        return billService.updateBill(bill);
    }

    @DeleteMapping("/{id}")
    public String deleteBill(@PathVariable int id) {
        return billService.deleteBill(id);
    }

    @GetMapping("/{id}")
    public Bill getBillById(@PathVariable int id) {
        return billService.getBillById(id);
    }

    @GetMapping("/")
    public List<Bill> getAllBill() {
        return billService.getAllBill();
    }

}
