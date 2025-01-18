package com.OopprojectHouserentSystem.HouserentProject.java.com.OopprojectHouserentSystem.HouserentProject.Model;
import java.util.Date;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

import com.OopprojectHouserentSystem.HouserentProject.java.com.OopprojectHouserentSystem.HouserentProject.Service.FristService;

public class Admin extends Person{
  FristService ServiceinAdmin =new FristService();
   //String AdminPassword="Salma@Ra7eeq3";
    public Admin(int  ID, String password,String type,String firstName,String lastName, String address,int cellphone,String email)
    {
        super(ID,password,type,firstName,lastName,address,cellphone,email);

    }

    public void addNewCustomer(int  ID, String password,String type,String firstName,String lastName, String address,int cellphone,String email){
        Customer Newcustomer=new Customer(ID,password,type,firstName,lastName,address,cellphone,email);
        ServiceinAdmin.savePerson(Newcustomer);
        ServiceinAdmin.saveCustomer(Newcustomer);
    }
    public void addNewBroker(int  ID, String password,String type,String firstName,String lastName, String address,int cellphone,String email){
        Broker Newbroker=new Broker(ID,password,type,firstName,lastName,address,cellphone,email);
        ServiceinAdmin.savePerson(Newbroker);
        ServiceinAdmin.saveBroker(Newbroker);
    }
    
   
  public void removeCustomer(int userID) {
    Iterator<Customer> iterator = FristService.listCustomer.iterator();
    while (iterator.hasNext()) {
        Customer customer = iterator.next();
        if (customer.getID() == userID) {
            iterator.remove(); // Use iterator to remove the element safely
            FristService.listPerson.remove(customer);
            // You may want to break the loop if you only want to remove the first matching customer
            // break;
        }
    }
}
public void removeBroker(int userID) {
    Iterator<Broker> iterator = FristService.listBroker.iterator();
    while (iterator.hasNext()) {
        Broker broker = iterator.next();
        if (broker.getID() == userID) {
            iterator.remove(); // Use iterator to remove the element safely
            FristService.listPerson.remove(broker);
            // You may want to break the loop if you only want to remove the first matching customer
            // break;
        }
    }
}

    
   public List<Person> viewall(String type){
    List<Person> needlist=new ArrayList<Person>();
    if(type.equals("Customer")){
      for (Person person : FristService.listPerson) {
        if(person.getType().equals("Customer")){
        needlist.add(person);
       }
      }
    }
    else if(type.equals("Broker"))
    {
      for (Person person : FristService.listPerson) {
        if(person.getType().equals("Broker")){
        needlist.add(person);
       }
      }
    }
    else if(type.equals("Admin")){
     for (Person person : FristService.listPerson) {
        if(person.getType().equals("Admin")){
        needlist.add(person);
       }
      }
    }
    return needlist;
   }
    


  
   public List<Request> viewrequests(Date date){
    List<Request> reqlist =new ArrayList<Request>();
    for ( Request request : FristService.listRequests) {
      if(request.getDate().equals(date)){
       reqlist.add(request);
      }
      
    }
    return reqlist;

    }
    public void Authorize_new_user(int user_id,String old_Type){
        if(old_Type=="Broker"){
        for (Broker broker : FristService.listBroker) {
            if(user_id==broker.getID()){
                settype("Admin");
            }
         }
        }
        if(old_Type=="Customer"){
         for (Customer customer: FristService.listCustomer) {
            if(user_id==customer.getID()){
                settype("Admin");
            }
            
         }
       }
    }
   
}


