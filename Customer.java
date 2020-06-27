package edu.psu.abington.ist.ist242;

/*
Project: Car Dealership Class Creation
Purpose Details: Customer Class
Course: IST 242
Author: Yashika Patel, Raj Patel
Date Developed: 6/13/20
Last Date Changed: 6/14/2020
Rev: 2
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends User{
    private int customerID;
    private String customerName;
    private String customerPhoneNumber;
    private String customerAddress;

    //Constructor
    public Customer (int customerID, String customerName, String customerPhoneNumber, String customerAddress) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerPhoneNumber = customerPhoneNumber;
        this.customerAddress = customerAddress;
    }

    //Setters and Getters
    public int getCustomerID() {
        return customerID;
    }
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }
    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }
    public String getCustomerAddress() {
        return customerAddress;
    }
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    /**
     * This method allows the user to print a customer entry.
     *
     * @param cList     ArrayList of customer objects.
     * @author          Yashika Patel, Team 03
     * @version         1.0
     * @since           2020-24-06
     */
    public static void printCustomer(ArrayList<Customer> cList) {
        for (Customer cust : cList) {
            System.out.println("Customer Id:" + cust.getCustomerID());
            System.out.println("Customer Name:" + cust.getCustomerName());
            System.out.println("Customer Phone:" + cust.getCustomerPhoneNumber());
            System.out.println("Customer Address:" + cust.getCustomerAddress());
        }

    }

    /**
     * This method allows the user to set customer data and create a
     * new customer Object to the passed in Customer ArrayList.
     *
     * @param custList  ArrayList of customer objects.
     * @author          Quenten Calvano, team 03
     * @version         1.0
     * @since           2020-24-06
     */
    public static void addCustomerData(ArrayList<Customer> custList){
        int customerID = 1;
        Scanner scnr = new Scanner(System.in);
        Customer cust = new Customer(customerID++, null, null, null);
        System.out.println("Enter Customer Data: ");
        System.out.println("Customer Name:");
        cust.setCustomerName(scnr.next());
        System.out.println("Customer Phone:");
        cust.setCustomerPhoneNumber(scnr.next());
        System.out.println("Customer Address:");
        cust.setCustomerAddress(scnr.next());
        custList.add(cust);
    }

}
