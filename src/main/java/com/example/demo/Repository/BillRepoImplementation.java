package com.example.demo.Repository;

import com.example.demo.Entity.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BillRepoImplementation implements BillRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public Bill addBill(Bill bill) {
        String q = "insert into electricity (bill_date,paid_date,unit,amount) value(?,?,?,?)";
        int update = jdbcTemplate.update(q, new Object[]{bill.getBill_date(), bill.getPaid_date(), bill.getUnit(), bill.getAmount()});
        if(update==1)return bill;
        return null;
    }

    @Override
    public Bill updateBill(Bill bill) {
        String q = "update electricity set bill_date=?,paid_date=?,unit=?,amount=? where id =?";
        int update = jdbcTemplate.update(q,new Object[]{bill.getBill_date(),bill.getPaid_date(),
        bill.getUnit(),bill.getAmount(),bill.getId()});
        
        if(update==1)return bill;
        return null;
    }

    @Override
    public String deleteBill(int id) {
        String q = "delete from electricity where id=?";
        int update = jdbcTemplate.update(q, new Object[]{id});
        if(update==1)return "DELETED";
        return "NOT DELETED";
    }

    @Override
    public Bill getBillById(int id) {
        if(!billExistById(id))return null;
        String q = "SELECT * from electricity where id =?";
        Bill bill = jdbcTemplate.queryForObject(q, new RowMapper<Bill
                >() {
            @Override
            public Bill mapRow(ResultSet rs, int rowNum) throws SQLException {
                Bill bill = new Bill();
                bill.setId(rs.getInt("id"));
                bill.setBill_date(rs.getString("bill_date"));
                bill.setPaid_date(rs.getString("paid_date"));
                bill.setAmount(Integer.parseInt(rs.getString("amount")));
                bill.setUnit(Integer.parseInt(rs.getString("unit")));
                return bill;
            }
        }, id);
        return bill;
    }

    @Override
    public List<Bill> getAllBill() {
        String q = "select * from electricity";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(q);
        var list = new ArrayList<Bill>();
        for(Map<String,Object> row :rows){

            Bill bill = new Bill();
            bill.setId(Integer.parseInt(row.get("id").toString()));
            bill.setBill_date(row.get("bill_date").toString());
            bill.setPaid_date(row.get("paid_date").toString());
            bill.setAmount(Integer.parseInt(row.get("amount").toString()));
            bill.setUnit(Integer.parseInt(row.get("unit").toString()));
            list.add(bill);
        }
        return list;
    }

    @Override
    public boolean billExistById(int id) {
        String q = "select count(id) from electricity where id = ?";
        Integer integer = jdbcTemplate.queryForObject(q, Integer.class, id);
        if(integer>0)return true;
        return false;
    }
}
