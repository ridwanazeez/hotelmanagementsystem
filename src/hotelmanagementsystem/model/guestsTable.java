/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem.model;

import java.sql.Date;

/**
 *
 * @author Ridwan
 */
public class guestsTable {
    
    int GID;
    String FirstName, LastName, Address, Number;
    Date DateOfBirth;

    public guestsTable(int GID, String FirstName, String LastName, String Address, String Number, Date DateOfBirth) {
        this.GID = GID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Address = Address;
        this.Number = Number;
        this.DateOfBirth = DateOfBirth;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String Number) {
        this.Number = Number;
    }

    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(Date DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    public int getGID() {
        return GID;
    }

    public void setGID(int GID) {
        this.GID = GID;
    }

}
