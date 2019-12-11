package org.tyaa.springresthibernatepayment.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tyaa.springresthibernatepayment.dao.PaymentHibernateDAO;
import org.tyaa.springresthibernatepayment.entity.Payment;
import org.tyaa.springresthibernatepayment.model.PaymentModel;
import org.tyaa.springresthibernatepayment.model.PaymentResponse;

@Service
@Transactional
public class PaymentService {

	@Autowired
	private PaymentHibernateDAO dao;

	public PaymentResponse pay(Payment payment) {
		payment.setPaymentDate(new Date());
		String message = dao.payNow(payment);
		PaymentResponse response = new PaymentResponse();
		response.setStatus("success");
		response.setMessage(message);
		response.setTxDate(new SimpleDateFormat("dd/mm/yyyy HH:mm:ss a").format(new Date()));
		return response;
	}

	public PaymentResponse getTx(String vendor) {
		PaymentResponse response = new PaymentResponse();
		List<Payment> payments = dao.getTransactionInfo(vendor);
                List<PaymentModel> paymentModels = payments.stream().map((p) -> {
                    return new PaymentModel(
                            p.getTransactionId()
                            , p.getVendor()
                            , new SimpleDateFormat("dd/mm/yyyy HH:mm:ss a").format(p.getPaymentDate())
                            , p.getAmount());
                }).collect(Collectors.toList());
		response.setStatus("succes");
		response.setPayments(paymentModels);
		return response;
}
}
