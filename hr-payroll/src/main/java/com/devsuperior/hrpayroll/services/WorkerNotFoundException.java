package com.devsuperior.hrpayroll.services;

public class WorkerNotFoundException extends RuntimeException{

    public WorkerNotFoundException(String message) {
        super(message);
    }
}
