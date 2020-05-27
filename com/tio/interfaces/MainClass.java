package com.tio.interfaces;

import com.tio.interfaces.domain.CarRental;
import com.tio.interfaces.domain.Vehicle;
import com.tio.interfaces.service.BrazilTaxService;
import com.tio.interfaces.service.RentailService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
        System.out.println("Enter rental data");
        System.out.println("Car model:");
        String model =  sc.nextLine();
        System.out.println("Pickup (dd/MM/yyyy hh:mm):");
        String pickup =  sc.nextLine();
        Date start = sdf.parse(pickup);
        System.out.println("Return (dd/MM/yyyy hh:mm):");
        String returndate =  sc.nextLine();
        Date finishDate = sdf.parse(returndate);

        System.out.println("Enter price per hour:");
        Double priceHour =  Double.parseDouble(sc.nextLine());
        System.out.println("Enter price per day:");
        Double priceDay = Double.parseDouble(sc.nextLine());

        RentailService service = new RentailService(priceDay,priceHour,new BrazilTaxService());
        service.processInvoice(new CarRental(start,finishDate, new Vehicle(model)));


         System.out.println("INVOICE:");
         System.out.println("Basic payment:"+ service.getBasicPayment());
         System.out.println("Tax:"+ service.getTax());
         System.out.println("Total payment:" );


    }
}
