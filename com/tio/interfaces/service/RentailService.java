package com.tio.interfaces.service;

import com.tio.interfaces.domain.CarRental;

import java.util.Date;

public class RentailService {

    private Double pricePerDay;
    private Double pricePerHour;
    private Double basicPayment;
    private TaxService taxService;
    private Double tax;

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public RentailService(Double pricePerDay, Double pricePerHour, TaxService taxService) {
        this.pricePerDay = pricePerDay;
        this.pricePerHour = pricePerHour;
        this.taxService = taxService;
    }

    public double getBasicPayment(){
        return this.basicPayment;
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

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public Double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(Double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public TaxService getTaxService() {
        return taxService;
    }

    public void setTaxService(TaxService taxService) {
        this.taxService = taxService;
    }
}
