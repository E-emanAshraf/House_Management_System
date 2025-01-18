package com.OopprojectHouserentSystem.HouserentProject.java.com.OopprojectHouserentSystem.HouserentProject.Service;

import com.OopprojectHouserentSystem.HouserentProject.java.com.OopprojectHouserentSystem.HouserentProject.Model.Person;

import com.OopprojectHouserentSystem.HouserentProject.java.com.OopprojectHouserentSystem.HouserentProject.Model.Customer;
import com.OopprojectHouserentSystem.HouserentProject.java.com.OopprojectHouserentSystem.HouserentProject.Model.Admin;
import com.OopprojectHouserentSystem.HouserentProject.java.com.OopprojectHouserentSystem.HouserentProject.Model.Broker;
//import java.util.Date;


public class Servicebta3elinterface implements Serviceinterface {
    FristService Service_in_interface=new FristService();

      @Override
    public boolean ifpasswordalreadyfound(String password){
        boolean x=false;
        for( Person person: FristService.listPerson){
            if(person.getPassword().equals(password)){
                x=true;
                break;  
            }
        }
        return x;

    }
      @Override
    public boolean ifissecure(String password){
        if (password.length() < 8) {
            return false;
        } 
        else {
    
            for (int p = 0; p < password.length(); p++) {
                if (Character.isUpperCase(password.charAt(p))) {
                }
            }
            for (int q = 0; q < password.length(); q++) {
                if (Character.isLowerCase(password.charAt(q))) {
                }
            }
            for (int r = 0; r < password.length(); r++) {
                if (Character.isDigit(password.charAt(r))) {
                }
            }
            for (int s=0;s<password.length();s++) {
                if(password.charAt(s)=='@'||password.charAt(s)=='#'||password.charAt(s)=='!'||password.charAt(s)=='$'||password.charAt(s)=='%'||password.charAt(s)=='^'||password.charAt(s)=='&'||password.charAt(s)=='*'||password.charAt(s)=='?'){
                } 
                }
                return true;
            }

    }
  

    
    @Override
    public boolean ifUserRegister(int ID){
        boolean x=false;
        for( Person person: FristService.listPerson){
            if(person.getID()==(ID)){
                x=true;
                break;  
            }
        }
        return x;

    }

     @Override
    public boolean ifisAdmin(String password){
        boolean x=false;
        for( Admin person: FristService.listAdmin){
            if(person.getPassword().equals(password)){
                x=true;
                break;  
            }
        }
        return x;

    }

      @Override
    public boolean ifisCustomer(int ID){
        boolean x=false;
        for( Customer person: FristService.listCustomer){
            if(person.getID()==ID){
                x=true;
                break;  
            }
        }
        return x;

    }

      @Override
    public boolean ifisBroker(int ID){
        boolean x=false;
        for( Broker person: FristService.listBroker){
            if(person.getID()==ID){
                x=true;
                break;  
            }
        }
        return x;

    }
    @Override
    public boolean ifistheuser(int ID,String password){
        boolean x=false;
        for( Person person: FristService.listPerson){
            if(person.getID()==ID&&person.getPassword().equals(password)){
                x=true;
                break;  
            }
        }
        return x;

    }


     @Override
    public Person FindPerson(int ID){
        Person x=new Person(0," "," "," "," "," ",0," ");
        for( Person person: FristService.listPerson){
            if(person.getID()==ID){
                x=person;
                break; 
            }
        }
        return x;
        

    }
    @Override

    public String findpassword(String email){
        String x=null;
         for( Person person: FristService.listPerson){
            if(person.getEmail().equals(email)){
                x=person.getPassword();
                break;  
            }
        }
        return x;
    }
    //public boolean isvalidDate(Date d){
     //  if(d.getDay()>31||d.getDay()>12||d.getYear()>2023){
      //  return false;
      // }
      // else{
      //  return true;
      // }
    
   // }
   
   
    
    
}
    

