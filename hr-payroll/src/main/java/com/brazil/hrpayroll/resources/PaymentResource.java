package com.brazil.hrpayroll.resources;

import com.brazil.hrpayroll.responses.PaymentResponse;
import com.brazil.hrpayroll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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

    /**
     * chamando o metodo alternativo para a reposta com Hystrix
     * caso aconteça algum problema
     * */
    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    @GetMapping(value = "/{workerID}/days/{days}")
    public ResponseEntity<PaymentResponse> getPayment(@PathVariable Long workerID, @PathVariable Integer days) {
        return new ResponseEntity<>(paymentService.getPayment(workerID, days), HttpStatus.OK);
    }

    /**
     * metodo alternativo */
    public ResponseEntity<PaymentResponse> getPaymentAlternative(Long workerID, Integer days) {
        return new ResponseEntity<>(paymentService.getPaymentAlternative(days), HttpStatus.OK);
    }


}
