package com.brazil.hrpayroll.services;

import com.brazil.hrpayroll.entities.Payment;
import com.brazil.hrpayroll.feignclients.WorkerFeignClient;
import com.brazil.hrpayroll.mappers.PaymentMapper;
import com.brazil.hrpayroll.responses.PaymentResponse;
import com.brazil.hrpayroll.responses.WorkerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final WorkerFeignClient workerFeignClient;

    /**
     * metodo que instancia um payment
     * a partir do parametro workerID terá
     * que chamar lá no microservice de workers
     * qual é o worker correspondente a esse ID
     * */
    public PaymentResponse getPayment(long workerID, int days) {
        /** fazendo uma chamada no webservice de workers */
        WorkerResponse workerResponse = workerFeignClient.findById(workerID).getBody();
        Payment payment = new Payment(workerResponse.getName(), workerResponse.getDailyIncome(), days);
        return PaymentMapper.INSTANCE.toPaymentResponse(payment);
    }

}
