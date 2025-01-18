package com.OopprojectHouserentSystem.HouserentProject.java.com.OopprojectHouserentSystem.HouserentProject.Model;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.OopprojectHouserentSystem.HouserentProject.java.com.OopprojectHouserentSystem.HouserentProject.Service.FristService;

public class Broker extends Person {
    FristService ServiceinBroker=new FristService();
    public Broker(int  ID, String password,String type,String firstName,String lastName, String address,int cellphone,String email)
    {
        super(ID,password,type,firstName,lastName,address,cellphone,email);

    }


public void addhouse(String location,String House_type,String picture, double area, double depositValue, String availableFor, double totalPrice, boolean priceNegotiable){
  House house=new House(location, House_type,picture, area, depositValue, availableFor, totalPrice, priceNegotiable);
  ServiceinBroker.saveHouse(house);

}
public void removehouse(int houseID) {
    Iterator<House> iterator = FristService.listHouses.iterator();
    while (iterator.hasNext()) {
        House house = iterator.next();
        if (house.getID() == houseID) {
            iterator.remove(); // Use iterator to remove the element safely
            // Additional logic if needed
            break; // Exit the loop since the house is found and removed
        }
    }
}


public void addhouselocation(int House_ID,String location){
    for (House h: FristService.listHouses) {
        if(h.getID()==House_ID){
              h.setLocation(location);
        }
    }
}

public void addhousetype(int House_ID,String housetype){
     for (House h: FristService.listHouses) {
        if(h.getID()==House_ID){
              h.setHouse_type(housetype);
        }
    }
 }


public void opendeal(int ID, Date DealDate,String customerLSBN,String brokerLSBN,int deposit,String type,String status){
  Deal deal=new Deal(ID, DealDate, customerLSBN, brokerLSBN, deposit, type, status);
  ServiceinBroker.saveDeal(deal);
}



public List<Deal> donedeals(String brokerLSBN){
    List<Deal> donedeDeals=new ArrayList<Deal>();
    for (Deal d : FristService.listDeals) {
        if((d.getcustomerLSBN()).equals(brokerLSBN)){
           donedeDeals.add(d);
        }
    }
    return donedeDeals;
}
public List<House> searchbyarea(double area){
    List<House> houses=new ArrayList<House>();
    for (House h : FristService.listHouses) {
        if(h.getArea()==area){
           houses.add(h);
        }
    }
    return houses;
}
}
    
 
