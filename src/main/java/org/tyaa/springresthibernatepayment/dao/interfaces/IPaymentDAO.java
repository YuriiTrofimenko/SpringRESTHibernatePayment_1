package org.tyaa.springresthibernatepayment.dao.interfaces;

import java.util.List;

import org.tyaa.springresthibernatepayment.entity.Payment;

public interface IPaymentDAO {

	public String payNow(Payment payment);
	
	public List<Payment> getTransactionInfo(String vendor);
}
