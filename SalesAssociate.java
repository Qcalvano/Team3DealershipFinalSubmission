package edu.psu.abington.ist.ist242;

/*
Project: Car Dealership Class Creation
Purpose Details: A program that simulates a car dealership system.
Course: IST 242
Author: Quenten Calvano, Michael Mandia, Yashika Patel, Raj Patel, Dhaval Patel
Date Developed: 6/13/20
Last Date Changed: 6/14/2020
Rev: 2
 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SalesAssociate extends User {
    //class variable -Protect Data
    private int carId;
    private int salesmanId;
    private boolean carSold;
    private String carDescription;
    private int customerId;
    private String CustomerName;
    private String CustomerPhoneNumber;

    //Constructor
    public SalesAssociate(int _carId, int _salesmanId, boolean _carSold, String _carDescription, int _customerId, String _CustomerName, String _CustomerPhoneNumber) {
        this.carId = _carId;
        this.salesmanId = _salesmanId;
        this.carSold = _carSold;
        this.carDescription = _carDescription;
        this.customerId = _customerId;
        this.CustomerName= _CustomerName;
        this.CustomerPhoneNumber= _CustomerPhoneNumber;
    }

    //setter & getter
    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getSalesmanId() {
        return salesmanId;
    }
    public void setSalesmanId(int salesmanId) {
        this.salesmanId = salesmanId;
    }
    public boolean getCarSold() {
        return carSold;
    }
    public void setCarSold(boolean carSold) {
        this.carSold = carSold;
    }
    public String getCarDescription() {
        return carDescription;
    }
    public void setCarDescription(String carDescription) {
        this.carDescription = carDescription;
    }
    public int getCustomerId(){
        return customerId;
    }
    public void setCustomerId(int customerId){
        this.customerId = customerId;
    }
    public String getCustomerName(){return CustomerName;}
    public void setCustomerName(String CustomerName){this.CustomerName= CustomerName;}
    public String getCustomerPhoneNumber(){return CustomerPhoneNumber;}
    public void setCustomerPhoneNumber(String CustomerPhoneNumber){this.CustomerPhoneNumber = CustomerPhoneNumber;}


    /**
     * This method prints the sales records by following order
     *
     * @author          Mike Mandia, Team 03
     * @version         1.0
     * @since           2020-24-06
     */
    public void viewRecordSales() {
        System.out.println("Car Id: " + getCarId());
        System.out.println("Salesman Id: " + getSalesmanId());
        System.out.println("Car sold: " + getCarSold());
        System.out.println("Car Description: " + getCarDescription());
    }
    /**
     * This method is used to view the car entries within the Sales Associate class.
     * @author          Mike Mandia, Team 03
     * @version         1.0
     * @since           2020-24-06
     */
    public void updateCarEntries() {
        System.out.println("Car Id: " + getCarId());
        System.out.println("Car Description: " + getCarDescription());
    }
    /**
     * This method prints the customer records of a customers in the sales associate class.
     * @author          Mike Mandia, Team 03
     * @version         1.0
     * @since           2020-24-06
     */
    public void viewCustomerContacts() {
        System.out.println("Car ID: " + getCarId());
        System.out.println("Customer Contact Id: " + getCustomerId());
        System.out.println("Customer Phone Number:"+getCustomerPhoneNumber());
        System.out.println("Customer Name:"+getCustomerName());
    }

    /**
     * This method is used for crating a set of users for the passed in User array and
     * provide sample users for program testing.
     * @param uList     An ArrayList of User objects.
     * @author          Quenten Calvano, team 03
     * @version         1.0
     * @since           2020-24-06
     */
    public static void createSalesAssociateSampleUsers (ArrayList<User> uList) {
        User user1 = new User();
        user1.setUserName("Frank Friend");
        user1.setPassword("password");
        user1.setTypeID(1);
        user1.generateUserRole(user1.getTypeID());
        uList.add(user1);

        User user2 = new User();
        user2.setUserName("Chris Romero");
        user2.setPassword("password");
        user2.setTypeID(1);
        user2.generateUserRole(user1.getTypeID());
        uList.add(user2);
    }
    /**
     * This method adds sales records for the sales user indicated by the sales ID.
     * @param saList    An array of sales associate objects.
     * @param carList   An Arraylist of cars objects.
     * @author          Quenten Calvano, team 03
     * @version         1.0
     * @since           2020-24-06
     */
    public static void addSalesForAssociateUser(ArrayList<SalesAssociate> saList, ArrayList<Car> carList){
        SalesAssociate salesman = new SalesAssociate(0, 0, false, null, 0, null, null);
        Scanner scnr = new Scanner(System.in);
        boolean exit = false;
        do {
            System.out.println("What kind of sales data would you like to add?");
            System.out.println("(1)Sales Records. \n(2)Customer Contacts.\n(3)Exit.");
            String userInput = scnr.next();
            if (userInput.equals("1")){
                System.out.println("Enter Sales ID: ");
                try {
                    salesman.setSalesmanId(scnr.nextInt());
                }catch (InputMismatchException e) {
                    System.out.println("ERROR: InputMismatchException. Integers only. Please try again.");
                }
                System.out.println("Enter Car ID: ");
                try {
                    salesman.setCarId(scnr.nextInt());
                    for (Car car: carList) {
                        if (salesman.getCarId() == car.getCarID()){
                            salesman.setCarDescription(car.getCarDescription());
                        }
                        else {
                            System.out.println("ERROR: Incorrect car ID.");
                            throw new Exception();
                        }
                    }
                }catch (InputMismatchException e) {
                    System.out.println("ERROR: InputMismatchException. Integers only. Please try again.");
                }
                catch (Exception e) {
                    System.out.println("Returning to menu...");
                }
                boolean yesNoComplete = false;
                do {

                    System.out.println("Was the car sold? (y/n): ");
                    char yesOrNo = scnr.next().charAt(0);
                    if (yesOrNo == 'y' || yesOrNo == 'Y') {
                        salesman.setCarSold(true);
                        yesNoComplete = true;
                    } else if (yesOrNo == 'n' || yesOrNo == 'N') {
                        salesman.setCarSold(false);
                        yesNoComplete = true;
                    } else {
                        System.out.println("Invalid input. Please try again.");
                    }
                } while (!yesNoComplete);
            }
            else if(userInput.equals("2")) {
                System.out.println("Enter car ID: ");
                try {
                    salesman.setCarId(scnr.nextInt());
                }catch (InputMismatchException e) {
                    System.out.println("ERROR: InputMismatchException. Integers only. Please try again.");
                }
                System.out.println("Enter customer ID: ");
                try {
                    salesman.setCustomerId(scnr.nextInt());
                }catch (InputMismatchException e) {
                    System.out.println("ERROR: InputMismatchException. Integers only. Please try again.");
                }
                System.out.println("Enter customer name: ");
                salesman.setCustomerName(scnr.nextLine());
                scnr.reset();
                System.out.println("Enter customer phone number: ");
                salesman.setCustomerPhoneNumber(scnr.nextLine());
                scnr.reset();
            }
            else if(userInput.equals("3")) {
                exit =true;
                saList.add(salesman);
            }
            else {
                System.out.println("Invalid input please try again.");
            }
        } while (!exit);
    }
}