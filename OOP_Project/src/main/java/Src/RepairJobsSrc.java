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
public class RepairJobsSrc {
    private String iD;
    private String Static;
    private double payment;

    public RepairJobsSrc(String Static, double payment,String iD) {
        this.iD=iD;
        this.Static = Static;
        this.payment = payment;
    }

}
