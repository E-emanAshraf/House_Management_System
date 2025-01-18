package com.OopprojectHouserentSystem.HouserentProject.java.com.OopprojectHouserentSystem.HouserentProject.Service;

//import java.util.Date;

import org.springframework.stereotype.Service;

import com.OopprojectHouserentSystem.HouserentProject.java.com.OopprojectHouserentSystem.HouserentProject.Model.Person;

@Service


public interface Serviceinterface {

    public boolean ifpasswordalreadyfound(String password);
    public boolean ifUserRegister(int ID);
    public boolean ifissecure(String password);
    public boolean ifisAdmin(String password);
    public boolean ifisCustomer(int ID);
    public boolean ifisBroker(int ID);
    public boolean ifistheuser(int ID,String password);
    public Person FindPerson(int ID);
    public String findpassword(String  email);
    //public boolean isvalidDate(Date date);
   

}


