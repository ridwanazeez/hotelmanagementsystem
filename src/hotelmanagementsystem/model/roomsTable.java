/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem.model;

/**
 *
 * @author Ridwan
 */
public class roomsTable {
    
    String RoomNumber, Status;
    int RID, NumberOfBeds, NumberOfBathrooms, Price;

    public roomsTable(String RoomNumber, String Status, int RID, int NumberOfBeds, int NumberOfBathrooms, int Price) {
        this.RoomNumber = RoomNumber;
        this.Status = Status;
        this.RID = RID;
        this.NumberOfBeds = NumberOfBeds;
        this.NumberOfBathrooms = NumberOfBathrooms;
        this.Price = Price;
    }

    public String getRoomNumber() {
        return RoomNumber;
    }

    public void setRoomNumber(String RoomNumber) {
        this.RoomNumber = RoomNumber;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public int getRID() {
        return RID;
    }

    public void setRID(int RID) {
        this.RID = RID;
    }

    public int getNumberOfBeds() {
        return NumberOfBeds;
    }

    public void setNumberOfBeds(int NumberOfBeds) {
        this.NumberOfBeds = NumberOfBeds;
    }

    public int getNumberOfBathrooms() {
        return NumberOfBathrooms;
    }

    public void setNumberOfBathrooms(int NumberOfBathrooms) {
        this.NumberOfBathrooms = NumberOfBathrooms;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

}
