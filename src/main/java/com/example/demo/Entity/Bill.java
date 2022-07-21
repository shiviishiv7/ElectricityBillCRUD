package com.example.demo.Entity;

public class Bill {
    private int id;
    private String bill_date;
    private String paid_date;
    private int unit;
    private int amount;

    public int getId() {
        return id;
    }

    public Bill() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBill_date() {
        return bill_date;
    }

    public void setBill_date(String bill_date) {
        this.bill_date = bill_date;
    }

    public String getPaid_date() {
        return paid_date;
    }

    public void setPaid_date(String paid_date) {
        this.paid_date = paid_date;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Bill(int id, String bill_date, String paid_date, int unit, int amount) {
        this.id = id;
        this.bill_date = bill_date;
        this.paid_date = paid_date;
        this.unit = unit;
        this.amount = amount;
    }
}
