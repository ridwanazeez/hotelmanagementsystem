/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem.controller;

import static hotelmanagementsystem.model.Model.getConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Ridwan
 */
public class UIController implements Initializable {

    @FXML
    private Pane mainScreen;
    @FXML
    private Pane bookingsScreen;
    @FXML
    private Pane guestsScreen;
    @FXML
    private Pane roomsScreen;
    @FXML
    private TableColumn<?, ?> rid;
    @FXML
    private TableColumn<?, ?> roomNumber;
    @FXML
    private TableColumn<?, ?> numberOfBeds;
    @FXML
    private TableColumn<?, ?> numberOfBathrooms;
    @FXML
    private TableColumn<?, ?> price;
    @FXML
    private TableColumn<?, ?> status;
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
    private TableColumn<?, ?> bid;
    @FXML
    private TableColumn<?, ?> ridBookingsCol;
    @FXML
    private TableColumn<?, ?> gidBookingsCol;
    @FXML
    private TableColumn<?, ?> checkInBookingsCol;
    @FXML
    private TableColumn<?, ?> checkOutBookingsCol;
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
    private TableColumn<?, ?> gid;
    @FXML
    private TableColumn<?, ?> guestFNameCol;
    @FXML
    private TableColumn<?, ?> guestLNameCol;
    @FXML
    private TableColumn<?, ?> guestAddressCol;
    @FXML
    private TableColumn<?, ?> guestDOBCol;
    @FXML
    private TableColumn<?, ?> guestNumberCol;
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
    private TableColumn<?, ?> guestAgeCol;
    @FXML
    private DatePicker checkInBookingsInput;
    @FXML
    private DatePicker checkOutBookingsInput;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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

    @FXML
    private void updateGuest(ActionEvent event) {
    }

    @FXML
    private void deleteGuest(ActionEvent event) {
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
