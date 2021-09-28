package com.devsuperior.hrpayroll.services;

import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.entities.Worker;
import com.devsuperior.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(long workerId,int days){
        ResponseEntity<Worker> entity = workerFeignClient.findById(workerId);

        if (entity.getStatusCode().is2xxSuccessful()) {
            Worker worker = entity.getBody();
            return new Payment(worker.getName(),worker.getDailyIncome(),days);
        }

        throw new WorkerNotFoundException(entity.getStatusCode().getReasonPhrase());
    }
}
