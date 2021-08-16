package com.brazil.hrpayroll.services;

import com.brazil.hrpayroll.entities.Payment;
import com.brazil.hrpayroll.mappers.PaymentMapper;
import com.brazil.hrpayroll.responses.PaymentResponse;
import com.brazil.hrpayroll.responses.WorkerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PaymentService {

    /**
     * recebendo o host da outra aplicação. */
    @Value("${hr-worker.host}")
    private String workerHost;

    private final RestTemplate restTemplate;

    /**
     * metodo que instancia um payment
     * a partir do parametro workerID terá
     * que chamar lá no microservice de workers
     * qual é o worker correspondente a esse ID
     * */
    public PaymentResponse getPayment(long workerID, int days) {
        /** fazendo uma chamada no webservice de workers */
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", Objects.toString(workerID));
        WorkerResponse workerResponse = restTemplate.getForObject(workerHost.concat("/workers/{id}"), WorkerResponse.class, uriVariables);
        Payment payment = new Payment(workerResponse.getName(), workerResponse.getDailyIncome(), days);
        return PaymentMapper.INSTANCE.toPaymentResponse(payment);
    }

}
