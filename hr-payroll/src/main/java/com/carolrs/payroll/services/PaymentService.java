package com.carolrs.payroll.services;

import com.carolrs.payroll.feignclients.WorkerFeignClient;
import com.carolrs.payroll.entities.Payment;
import com.carolrs.payroll.entities.Worker;
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
