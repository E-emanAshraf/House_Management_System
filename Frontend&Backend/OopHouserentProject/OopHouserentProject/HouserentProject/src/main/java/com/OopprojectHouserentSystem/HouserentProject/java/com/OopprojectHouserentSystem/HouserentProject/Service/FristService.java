package com.OopprojectHouserentSystem.HouserentProject.java.com.OopprojectHouserentSystem.HouserentProject.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.OopprojectHouserentSystem.HouserentProject.java.com.OopprojectHouserentSystem.HouserentProject.Model.Person;
import com.OopprojectHouserentSystem.HouserentProject.java.com.OopprojectHouserentSystem.HouserentProject.Model.Request;
import com.OopprojectHouserentSystem.HouserentProject.java.com.OopprojectHouserentSystem.HouserentProject.Model.Admin;
import com.OopprojectHouserentSystem.HouserentProject.java.com.OopprojectHouserentSystem.HouserentProject.Model.Customer;
import com.OopprojectHouserentSystem.HouserentProject.java.com.OopprojectHouserentSystem.HouserentProject.Model.Deal;
import com.OopprojectHouserentSystem.HouserentProject.java.com.OopprojectHouserentSystem.HouserentProject.Model.Broker;
import com.OopprojectHouserentSystem.HouserentProject.java.com.OopprojectHouserentSystem.HouserentProject.Model.House;

@Service

public class FristService extends ServiceAbstract {
    public static List<Person> listPerson=new ArrayList<Person>();
    public static List<Admin> listAdmin=new ArrayList<Admin>();
    public static List<Customer> listCustomer=new ArrayList<Customer>();
    public static List<Broker> listBroker=new ArrayList<Broker>();
    public static List<Request> listRequests=new ArrayList<Request>();
    public static List<House> listHouses=new ArrayList<House>();
    public static List<Deal> listDeals=new ArrayList<Deal>();
      

    @Override
    public void saveAdmin(Admin obj) {
        listAdmin.add(obj);
 
    }
    @Override
   public void savePerson(Person obj) {
        listPerson.add(obj);  
    }
    @Override
   public void saveCustomer(Person obj) {
        listCustomer.add(obj);  
    }

    @Override
    public void saveBroker(Broker obj) {
        listBroker.add(obj);  
    }
    @Override
    public void saveRequest(Request obj) {
        listRequests.add(obj);  
    }
     @Override
        public void saveHouse(House obj){
            
            listHouses.add(obj);
        }

         @Override
        public void saveDeal(Deal obj){
            listDeals.add(obj);
        }
    
    
        @Override
        public void removec(Customer obj){
            listCustomer.remove(obj);
        }
         @Override
        public void removeb(Broker obj){
            listBroker.remove(obj);
        }



    @Override
        public void DisplayHouse(int ID){
            for ( House house : listHouses) {
                if(house.getID()==ID){
                    System.out.println(house);
                }
                
            }
    
        }

    
}
