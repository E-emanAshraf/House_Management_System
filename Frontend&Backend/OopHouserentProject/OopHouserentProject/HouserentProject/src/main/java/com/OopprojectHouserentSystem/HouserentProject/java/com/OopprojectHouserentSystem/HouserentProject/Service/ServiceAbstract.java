package com.OopprojectHouserentSystem.HouserentProject.java.com.OopprojectHouserentSystem.HouserentProject.Service;

import org.springframework.stereotype.Service;

import com.OopprojectHouserentSystem.HouserentProject.java.com.OopprojectHouserentSystem.HouserentProject.Model.Person;
import com.OopprojectHouserentSystem.HouserentProject.java.com.OopprojectHouserentSystem.HouserentProject.Model.Request;
import com.OopprojectHouserentSystem.HouserentProject.java.com.OopprojectHouserentSystem.HouserentProject.Model.Admin;
import com.OopprojectHouserentSystem.HouserentProject.java.com.OopprojectHouserentSystem.HouserentProject.Model.Customer;
import com.OopprojectHouserentSystem.HouserentProject.java.com.OopprojectHouserentSystem.HouserentProject.Model.Deal;
import com.OopprojectHouserentSystem.HouserentProject.java.com.OopprojectHouserentSystem.HouserentProject.Model.House;
import com.OopprojectHouserentSystem.HouserentProject.java.com.OopprojectHouserentSystem.HouserentProject.Model.Broker;

@Service
public abstract class ServiceAbstract{
   public void saveAdmin(Admin Obj ){ };
   public void savePerson(Person Obj ){};
   public  void saveCustomer(Person Obj ){};
   public void saveBroker(Broker Obj ){};
   public void saveHouse(House obj){};
   public void saveRequest(Request Obj ){};
   public  void DisplayHouse(int ID){};
   public void saveDeal(Deal Obj ){};
   public void removec(Customer obj){};
    public void removeb(Broker obj){};

}