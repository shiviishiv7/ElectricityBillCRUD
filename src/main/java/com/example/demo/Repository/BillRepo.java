package com.example.demo.Repository;

import com.example.demo.Entity.Bill;

import java.util.List;

public interface BillRepo {
    Bill addBill(Bill bill);
    Bill updateBill(Bill bill);
    String deleteBill(int id);
    Bill getBillById(int id);
    List<Bill> getAllBill();
    boolean billExistById(int id);
}
