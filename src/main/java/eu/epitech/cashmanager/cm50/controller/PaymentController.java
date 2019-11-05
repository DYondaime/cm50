package eu.epitech.cashmanager.cm50.controller;

import java.util.*;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import eu.epitech.cashmanager.cm50.models.Payment;
import eu.epitech.cashmanager.cm50.repository.PaymentRepository;
import eu.epitech.cashmanager.cm50.exception.ResourceNotFoundException;


@RestController
@RequestMapping("/api/v1")
public class PaymentController {
    @Autowired
    private PaymentRepository paymentRepository;

    @GetMapping("/payments")
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @GetMapping("/payments/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable(value = "id") Long paymentId)
            throws ResourceNotFoundException {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new ResourceNotFoundException("Payment with the id :: " + paymentId + " not found!!"));
        return ResponseEntity.ok().body(payment);
    }

    @PostMapping("/payments")
    public Payment createPayment(@Valid @RequestBody Payment payment) {
        return paymentRepository.save(payment);
    }

    @PutMapping("/payments/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable(value = "id") Long paymentId,
                                                 @Valid @RequestBody Payment paymentDetails) throws ResourceNotFoundException {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new ResourceNotFoundException("Product with the id :: " + paymentId + " not found!!"));

        payment.setType(paymentDetails.getType());
        payment.setTotal(paymentDetails.getTotal());
        payment.setStatus(paymentDetails.getStatus());
        payment.setDate(paymentDetails.getDate());
        final Payment updatedPayment = paymentRepository.save(payment);
        return ResponseEntity.ok(updatedPayment);
    }

    @DeleteMapping("/payments/{id}")
    public Map<String, Boolean> deletePayment(@PathVariable(value = "id") Long paymentId)
            throws ResourceNotFoundException {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new ResourceNotFoundException("Payment with the id :: " + paymentId + " not found!!"));

        paymentRepository.delete(payment);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
