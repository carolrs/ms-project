package com.carolrs.payroll.services;

public class WorkerNotFoundException extends RuntimeException{

    public WorkerNotFoundException(String message) {
        super(message);
    }
}
