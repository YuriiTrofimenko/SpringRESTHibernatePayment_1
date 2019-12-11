/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.springresthibernatepayment.model;

/**
 *
 * @author student
 */
public class PaymentModel {
    public int id;
    public String transactionId;
    public String vendor;
    public String paymentDateString;
    public double amount;

    public PaymentModel(String transactionId, String vendor, String paymentDateString, double amount) {
        this.transactionId = transactionId;
        this.vendor = vendor;
        this.paymentDateString = paymentDateString;
        this.amount = amount;
    }
    
    
}
