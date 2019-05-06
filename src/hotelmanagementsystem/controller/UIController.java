/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hotelmanagementsystem.controller;

import static hotelmanagementsystem.model.Model.getConnection;
import hotelmanagementsystem.model.bookingsTable;
import hotelmanagementsystem.model.guestsTable;
import hotelmanagementsystem.model.roomsTable;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Ridwan
 */

public class UIController implements Initializable {

    ObservableList<bookingsTable> bookingstablelist = FXCollections.observableArrayList();
    ObservableList<guestsTable> gueststablelist = FXCollections.observableArrayList();
    ObservableList<roomsTable> roomstablelist = FXCollections.observableArrayList();

    @FXML
    private Pane mainScreen;
    @FXML
    private Pane bookingsScreen;
    @FXML
    private Pane guestsScreen;
    @FXML
    private Pane roomsScreen;
    @FXML
    private TableColumn<roomsTable, Integer> rid;
    @FXML
    private TableColumn<roomsTable, String> roomNumber;
    @FXML
    private TableColumn<roomsTable, Integer> numberOfBeds;
    @FXML
    private TableColumn<roomsTable, Integer> numberOfBathrooms;
    @FXML
    private TableColumn<roomsTable, Integer> price;
    @FXML
    private TableColumn<roomsTable, String> status;
    @FXML
    private TextField roomNumberCreate;
    @FXML
    private TextField priceCreate;
    @FXML
    private TextField numberofBathroomsCreate;
    @FXML
    private TextField numberOfBedsCreate;
    @FXML
    private TextField ridUpdate;
    @FXML
    private TextField roomNumberUpdate;
    @FXML
    private TextField priceUpdate;
    @FXML
    private TextField numberofBathroomsUpdate;
    @FXML
    private TextField numberOfBedsUpdate;
    @FXML
    private TextField ridDelete;
    @FXML
    private Pane loginScreen;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private TableColumn<bookingsTable, Integer> bid;
    @FXML
    private TableColumn<bookingsTable, Integer> ridBookingsCol;
    @FXML
    private TableColumn<bookingsTable, Integer> gidBookingsCol;
    @FXML
    private TableColumn<bookingsTable, Date> checkInBookingsCol;
    @FXML
    private TableColumn<bookingsTable, Date> checkOutBookingsCol;
    @FXML
    private TextField ridBookingsInput;
    @FXML
    private TextField gidBookingsInput;
    @FXML
    private TextField bidUpdate;
    @FXML
    private TextField ridBookingsUpdate;
    @FXML
    private TextField gidBookingsUpdate;
    @FXML
    private DatePicker checkInBookingsUpdate;
    @FXML
    private DatePicker checkOutBookingsUpdate;
    @FXML
    private TextField bidDelete;
    @FXML
    private TableColumn<guestsTable, Integer> gid;
    @FXML
    private TableColumn<guestsTable, String> guestFNameCol;
    @FXML
    private TableColumn<guestsTable, String> guestLNameCol;
    @FXML
    private TableColumn<guestsTable, String> guestAddressCol;
    @FXML
    private TableColumn<guestsTable, Date> guestDOBCol;
    @FXML
    private TableColumn<guestsTable, String> guestNumberCol;
    @FXML
    private TextField guestFNameInput;
    @FXML
    private TextField guestNumberInput;
    @FXML
    private TextField guestAddressInput;
    @FXML
    private TextField guestLNameInput;
    @FXML
    private DatePicker guestDOBInput;
    @FXML
    private TextField gidUpdate;
    @FXML
    private TextField guestFNameUpdate;
    @FXML
    private TextField guestNumberUpdate;
    @FXML
    private TextField guestAddressUpdate;
    @FXML
    private TextField guestLNameUpdate;
    @FXML
    private DatePicker guestDOBUpdate;
    @FXML
    private TextField gidDelete;
    @FXML
    private Text error;
    @FXML
    private Text mainscreentext;
    @FXML
    private Pane aboutScreen;
    @FXML
    private DatePicker checkInBookingsInput;
    @FXML
    private DatePicker checkOutBookingsInput;
    @FXML
    private TableView<bookingsTable> bookingsTable;
    @FXML
    private TableView<guestsTable> guestsTable;
    @FXML
    private TableView<roomsTable> roomsTable;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //bookings table try catch
        try {
            Connection conn = getConnection();
            
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM bookings");

            while(rs.next()) {
                bookingstablelist.add(new bookingsTable(rs.getInt("BID"), rs.getInt("RID"), rs.getInt("GID"), rs.getDate("CheckIn"), rs.getDate("CheckOut")));
            }

        } catch (Exception ex) {
            Logger.getLogger(UIController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //guests table try catch
        try {
            Connection conn = getConnection();
            
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM guests");

            while(rs.next()) {
                gueststablelist.add(new guestsTable(rs.getInt("GID"), rs.getString("FirstName"), rs.getString("LastName"), rs.getString("Address"), rs.getString("Number"), rs.getDate("DateOfBirth")));
            }

        } catch (Exception ex) {
            Logger.getLogger(UIController.class.getName()).log(Level.SEVERE, null, ex);
        }

        //rooms table try catch
        try {
            Connection conn = getConnection();
            
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM rooms");

            while(rs.next()) {
                roomstablelist.add(new roomsTable(rs.getString("RoomNumber"), rs.getString("Status"), rs.getInt("RID"), rs.getInt("NumberOfBeds"), rs.getInt("NumberOfBathrooms"), rs.getInt("Price")));
            }

        } catch (Exception ex) {
            Logger.getLogger(UIController.class.getName()).log(Level.SEVERE, null, ex);
        }

        bid.setCellValueFactory(new PropertyValueFactory<>("BID"));
        ridBookingsCol.setCellValueFactory(new PropertyValueFactory<>("RID"));
        gidBookingsCol.setCellValueFactory(new PropertyValueFactory<>("GID"));
        checkInBookingsCol.setCellValueFactory(new PropertyValueFactory<>("CheckIn"));
        checkOutBookingsCol.setCellValueFactory(new PropertyValueFactory<>("CheckOut"));
        
        gid.setCellValueFactory(new PropertyValueFactory<>("GID"));
        guestFNameCol.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        guestLNameCol.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        guestAddressCol.setCellValueFactory(new PropertyValueFactory<>("Address"));
        guestDOBCol.setCellValueFactory(new PropertyValueFactory<>("DateOfBirth"));
        guestNumberCol.setCellValueFactory(new PropertyValueFactory<>("Number"));
        
        rid.setCellValueFactory(new PropertyValueFactory<>("RID"));
        roomNumber.setCellValueFactory(new PropertyValueFactory<>("RoomNumber"));
        numberOfBeds.setCellValueFactory(new PropertyValueFactory<>("NumberOfBeds"));
        numberOfBathrooms.setCellValueFactory(new PropertyValueFactory<>("NumberOfBathrooms"));
        price.setCellValueFactory(new PropertyValueFactory<>("Price"));
        status.setCellValueFactory(new PropertyValueFactory<>("Status"));

        bookingsTable.setItems(bookingstablelist);
        guestsTable.setItems(gueststablelist);
        roomsTable.setItems(roomstablelist);
   
    }    

    @FXML
    private void signIn(ActionEvent event) throws Exception {
        Connection conn = getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String SQL = "SELECT * FROM users where username=? AND password=? LIMIT 1";
        String uname = username.getText();
        String pword = password.getText();
        try {
            pst = conn.prepareStatement(SQL);
            pst.setString(1, uname);
            pst.setString(2, pword);
            rs = pst.executeQuery();
            if(rs.next()) {
                mainScreen.setVisible(true);
                loginScreen.setVisible(false);                 
            }
            else {
                error.setVisible(true);
                username.setText("");
                password.setText("");                
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @FXML
    private void signOut(ActionEvent event) {
        username.setText("");
        password.setText("");  
        mainScreen.setVisible(false);
        loginScreen.setVisible(true);  
    }

    @FXML
    private void quit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void createBooking(ActionEvent event) {
    }

    @FXML
    private void updateBooking(ActionEvent event) {
    }

    @FXML
    private void deleteBooking(ActionEvent event) {
    }

    @FXML
    private void createGuest(ActionEvent event) {
    }
    
    private void readGuests() {
        
    }

    @FXML
    private void updateGuest(ActionEvent event) {
    }

    @FXML
    private void deleteGuest(ActionEvent event) {
    }

    @FXML
    private void createRoom(ActionEvent event) {
    }

    @FXML
    private void updateRoom(ActionEvent event) {
    }

    @FXML
    private void deleteRoom(ActionEvent event) {
    }
    
    @FXML
    private void showBookingsScreen(ActionEvent event) {
        aboutScreen.setVisible(false);
        bookingsScreen.setVisible(true);
        guestsScreen.setVisible(false);
        mainscreentext.setVisible(false);    
        roomsScreen.setVisible(false);
    }

    @FXML
    private void showGuestsScreen(ActionEvent event) {
        aboutScreen.setVisible(false);
        bookingsScreen.setVisible(false);
        guestsScreen.setVisible(true);
        mainscreentext.setVisible(false);    
        roomsScreen.setVisible(false);   
    }

    @FXML
    private void showRoomsScreen(ActionEvent event) {
        aboutScreen.setVisible(false);
        bookingsScreen.setVisible(false);
        guestsScreen.setVisible(false);
        mainscreentext.setVisible(false);    
        roomsScreen.setVisible(true);
    }

    @FXML
    private void showAboutScreen(ActionEvent event) {
        aboutScreen.setVisible(true);
        bookingsScreen.setVisible(false);
        guestsScreen.setVisible(false);
        mainscreentext.setVisible(false);    
        roomsScreen.setVisible(false);
    }

}
