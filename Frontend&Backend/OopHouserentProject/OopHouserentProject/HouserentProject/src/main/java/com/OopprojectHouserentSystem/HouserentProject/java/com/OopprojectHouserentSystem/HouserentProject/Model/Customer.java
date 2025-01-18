package com.OopprojectHouserentSystem.HouserentProject.java.com.OopprojectHouserentSystem.HouserentProject.Model;
 import java.util.ArrayList;
import java.util.List;

import java.util.Date;

import com.OopprojectHouserentSystem.HouserentProject.java.com.OopprojectHouserentSystem.HouserentProject.Service.FristService;

public class Customer extends Person {
     public static int NumberOfRequests=0;
    FristService ServiceinCustomer=new FristService();
    public Customer(int  ID, String password,String type,String firstName,String lastName, String address,int cellphone,String email)
    {
        super(ID,password,type,firstName,lastName,address,cellphone,email);

    }
   
    public void Edit_Customer_Information(String password,String firstName,String lastName, String address,int cellphone,String email)
    {
       setPassword(password);
       setFirstName(firstName);
       setLastName(lastName);
       setAddress(address);
       setCellphone(cellphone);
       setEmail(email);
                 
    }
    public List<House> AvaliableHouses(){
        return FristService.listHouses;
    }
       
    public List<House> AvailableHouse_Rent()
    {
        List<House> avaHouses=new ArrayList<House>();
       for (House house: FristService.listHouses) {
        if (house.isAvailableFor().equals("Rent")){
            avaHouses.add(house);
        }
        
       }
       return avaHouses;
    }
    public List<House> AvailableHouse_Buy()
    {
        List<House> avaHouses=new ArrayList<House>();
       for (House house: FristService.listHouses) {
        if (house.isAvailableFor().equals("Buy")){
            avaHouses.add(house);
        }
        
       }
       return avaHouses;
    }

    public List<House> MatchHouses(String location, double area,String HouType, double depositValue, String availableFor, double totalPrice, boolean priceNegotiable){
        int val=0;
        List<House> avaHouses=new ArrayList<House>();
        for (House house : FristService.listHouses) {
            val=0;
            if(house.getLocation().equals(location)){
                val++;
            }
             if(house.getHouse_type().equals(HouType)){
                val++;
            }
             if(house.getArea()==area){
                val++;
            }
             if(house.getDepositValue()==depositValue){
                val++;
            }
             if(house.getAvailableFor().equals(availableFor)){
                val++;
            }
             if(house.getTotalPrice()==totalPrice){
                val++;
            }
             if(house.isPriceNegotiable()&&priceNegotiable){
                val++;
            }
            else if(!house.isPriceNegotiable()&&!priceNegotiable){
                val++;
            }
            if(val>=2){
               avaHouses.add(house);
            }
            
        }
        return avaHouses;


    }
  
    public void Request_house(int House_ID,int ISBN,String Reqtype,Date date)
    {
        int x=NumberOfRequests++;
        Request request=new Request(House_ID, x, ISBN, Reqtype, date);
        ServiceinCustomer.saveRequest(request);
        for ( House house : FristService.listHouses) {
            if(house.getID()==House_ID){
                house.increamentnuofreq();
            } 
        }
        
    }
    public void UpdateRequest(int ISBN,String newreq_type)
    { 
        for ( Request req : FristService.listRequests) {
            if(req.getRequestIsbn()==ISBN){
                req.setRequesttype(newreq_type);

            }
        }
        
    }
     
    public void RemoveRequest(int ISBN)
    {
          for ( Request req : FristService.listRequests) {
            if(req.getRequestIsbn()==ISBN){
                FristService.listRequests.remove(req);
            }
        }
        
    }


}


    

