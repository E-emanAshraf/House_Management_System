package com.OopprojectHouserentSystem.HouserentProject.java.com.OopprojectHouserentSystem.HouserentProject.Controller;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.validation.annotation.Validated;

import com.OopprojectHouserentSystem.HouserentProject.java.com.OopprojectHouserentSystem.HouserentProject.Service.FristService;
import com.OopprojectHouserentSystem.HouserentProject.java.com.OopprojectHouserentSystem.HouserentProject.Service.Servicebta3elinterface;

import jakarta.validation.Valid;

import com.OopprojectHouserentSystem.HouserentProject.java.com.OopprojectHouserentSystem.HouserentProject.Model.Person;
import com.OopprojectHouserentSystem.HouserentProject.java.com.OopprojectHouserentSystem.HouserentProject.Model.Request;
import com.OopprojectHouserentSystem.HouserentProject.java.com.OopprojectHouserentSystem.HouserentProject.Model.Admin;
import com.OopprojectHouserentSystem.HouserentProject.java.com.OopprojectHouserentSystem.HouserentProject.Model.Broker;
import com.OopprojectHouserentSystem.HouserentProject.java.com.OopprojectHouserentSystem.HouserentProject.Model.Customer;
import com.OopprojectHouserentSystem.HouserentProject.java.com.OopprojectHouserentSystem.HouserentProject.Model.Deal;
import com.OopprojectHouserentSystem.HouserentProject.java.com.OopprojectHouserentSystem.HouserentProject.Model.House;

//@RestController
@Controller
@RequestMapping("/")
public class FristController {
    
    FristService Serviceincontroller=new FristService();
    Servicebta3elinterface interfaceinController=new Servicebta3elinterface();
    
    @GetMapping("/")
    public String showRegistrationForm() {
        return "index";
    }

   

    
    //------------------------Register------------------------------------------------------------------------------------------------------------------
   @GetMapping("/Register")
   public String Register(){
      return "Register";
   }

   @PostMapping("/Register")
    public String Register(@Validated @ModelAttribute Person Clint){
        if(interfaceinController.ifissecure(Clint.getPassword())){
             if(!interfaceinController.ifUserRegister(Clint.getID())){
                if(!interfaceinController.ifpasswordalreadyfound(Clint.getPassword())){
                      if(Clint.getType().equals("Customer")){
                           Customer customer=new Customer(Clint.getID(),Clint.getPassword(),Clint.getType(),Clint.getFirstName(),Clint.getLastName(),Clint.getAddress(),Clint.getCellphone(),Clint.getEmail());
                           Serviceincontroller.saveCustomer(customer);
                           Serviceincontroller.savePerson(customer);
                             }
                      else{
                          Broker broker=new Broker(Clint.getID(),Clint.getPassword(),Clint.getType(),Clint.getFirstName(),Clint.getLastName(),Clint.getAddress(),Clint.getCellphone(),Clint.getEmail());
                          Serviceincontroller.saveBroker(broker);
                          Serviceincontroller.savePerson(broker);
                            }
                            return"redirect:/Login";
                           
                        }
                      else{
        
                           return"passworderror";
                           }
                }
               else{
                return "registererror";
                                 }
        }

       else{
        
        return"secureerror";
       }
   
}
       




   


    //---------------------------------login--------------------------------------------------------------------------------------------
    @GetMapping("/Login")
    public String LoginGet(){
        return("./Login"); 
    }

    

    @PostMapping("/Login")
    public String LoginPost(@Valid @RequestParam("ID") int ID, @RequestParam("password") String password){
       if( interfaceinController.ifUserRegister( ID)){
        if(interfaceinController.ifistheuser(ID,password)){
       Person user=interfaceinController.FindPerson(ID);

      if(user.getType().equals("Customer")){
          return"redirect:/Customer";
            }
        
      else  {
            return"redirect:/Broker";
                }
         
        }
        else{
        return"Login";

        }
    }
       else{
        return"Register";
       }
    }

    @GetMapping("/LoginForAdmin")
    public String Loginforadmin(){
        return"AdminLogin"; 
    }

    

    @PostMapping("/LoginForAdmin")
    public String Loginforadminpost(@Valid @RequestParam("username") String username, @RequestParam("password") String password){
        if(username.equals("admin")&& password.equals("admin")){
           return "redirect:/Admin";
        }
      else{
        return "error";
      }
    }



