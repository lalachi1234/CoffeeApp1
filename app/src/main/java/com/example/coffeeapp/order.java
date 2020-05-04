package com.example.coffeeapp;

public class order {
    private int _id;
    private String _custName;
    private int _saleAmount;

    public order() {
        _id = 0;
        _custName =null;
        _saleAmount = 0;

    }

    public order(int _id, String _custName, int _saleAmount) {
        this._id = _id;
        this._custName = _custName;
        this._saleAmount = _saleAmount;
    }

    public order(int parseInt) {
    }


    public int get_id() {
        return _id;
    }

    public int get_saleAmount() {
        return _saleAmount;
    }

    public String get_custName() {
        return _custName;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_custName(String _custName) {
        this._custName = _custName;
    }

    public void set_saleAmount(int _saleAmount) {
        this._saleAmount = _saleAmount;
    }


}
