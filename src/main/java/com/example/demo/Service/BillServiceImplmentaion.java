package com.example.demo.Service;

import com.example.demo.Entity.Bill;
import com.example.demo.Repository.BillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImplmentaion implements BillService {
    @Autowired
    private BillRepo billRepo;
    @Override
    public Bill addBill(Bill bill) {
        return billRepo.addBill(bill);
    }

    @Override
    public Bill updateBill(Bill bill) {
        return billRepo.updateBill(bill);
    }

    @Override
    public String deleteBill(int id) {

        return billRepo.deleteBill(id);
    }

    @Override
    public Bill getBillById(int id) {
        return billRepo.getBillById(id);
    }

    @Override
    public List<Bill> getAllBill() {
        return billRepo.getAllBill();
    }

    @Override
    public boolean billExistById(int id) {
        return billRepo.billExistById(id);
    }
}