    @GetMapping("/forgetthepassword")
    public String forgetthepassword(){
        return"forgetthepassword";
    }

  Person person1=new Person(0, null, null, null, null, null, 0, null);
    @PostMapping("/forgetthepassword")
    public Person forgetthepassword(@Valid @RequestBody int ID,String email){
       person1=interfaceinController.FindPerson(ID);
        return person1;

    }

    @GetMapping("/Logout")
    public String logout(){
        return"Logout";
    }


    @PostMapping("/Logout")
    public String logout(@Valid @RequestParam("ID") int ID, @RequestParam("password") String password){
        if(interfaceinController.ifUserRegister(ID)){
            if(interfaceinController.ifistheuser(ID,password)){
                return"index";
            }
            else{
                return"error";
            }
        }
        else{
            return"error";
        }

    }




//--------------------------------------------Admin page--------------------------------------------------------------

@GetMapping("/Admin")
public String AdminMethodsGet(){
    return"Admin";
}




//----------------------------------------addCustomer-------------------------------------------------

@GetMapping("/addCustomer")
public String addCustomerforadmin(){
    return "addCustomer";
}


@PostMapping("/addCustomer")
public String addCustomerforadmin(@RequestBody @Valid @RequestParam("ID")int ID,@RequestParam("password") String password,@RequestParam("type")String type,@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName,@RequestParam("address") String address,@RequestParam("cellphone") int cellphone,@RequestParam("email") String email,@RequestParam("adminpassword")String Apassword ){
if(Apassword.equals("admin")){
    if(interfaceinController.ifissecure(password)){
    if(!interfaceinController.ifUserRegister(ID)){
        if(!interfaceinController.ifpasswordalreadyfound(password)){
    Admin persoAdmin=new Admin(0, " ", " ", " "," ", " ", 0, " ");
    persoAdmin.addNewCustomer(ID,password,type,firstName,lastName,address,cellphone,email);
    return "Success";

  }
  else{
    return "error";
  }
}
else{
    return "error";
}
}
  else{
    return"error";
  }
}
else{
    return "error";
}
}


//----------------------------removeCustomer-----------------------

@GetMapping("/removeCustomer")
public String removeCustomerforadmin(){
    return "removeCustomer";
}


@PostMapping("/removeCustomer")
public String removeCustomerforadmin(@Valid @RequestParam("customerID")int ID,@RequestParam("password") String password){
if(password.equals("admin")){
    if(interfaceinController.ifisCustomer(ID)){
    Admin persoAdmin=new Admin(0, " ", " ", " "," ", " ", 0, " ");
    persoAdmin.removeCustomer(ID);
    return"Success";

  }
  else{
    return"error";
  }
}
  else{
    return"error";
  }
}




//---------------------------addbroker---------------------------------------------------------
 
@GetMapping("/addBroker")
public String addBrokerforadmin(){
    return "addBroker";
}


@PostMapping("/addBroker")
public String addBrokerforadmin(@RequestBody @Valid @RequestParam("ID")int ID,@RequestParam("password") String password,@RequestParam("type")String type,@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName,@RequestParam("address") String address,@RequestParam("cellphone") int cellphone,@RequestParam("email") String email,@RequestParam("adminpassword")String Apassword){
if(Apassword.equals("admin")){
    if(interfaceinController.ifissecure(password)){
    if(!interfaceinController.ifUserRegister(ID)){
        if(!interfaceinController.ifpasswordalreadyfound(password)){
    Admin persoAdmin=new Admin(0, " ", " ", " "," ", " ", 0, " ");
    persoAdmin.addNewBroker(ID,password,type,firstName,lastName,address,cellphone,email);
    return "Success";

  }
  else{
    return "error";
  }
}
else{
    return "error";
}
}
  else{
    return"error";
  }
}
else{
    return "error";
}
}

//-------------------------------------removebroker---------------------------------------------
@GetMapping("/removeBroker")
public String removeBrokerforadmin(){
    return "removeBroker";
}


@PostMapping("/removeBroker")
public String removeBrokerforadmin(@Valid @RequestParam("brokerID")int ID,@RequestParam("password") String password){
if(password.equals("admin")){
    if(interfaceinController.ifisBroker(ID)){
    Admin persoAdmin=new Admin(0, " ", " ", " "," ", " ", 0, " ");
    persoAdmin.removeBroker(ID);
    return "Success";

  }
  
  else{
    return"error";
  }}
  else{
    return"error";
  }
}
//------------------------------------searchfor-----------------------------------------------


/*@GetMapping("/ViewCustomers")
public List<Customer> Searchfor(){
    return FristService.listCustomer;
}*/
@GetMapping("/SearchFor")
public String searchFor() {
    return "Searchfor";
}

@PostMapping("/SearchFor")
@ResponseBody  // Ensure this annotation is present to serialize the response
public List<Person> searchFor(@Valid @RequestBody String  type) {
    // Clear the list before populating with new results
    Admin admin = new Admin(0, " ", " ", " ", " ", " ", 0, " ");
 return admin.viewall(type);
}

/*@GetMapping("/SearchFor")
public String searchfor(){
    return "Searchfor";
}

List<Person> rolelist=new ArrayList<Person>();
@PostMapping("/SearchFor")
public void Searchfor(@Valid @RequestBody String type, String password){
    for (Person per : rolelist) {
        rolelist.remove(per); 
    }
    Admin admin=new Admin(0, " ", " ", " ", " ", " ", 0, password);
   rolelist=admin.viewall(type);
}

/*@GetMapping("/Roleneeded")
public List<Person> returnRole(){
    return rolelist;
}

/*@GetMapping("/ViewBrokers")
public List<Broker> viewbroker(){
    return FristService.listBroker;
}*/

//-----------------------------------Authorize-------------------------------------------------------

@GetMapping("/Authorize")
public String Authorize(){
    return "Authorize";
}


@PostMapping("/Authorize")
public String Authorize(@RequestBody @RequestParam("userID")int ID,@RequestParam ("oldtype")String oldtype,@RequestParam("adminpassword") String Apassword){
if(Apassword.equals("admin")){
    if(interfaceinController.ifUserRegister(ID)){
    Admin persoAdmin=new Admin(0, " ", " ", " "," ", " ", 0, " ");
    persoAdmin.Authorize_new_user(ID, oldtype);
    return "Success";

  }
  else{
    return"error";
  }}
  else{
    return"error";
  }
}


//-----------------------------------viewRequest----------------------------------------------------------


@GetMapping("/ViewRequest")
public String ViewRequest(){
    return "ViewReq";
}

List<Request> showreq=new ArrayList<>();
@PostMapping("/ViewRequest")
public void ViewRequest( @RequestBody @Valid Date date,String password){
    Admin persoAdmin=new Admin(0, " ", " ", " "," ", " ", 0, " ");
   showreq= persoAdmin.viewrequests(date);

}
@GetMapping("/displayrequests")
public String displayallrequests(){
    return"displayrequests";
}


//------------------------------------Broker-------------------------------
@GetMapping("/Broker")
public String BrokerMethodsGet(){
    return"Broker";
}


//-------------------------------------------addHouse--------------------------------------------------


@GetMapping("/addHouse")
public String addHouse(){
    return "addHouse";

}

@PostMapping("/addHouse")
public String addHouse(@Valid @RequestBody @RequestParam("Location") String Location,@RequestParam("HouseType") String HouseType,@RequestParam("Housepic") String pic,@RequestParam("Area") double area,@RequestParam("DepositValue")double DepositValue,@RequestParam("AvailableFor") String avlfor,@RequestParam("TotalPrice") double TotalPrice,@RequestParam("PriceNegotiable") boolean pricenego,@RequestParam("brokerID") int ID){
 if(interfaceinController.ifisBroker(ID)){
    for (Broker b : FristService.listBroker) {
        if(b.getID()==ID){
            b.addhouse(Location, HouseType, pic, area, DepositValue, avlfor, TotalPrice, pricenego);
        }
    }
    return"Success";
 }
 else{
   return"error";
 }
}


//-----------------------------------------addHouselocation---------------------------------------------

@GetMapping("/addHouselocation")
public String addHouselocation(){
    return "addHouselocation";

}

@PostMapping("/addHouselocation")
public String addHouselocation(@Valid @RequestBody @RequestParam("HouseID") int HouseID,@RequestParam("Location") String Location,@RequestParam("brokerID") int ID){
 if(interfaceinController.ifisBroker(ID)){
    for (Broker b : FristService.listBroker) {
        if(b.getID()==ID){
            b.addhouselocation(HouseID, Location);
        }
    }
    return"Success";
 }
 else{
    return"error";
 }
}

//-----------------------------------------removeHouse---------------------------------------------------

@GetMapping("/removeHouse")
public String removeHouse(){
    return "removeHouse";

}

@PostMapping("/removeHouse")
public String removeHouse(@Valid @RequestParam("HouseID") int HouseID, @RequestParam("brokerID") int ID ){
 if(interfaceinController.ifisBroker(ID)){
    for (Broker b : FristService.listBroker) {
        if(b.getID()==ID){
            b.removehouse(HouseID);
        }
    }
    return"Success";
 }
 else{
   return"error";
 }
}
//------------------------------------------addhousetype-------------------------------------------------

@GetMapping("/addHousetype")
public String addHousetype(){
    return "addHousetype";

}

@PostMapping("/addHousetype")
public String addHousetype(@Valid @ModelAttribute House house, int ID){
 if(interfaceinController.ifisBroker(ID)){
    for (Broker b : FristService.listBroker) {
        if(b.getID()==ID){
         b.addhousetype(house.getID(),house.getHouse_type());
        }
    }
    return "Success";
 }
 else{
   return"error";
 }
}
//--------------------------------------------opendeal--------------------------------------------------
@GetMapping("/opendeal")
public String opendeal(){
    return "opendeal";

}

@PostMapping("/opendeal")
public String opendeal(@Valid @RequestParam("dealID") int dealID,@RequestParam("dealDate") Date dealDate,@RequestParam("customerLSBN") String cLSBN,@RequestParam("brokerLSBN")String bLSBN,@RequestParam("Deposit") int deposit,@RequestParam("Type")String type,@RequestParam("Status")String status,@RequestParam("brokerID")int ID){
 if(interfaceinController.ifisBroker(ID)){
    for (Broker b : FristService.listBroker) {
        if(b.getID()==ID){
            b.opendeal(ID, dealDate, cLSBN, bLSBN, deposit, type, status);
        }
    }
    return"Success";
 }
 else{
    return"error";
 }
}


//---------------------------------------------donedeals-------------------------------------------------
@GetMapping("/donedeals")
public String donedeals(){
    return "doneDeal";

}
List<Deal> dndeals=new ArrayList<Deal>();

@PostMapping("/donedeals")
public void donedeals(@Valid @RequestBody String brokerLSBN){
    for (Deal deal : dndeals) {
        dndeals.remove(deal);   
    }
  Broker broker=new Broker(0, null, null, null, null, null, 0, null);
           dndeals=broker.donedeals(brokerLSBN);
}

@GetMapping("/Showdonedeals")
public List<Deal> showdonedeals(){
    return dndeals;
}

//----------------------------------------------searchbyarea-----------------------------------------------------------
@GetMapping("/searchbyarea")
public String searchbyarea(){
    return "searchbyarea";

}
List<House> areaneeded=new ArrayList<House>();
@PostMapping("/searchbyarea")
public void searchbyarea( @RequestBody @Valid Double area, int ID){
    Broker broker=new Broker(ID, null, null, null, null, null, ID, null);
            areaneeded= broker.searchbyarea(area);
 

}
@GetMapping("/areasearched")
public List<House> areasearched(){
    return areaneeded;
}







//-------------------------------------EditCustomerinfo------------------------------------------------------

@GetMapping("/Customer")
public String CustomerMethodsGet(){
    return"Customer";
}

@GetMapping("/EditData")
public String EditID(){
    return"EditData";
}

//@PostMapping("/EditData")
//public Person EditIDPost(@RequestBody Person person){
 //   Person per= interfaceinController.FindPerson(person.getPassword());
  //     return per;
   // }
       
    
//@PostMapping("/EditPersonalData")
//public String SaveEdits(@RequestBody Customer customer){
  //  for (Customer C: FristService.listCustomer) {
     //   if(C.getID()==customer.getID()){
       //     C.Edit_Customer_Information(customer.getPassword(), customer.getFirstName(),customer.getLastName(), customer.getAddress(), customer.getCellphone(), customer.getEmail());
        //    break;
        //}
   // }
    //return "Saveddata";

//}


//@GetMapping("/EditPersonalinfo")
//public String EditCustomerinfo(){
  //  return "EditPersonalinfo";

//}

@PostMapping("/EditData")
public String EditCustomerinfo(@Valid @ModelAttribute Customer customer){
 if(interfaceinController.ifisCustomer(customer.getID())){
    for (Customer C : FristService.listCustomer) {
        if(C.getID()==customer.getID()){
            C.Edit_Customer_Information(customer.getPassword(), customer.getFirstName(),customer.getLastName(), customer.getAddress(), customer.getCellphone(), customer.getEmail());
            break;
        }
    }
    return "Success";
 }
 else{
    return"error";
 }
}

//------------------------------------avalibleHouses-----------------------------------------------------------

@GetMapping("/Houses")
public List<House> avalibleHouses(){
    Customer C= new Customer(0, null, null, null, null, null, 0, null);
    return C.AvaliableHouses();
}

//@PostMapping("/avalibleHouses")
//public List<House> avalibleHouses(){
 //  Customer C= new Customer(0, null, null, null, null, null, 0, null)
 //   return C.AvaliableHouses();
 
//}
//----------------------------------avalibleHousesforrent--------------------------------------------------------

@GetMapping("/HouseRent")
public List<House> avalibleHousesforrent(){
    Customer C= new Customer(0, null, null, null, null, null, 0, null);
    return C.AvailableHouse_Rent();
}



//-----------------------------------avalibleHousesforBuy----------------------------------------------
@GetMapping("/HouseBuy")
public List<House> avalibleHousesforbuy(){
    Customer C= new Customer(0, null, null, null, null, null, 0, null);
    return C.AvailableHouse_Buy();
}



//------------------------------------MatchHouses-----------------------------------------------------------
@GetMapping("/MatchHouses")
public String MatchHouses(){
    return "SearchForHouse";

}
List<House> Dreamlist=new ArrayList<House>();
@PostMapping("/MatchHouses")
public void MatchHouses(@Valid @ModelAttribute House house){
    for (House h : Dreamlist) {
        Dreamlist.remove(h);   
    }
    Customer C=new Customer(0, null, null, null, null, null, 0, null);
    Dreamlist= C.MatchHouses(house.getLocation(), house.getArea(), house.getHouse_type(),house.getDepositValue(), house.getAvailableFor(), house.getTotalPrice(), house.isPriceNegotiable());
}

@GetMapping("/MatchDreamHouses")
public List<House> displayDreamHouses(){
    return Dreamlist;
    
}

//---------------------------------------requestHouse-------------------------------------------------------------
@GetMapping("/requestHouse")
public String requestHouse(){
    return "requestHouse";

}

@PostMapping("/requestHouse")
public String requestHouse(@Valid @RequestParam("HouseID") int HouseID,@RequestParam("RequestISBN") int RequestISBN,@RequestParam("RequestType") String RequestType, @RequestParam ("date") Date date,@RequestParam("ID") int ID){
 if(interfaceinController.ifisCustomer(ID)){
    for (Customer C : FristService.listCustomer) {
        if(C.getID()==ID){
            C.Request_house(HouseID,RequestISBN,RequestType,date);
        }
    }
    return"Success";
 }
 else{
    return "error";
 }
}


//-------------------------------------updaterequest-----------------------------------------------------------
@GetMapping("/UpdateRequest")
public String updaterequestget(){
    return "updaterequest";

}

@PostMapping("/UpdateRequest")
public String updaterequestpost(@Valid @RequestParam("RequestISBN") int RequestISBN,@RequestParam("type") String type,@RequestParam("ID") int ID ){
    if(interfaceinController.ifisCustomer(ID)){
    for (Customer C : FristService.listCustomer) {
        if(C.getID()==ID){
            C.UpdateRequest(RequestISBN,type);
        }
    }
    return "Success";
    }
 else{
    return "error";
 }

}

//-------------------------------------removerequest--------------------------------------------------------------------
@GetMapping("/removerequest")
public String removerequest(){
    return "removerequest";

}

@PostMapping("/removerequest")
public String removerequest(@Valid @RequestParam ("RequestISBN") int RequestISBN, @RequestParam("ID") int ID){
 if(interfaceinController.ifisCustomer(ID)){
    for (Customer C : FristService.listCustomer) {
        if(C.getID()==ID){
            C.RemoveRequest(RequestISBN);
        }
    }
    return "Success";
 }
 else{
    return "error";
 }
}

@GetMapping("/Model")
    public List<Person> saveModel() {
        return FristService.listPerson;

    }
    
}




