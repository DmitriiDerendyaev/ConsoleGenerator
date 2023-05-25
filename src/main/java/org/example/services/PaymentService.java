package org.example.services;

import org.example.models.Payment;
import org.example.models.PaymentType;
import org.example.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public void addPayment(Payment payment) {
        if (!paymentRepository.existsById(payment.getCheckId())) {
            paymentRepository.save(payment);
        } else {
            System.out.println("Такой объект уже существует! ID: " + payment.getCheckId());
        }
    }

    public List<Payment> findPaymentsByPurpose(String paymentPurpose) {
        return paymentRepository.findByPaymentPurpose(paymentPurpose);
    }

    public List<Payment> findPaymentsByPurposeAndType(String paymentPurpose, PaymentType paymentType) {
        return paymentRepository.findByPaymentPurposeAndPaymentType(paymentPurpose, paymentType);
    }
}
