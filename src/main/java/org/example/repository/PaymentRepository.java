package org.example.repository;
import org.example.models.Payment;
import org.example.models.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    // Дополнительные методы репозитория, если необходимо
    Payment save(Payment payment);

    List<Payment> findByPaymentPurpose(String paymentPurpose);

    List<Payment> findByPaymentPurposeAndPaymentType(String paymentPurpose, PaymentType paymentType);
}