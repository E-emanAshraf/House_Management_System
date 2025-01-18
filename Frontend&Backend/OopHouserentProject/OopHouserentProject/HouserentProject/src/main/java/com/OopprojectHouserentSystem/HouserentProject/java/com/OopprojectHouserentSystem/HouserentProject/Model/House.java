package com.OopprojectHouserentSystem.HouserentProject.java.com.OopprojectHouserentSystem.HouserentProject.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


 @Getter
 @Setter
 @ToString

public class House {
    private  int nuofreq=0;
    private String House_type;
    private String picture;
    private String location;
    private double area;
    private double depositValue;
    private String availableFor;
    private double totalPrice;
    private boolean priceNegotiable;
    private int ID;
    public static int HouseNumber=0;
        
    public House(String location,String House_type,String picture, double area, double depositValue, String availableFor, double totalPrice, boolean priceNegotiable) {
       HouseNumber++;
       this.ID=HouseNumber;
        this.location = location; 
        this.House_type=House_type;
        this.picture=picture;
        this.area = area;
        this.depositValue = depositValue;
        this.availableFor = availableFor;
        this.totalPrice = totalPrice;
        this.priceNegotiable = priceNegotiable;
        
    }
//Setters
    public void setLocation(String location) {
       this.location = location;
    }

    public void setArea(double area) {
        this.area = area;
    }
   
public void setDepositValue(double depositValue) {
       this.depositValue = depositValue;
    }

    public void setAvailableForRent(String availableFor ) {
        this.availableFor = availableFor;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setisPriceNegotiable(boolean priceNegotiable) {
       this.priceNegotiable = priceNegotiable;
    }

     public void setID(int iD) {
         this.ID = iD;
     }
     public void setHouse_type(String House_type){
        this.House_type=House_type;
     }

     
    //Getters
    public String getLocation() {
        return location;
    }

    public double getArea() {
        return area;
    }
public double getDepositValue() {
        return depositValue;
    }

    public String isAvailableFor() {
        return availableFor;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public boolean isPriceNegotiable() {
        return priceNegotiable;
    }
    public int getID() {
        return ID;
    }
    public int getnuofreq(){
        return nuofreq;
    }
    public void increamentnuofreq(){
        nuofreq++;

    }
    public String getHouse_type(){
        return House_type;
    }
  
}
    

