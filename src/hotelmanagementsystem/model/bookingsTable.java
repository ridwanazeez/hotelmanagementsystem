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
public class bookingsTable {
    
    int BID, RID, GID;
    Date CheckIn, CheckOut;

    public bookingsTable(int BID, int RID, int GID, Date CheckIn, Date CheckOut) {
        this.BID = BID;
        this.RID = RID;
        this.GID = GID;
        this.CheckIn = CheckIn;
        this.CheckOut = CheckOut;
    }

    public int getBID() {
        return BID;
    }

    public void setBID(int BID) {
        this.BID = BID;
    }

    public int getRID() {
        return RID;
    }

    public void setRID(int RID) {
        this.RID = RID;
    }

    public int getGID() {
        return GID;
    }

    public void setGID(int GID) {
        this.GID = GID;
    }

    public Date getCheckIn() {
        return CheckIn;
    }

    public void setCheckIn(Date CheckIn) {
        this.CheckIn = CheckIn;
    }

    public Date getCheckOut() {
        return CheckOut;
    }

    public void setCheckOut(Date CheckOut) {
        this.CheckOut = CheckOut;
    }

}
