package com.OopprojectHouserentSystem.HouserentProject.java.com.OopprojectHouserentSystem.HouserentProject.Model;



import org.springframework.stereotype.Indexed;

//import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Indexed
@Getter
@Setter
@ToString
public class Person {
  
      
   private int  cellphone;
   private  int  ID;
   private String type, firstName, lastName, address, email;
   //@JsonIgnore
   private String password;
   public Person(int  ID, String password,String type,String firstName,String lastName, String address,int cellphone,String email){
    this.ID = ID;
    this.password = password;
    this.type = type;
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.cellphone = cellphone;
    this.email = email;
        }

        public int getID() {
        return ID;
    }

    public String getPassword() {
        return password;
    }

    public String getType() {
        return type;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public int getCellphone() {
        return cellphone;
    }

    public String getEmail() {
        return email;
    }
    

    public void setPassword(String password) {
        this.password = password;
    }

    public void settype(String type) {
        this.type = type;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCellphone(int cellphone) {
        this.cellphone = cellphone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setID(int ID){
        this.ID=ID;
    }

    
}

