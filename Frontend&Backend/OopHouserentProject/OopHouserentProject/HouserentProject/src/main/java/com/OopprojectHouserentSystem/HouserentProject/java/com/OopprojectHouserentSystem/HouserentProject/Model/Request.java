package com.OopprojectHouserentSystem.HouserentProject.java.com.OopprojectHouserentSystem.HouserentProject.Model;
import java.util.Date;


public class Request{
    
     
       private Date date=new Date();
       private  int RequestID;
       private int ISBN;
       private String RequestType;
       private int HouseID;
    
        public Request(int HouseID,int RequestID,int ISBN , String RequestType,Date date)
        {
            this.HouseID=HouseID;
            this.RequestID=RequestID;
            this.RequestType=RequestType;
            this.ISBN=ISBN;
            this.date=date;
        }
        //Setters
        public void setCustomerISBN(int isbn)
        {
            this.ISBN=isbn;
        }
        public void setHouseID(int HouseID){
            this.HouseID=HouseID;
        }
        public void setDate(Date date)
        {
            this.date=date;
        }
        public void setRequesttype(String reqtype)
        {
            this.RequestType=reqtype;
        }
        // Getters
        public int getRequestIsbn()
        {
            return ISBN;
        }
        public int getHouseID(){
            return HouseID;
        }
          public int getRequestID()
        {
            return RequestID;
        }
          public String getRequesttype()
        {
            return RequestType;
        }
          public Date getDate()
        {
            return date;
        } 
        public void setID(int ID){
            this.RequestID=ID;

        }    
    
}
