package edu.psu.abington.ist.ist242;

/*
Project: Car Dealership Class Creation
Purpose Details: A program that simulates a car dealership system.
Course: IST 242
Author: Quenten Calvano, Michael Mandia, Yashika Patel, Dhaval Patel, Raj Patel
Date Developed: 6/13/20
Last Date Changed: 6/14/2020
Rev: 2
 */

import java.util.ArrayList;
import static org.junit.Assert.*;

public class Tests extends User{

    private ArrayList<User> testUserList;
    private ArrayList<Car> testCarList;
    private String testUsername;
    private String testPass;

    @org.junit.Test
    public void addUserUnitTestTrue(){
        User.addUser(testUserList);
        if (testUserList.size() >= 0){
            assertTrue(testUserList.size() >= 0);
        }
    }
    @org.junit.Test
    public void addUserUnitTestFalse()
    {
        User.addUser(testUserList);
        if (testUserList.size() <= 0){
            assertTrue(testUserList.size() <= 0);
        }
    }
    @org.junit.Test
    public void loginVerifyUnitTestTrue(){
        if (User.verifyUserLogin(testUserList) == true){
            assertTrue(true);
        }
    }
    @org.junit.Test
    public void loginVerifyUnitTestFalse()
    {
        if (User.verifyUserLogin(testUserList) == false){
            assertTrue(false);
        }
    }
    @org.junit.Test
    public void addCarToLotUnitTestTrue(){
        Car.addVehiclesToLot(testCarList);
        if (testCarList.size() >= 0){
            assertTrue(testCarList.size() >= 0);
        }
    }
    @org.junit.Test
    public void addCarToLotTestFalse()
    {
        Car.addVehiclesToLot(testCarList);
        if (testCarList.size() <= 0){
            assertTrue(testCarList.size() <= 0);
        }
    }

}