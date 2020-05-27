package com.tio.interfaces.service;

import com.tio.interfaces.domain.CarRental;

import java.util.Date;

public class RentailService {

    private Double pricePerDay;
    private Double pricePerHour;
    private Double basicPayment;
    private BrazilTaxService taxService;

    public void processeInvoice(){

    }

    public void processInvoice(CarRental carRental){
        //gera nota de pagamento
        long start = carRental.getStart().getTime();
        long finish = carRental.getFinish().getTime();

        Double dif = (double)finish-start/1000/60/60;
        if(dif <= 12.0){
             basicPayment = Math.ceil(dif) * pricePerHour;
        }else{
             basicPayment = Math.ceil(dif/24) * pricePerDay;
        }
        double tax = taxService.tax(basicPayment);

    }

}
