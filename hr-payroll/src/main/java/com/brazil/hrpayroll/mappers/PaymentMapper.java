package com.brazil.hrpayroll.mappers;

import com.brazil.hrpayroll.entities.Payment;
import com.brazil.hrpayroll.responses.PaymentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class PaymentMapper {
    /** criando uma instancia */
    public static final PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);

    /**
     * convertendo automaticamente todos os
     * atributos dentro das DTO's
     *
     * @param payment
     */
    public abstract PaymentResponse toPaymentResponse(Payment payment);
}
