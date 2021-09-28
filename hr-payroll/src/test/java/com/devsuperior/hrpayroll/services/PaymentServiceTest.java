package com.devsuperior.hrpayroll.services;

import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.entities.Worker;
import com.devsuperior.hrpayroll.feignclients.WorkerFeignClient;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceTest {

    @Mock
    private WorkerFeignClient workerFeignClient;

    @InjectMocks
    private PaymentService paymentService;

    @Test
    public void getPaymentSuccess() throws Exception {

        Worker workerResponse = new Worker(10l,"Joao",100.0);

        Mockito.when(workerFeignClient.findById(10l))
                .thenReturn(ResponseEntity.ok(workerResponse));

        Payment payment = paymentService.getPayment(10l, 10);

        Mockito.verify(workerFeignClient, Mockito.times(1)).findById(10l);

        Assertions.assertThat(payment.getTotal()).isEqualTo(1000.0);
    }

    @Test
    public void getPaymentWorkerNotFound() {

        Mockito.when(workerFeignClient.findById(10l))
                .thenReturn(ResponseEntity.notFound().build());


        assertThrows(WorkerNotFoundException.class,() -> {
            paymentService.getPayment(10l, 10);
        },"Not found");

    }
}