package com.brazil.hrpayroll.services;

import com.brazil.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    /**
     * metodo que instancia um payment
     * a partir do parametro workerID terá
     * que chamar lá no microservice de workers
     * qual é o worker correspondente a esse ID
     * */
    public Payment getPayment(long workerID, int days) {
        return new Payment("Bob", 200.0, days);
    }

}
