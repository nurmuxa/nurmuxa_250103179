package com.ecommerce;

public class FakeOrderPrevention {
    public boolean isLegit(double amount){
        if(amount<=0){
            System.out.println("Order is not legit");
            return false;
        }
        else {
            System.out.println("Order is legit");
            return true;
        }
    }
}
