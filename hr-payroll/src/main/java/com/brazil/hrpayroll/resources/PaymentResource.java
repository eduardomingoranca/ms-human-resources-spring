package com.brazil.hrpayroll.resources;

import com.brazil.hrpayroll.entities.Payment;
import com.brazil.hrpayroll.services.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/payments")
@RequiredArgsConstructor
public class PaymentResource {

    private final PaymentService paymentService;

    @GetMapping(value = "/{workerID}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerID, @PathVariable Integer days) {
        return new ResponseEntity<>(paymentService.getPayment(workerID, days), HttpStatus.OK);
    }

}
