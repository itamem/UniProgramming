package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Administrators;
import model.Agency;
import model.Trip;
import javafx.scene.image.ImageView;

public class AgencyController extends Controller<Agency> {
    @FXML private ImageView agencyImg;
    @FXML private ImageView agencyBackgroundImg;
    // @FXML ImageView flightsBackgroundImg;
    @FXML private Button exploreFlightsBtn;
    @FXML private Button exploreDestinationsBtn;
    @FXML private Button exploreBookATripBtn;
    @FXML private Button exitBtn;

    public final Agency getAgency() {
        return model;
    }

    @FXML private void initialize() {
        agencyBackgroundImg.setImage(new Image("/image/agency.png"));
        // flightsBackgroundImg.setImage(new Image("/image/flights.png"));
    }

    @FXML private void handleExploreFlights() throws Exception {
        Stage exploreFlightsStage = new Stage();
        // stage.close();
        
        exploreFlightsStage.getIcons().add(new Image("/image/flights_icon.png"));
        ViewLoader.showStage(getAgency().getFlights(), "/view/Flights/ExploreFlightsView.fxml", "Explore Flights", exploreFlightsStage);
        
    }

    @FXML private void handleExploreDestinations() throws Exception {
        Stage exploreDestinationsStage = new Stage();
        // stage.close();
        
        exploreDestinationsStage.getIcons().add(new Image("/image/destinations_icon.png"));
        ViewLoader.showStage(getAgency().getDestinations(), "/view/Destinations/ExploreDestinationsView.fxml", "Explore Destinations", exploreDestinationsStage);
        
    }
    @FXML private void handleBookATrip() throws Exception {
        Trip trip = new Trip(getAgency());
        Stage bookATripStage = new Stage();
        // stage.close();
        
        bookATripStage.getIcons().add(new Image("/image/trip_icon.png"));
        ViewLoader.showStage(trip, "/view/Trip/BookTripView.fxml", "Book a Trip", bookATripStage);
    }
    @FXML private void handleExitLogin() throws Exception {
        stage.close();
     }

    // @FXML private void handleExploreDestinations() throws Exception {

    // }

    // @FXML private void handleBookATrip() throws Exception {

    // }

    // @FXML private void handleExit() throws Exception {

    // }
}

