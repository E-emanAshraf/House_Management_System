/*package com.OopprojectHouserentSystem.HouserentProject.java.com.OopprojectHouserentSystem.HouserentProject.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.OopprojectHouserentSystem.HouserentProject.java.com.OopprojectHouserentSystem.HouserentProject.Model.Broker;
import com.OopprojectHouserentSystem.HouserentProject.java.com.OopprojectHouserentSystem.HouserentProject.Model.Customer;
import com.OopprojectHouserentSystem.HouserentProject.java.com.OopprojectHouserentSystem.HouserentProject.Model.Deal;
import com.OopprojectHouserentSystem.HouserentProject.java.com.OopprojectHouserentSystem.HouserentProject.Model.House;
import com.OopprojectHouserentSystem.HouserentProject.java.com.OopprojectHouserentSystem.HouserentProject.Model.Request;



public class FileHandler {
    public static void writeCustomersToFile(List<Customer> customers, String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, false))) {
            for (Customer customer : customers) {
                writer.println(customer.toString());
            }
            System.out.println("Data written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void writeBorkerToFile(List<Broker> broker, String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, false))) {
            for (Broker brroker : broker) {
                writer.println(brroker.toString());
            }
            System.out.println("Data written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void writeHouseToFile(List<House> house, String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, false))) {
            for (House housse : house) {
                writer.println(housse.toString());
            }
            System.out.println("Data written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
  
 public static void writeDealsToFile(List<Deal> Deal, String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, false))) {
            for (Deal deall : Deal) {
                writer.println(deall.toString());
            }
            System.out.println("Data written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
public static void writeRequestToFile(List<Request> request, String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, false))) {
            for (Request Request : request) {
                writer.println(Request.toString());
            }
            System.out.println("Data written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void deleteFile(String filePath) {
        File fileToDelete = new File(filePath);
        if (fileToDelete.delete()) {
            System.out.println("File deleted successfully.");
        } else {
            System.out.println("Failed to delete the file.");
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////
    public static List<Customer> readCustomersFromFile(String filePath) {
        
         List<Customer> customers = new ArrayList<Customer>();
        customers = FristService.listCustomer;

        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");

                Customer customer = new Customer(0, " ", " ", " ", " ", " ", 0, " ");
                customer.setID(Integer.parseInt(data[0]));
                customer.setPassword(data[1]);
                customer.settype(data[2]);
                customer.setFirstName(data[3]);
                customer.setLastName(data[4]);
                customer.setAddress(data[5]);
                customer.setEmail(data[6]);
                customers.add(customer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return customers;
        
    }
    public static List<Broker> readBrokerFromFile(String filePath) {
        List<Broker> b = FristService.listBroker;

        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");

                Broker customer = new Broker(0, " ", " ", " ", " ", " ", 0, " ");
                customer.setID(Integer.parseInt(data[0]));
                customer.setPassword(data[1]);
                customer.settype(data[2]);
                customer.setFirstName(data[3]);
                customer.setLastName(data[4]);
                customer.setAddress(data[5]);
                customer.setEmail(data[6]);

                b.add(customer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return b;
        
    }
    public static List<Request> readRequestsFromFile(String filePath) {
        List<Request> requests = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");

                Request request = new Request(0, 0, 0, " ", null);
                request.setID(  Integer.parseInt(data[0]));
                request.setCustomerISBN( Integer.parseInt(data[1]));
                request.setHouseID(Integer.parseInt(data[2]));
                request.setRequesttype ( data[3]);
                request. = Integer.parseInt(data[4]);
                requests.add(request);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return requests;
    }
    public static ArrayList<House> readHousesFromFile(String filePath) {
        ArrayList<House> houses = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");

                House house = new House(" ", " ", " ", 0, 0, " ", 0, " ");
                house.setLocation(data[0]);
                house.setArea(Double.parseDouble(data[1]));
                house.setDepositValue(Double.parseDouble(data[2]));
                house.setAvailableFor(data[3]);
                house.setTotalPrice(Double.parseDouble(data[4]));
                house.setisPriceNegotiable(Boolean.parseBoolean(data[5]));
                house.setID(Integer.parseInt(data[6]));
                house.set(Boolean.parseBoolean(data[7]));
                house.setBrockerID(Integer.parseInt(data[8]));
                houses.add(house);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return houses;
    }
    public static ArrayList<deal> readDealFromFile(String filePath) {
        ArrayList<deal> d = UserRegistration.deal_ArrayList;

        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");

                Deal customer = new Deal(0, null, " ", " ", 0, " ", " ");
                customer.setID(Integer.parseInt(data[0]));
                customer.setcustomerLSBN(Integer.parseInt(data[1]));
                customer.setdeposit(Integer.parseInt(data[2]));
                customer.setbrokerISBN(Integer.parseInt(data[3]));
                customer.settype(data[4]);
                customer.setstatus(data[5]);
                customer.setDaydate(Integer.parseInt(data[6]));
                customer.setMonthdate(Integer.parseInt(data[7]));
                customer.setYeardate(Integer.parseInt(data[8]));

                d.add(customer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return d;

    }
}*/