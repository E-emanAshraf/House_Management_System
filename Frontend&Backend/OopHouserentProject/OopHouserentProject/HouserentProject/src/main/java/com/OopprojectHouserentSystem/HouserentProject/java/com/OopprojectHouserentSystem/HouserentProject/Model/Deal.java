package com.OopprojectHouserentSystem.HouserentProject.java.com.OopprojectHouserentSystem.HouserentProject.Model;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Deal {
        private int ID,deposit;
        Date DealDate;
        private String customerLSBN,brokerLSBN ,type ,status;
         public Deal(int ID,Date DealDate,String customerLSBN,String brokerLSBN,int deposit,String type,String status){
         this.ID=ID;
         this.DealDate=DealDate;
         this .customerLSBN =customerLSBN;
         this.brokerLSBN = brokerLSBN;
         this.deposit=deposit;
         this.type=type;
         this.status=status;
         }
        public int getID(){
    
            return ID;
        }
         public Date getDealDate(){
            return DealDate;
    
        }
           public String getcustomerLSBN(){
            return  customerLSBN ;
           }
         public String getbrokerLSBN(){
            return  brokerLSBN ;
           }
          public int getdeposit(){
    
            return deposit;
        }
           public String gettype(){
            return  type ;
           }
            public String getstatus(){
            return  status ;
           }
    
        public void setID(int ID){
        this.ID=ID;
    
        }
        public void setDealDate(Date DealDate){
        this.DealDate=DealDate;
    
        }
        public void setcustomerLSBN(String customerLSBN){
        this. customerLSBN= customerLSBN;
    
        }
        public void setbrokerLSBN(String brokerLSBN){
        this.brokerLSBN= brokerLSBN;
    
        }
        public void setdeposit(int deposit){
        this.deposit=deposit;
    
        }
          public void settype(String type){
        this.type= type;
    
        }
            public void setstatus(String status){
        this. status= status;
    
        }
    
    
}
