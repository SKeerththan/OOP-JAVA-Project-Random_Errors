/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Src;

/**
 *
 * @author Keerththan
 */
public class Customer {

    private static String cusName;
    public static String VehNo;
    private static String cusMail;
    private static String cusContNo;

    public Customer(String cusName, String VehNo, String cusMail, String cusContNo) {
        Customer.cusName = cusName;
        Customer.VehNo = VehNo;
        Customer.cusMail = cusMail;
        Customer.cusContNo = cusContNo;
    }

    public Customer() {

    }

    public String getCusName() {
        return cusName;
    }

    public String getVehNo() {
        return VehNo;
    }

    public String getCusMail() {
        return cusMail;
    }

    public String getCusContNo() {
        return cusContNo;
    }

}
