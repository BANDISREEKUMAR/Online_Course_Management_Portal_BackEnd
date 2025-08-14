package com.portal.service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;

@Service
public class PaymentService {

    private RazorpayClient client;

    public PaymentService() throws Exception {
        this.client = new RazorpayClient("My_Key", "My_Secret");
    }

    public String createOrder(int amount) throws Exception {
        JSONObject options = new JSONObject();
        options.put("amount", amount * 100);
        options.put("currency", "INR");
        options.put("receipt", "txn_123456");
        options.put("payment_capture", true);

        Order order = client.orders.create(options);
        return order.toString();
    }
}
