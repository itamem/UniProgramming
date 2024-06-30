package controller.Flights;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.*;

public class ModifyFlightsController extends Controller<Flights> {
    //For AddFlight & RemoveFlight
    @FXML ImageView flightsBackgroundImg;
    //Add Flight

    @FXML TextField airlineTf;
    @FXML TextField flightNoTf;
    @FXML TextField addTakeoffTf;
    @FXML TextField addLandingTf;
    @FXML TextField costTf;
    @FXML Button addFlightBtn;
    @FXML Button closeAddFlightBtn;
    
    //Remove Flight

    @FXML private TextField removeTakeoffTf;
    @FXML private TextField removeLandingTf;
    @FXML private Button removeFlightBtn;
    @FXML private Button closeRemoveFlightBtn;


    private final Flights getFlights() {
        return model;
    }

    
    private final String getAirline() { return airlineTf.getText(); } 
    private final int getflightNo() { return  Integer.parseInt(flightNoTf.getText()); }
    private final String getAddTakeoff() { return addTakeoffTf.getText(); }
    private final String getAddLanding() { return addLandingTf.getText(); }
    private final double getCost() { return  Double.parseDouble(costTf.getText()); }
    private final String getRemoveTakeoff() { return removeTakeoffTf.getText(); }
    private final String getRemoveLanding() { return removeLandingTf.getText();}

    @FXML private void initialize() {
        flightsBackgroundImg.setImage(new Image("/image/flight.png"));
}

    @FXML private void handleAddFlight() throws Exception {
        try {
            if (!getFlights().hasFlight(getAddTakeoff(), getAddLanding())) {
            getFlights().addFlight(new Flight(getAirline(), getflightNo(), getAddTakeoff(), getAddLanding(), getCost()));
        }
    }
        catch (Exception e) {
            System.out.println("error");
        }
}

    @FXML private void handleRemoveFlight() throws Exception {
        try {
            if (getFlights().hasFlight(getRemoveTakeoff(), getRemoveLanding())) {
            getFlights().removeFlight(getFlights().getFlight(getRemoveTakeoff(), getRemoveLanding()));
        }
    }
        catch (Exception e) {
            System.out.println("error");
        }
    }


    @FXML private void handleCloseAddFlights() throws Exception {
        stage.close();

    }

    @FXML private void handleCloseRemoveFlights() throws Exception {
        stage.close();

    }
}
