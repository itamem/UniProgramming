package controller.Flights;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import model.Flights;

public class ExploreFlightsController extends Controller<Flights> {
    @FXML private ImageView flightsBackgroundImg;
    @FXML private Button viewAllFlightsBtn;
    @FXML private Button viewFlightsByCoountryBtn;
    @FXML private Button addFlightBtn;
    @FXML private Button removeFlightBtn;
    @FXML private Button closeBtn;

public final Flights getFlights() {
    return model;
}

@FXML private void initialize() {
    flightsBackgroundImg.setImage(new Image("/image/flight.png"));
}

@FXML private void handleClose() throws Exception {
    stage.close();
 }

@FXML private void handleViewAllFlights() throws Exception {
    Stage displayFlightsStage = new Stage();
    displayFlightsStage.getIcons().add(new Image("/image/flights_icon.png"));
    ViewLoader.showStage(getFlights(), "/view/Flights/DisplayFlightsView.fxml", "Display Flights", displayFlightsStage);

}
@FXML private void handleViewFlightsByCountry() throws Exception {
    Stage displayFilteredFlightsStage = new Stage();
    displayFilteredFlightsStage.getIcons().add(new Image("/image/flights_icon.png"));
    ViewLoader.showStage(getFlights(), "/view/Flights/DisplayFilteredFlightsView.fxml", "Display Flights Filtered", displayFilteredFlightsStage);
}

@FXML private void handleAddFlight() throws Exception {
    Stage addFlightsStage = new Stage();
    addFlightsStage.getIcons().add(new Image("/image/flights_icon.png"));
    ViewLoader.showStage(getFlights(), "/view/Flights/AddFlightView.fxml", "Add Flight", addFlightsStage);

}

@FXML private void handleRemoveFlight() throws Exception {
    Stage removeFlightsStage = new Stage();
    removeFlightsStage.getIcons().add(new Image("/image/flights_icon.png"));
    ViewLoader.showStage(getFlights(), "/view/Flights/RemoveFlightView.fxml", "Remove Flight", removeFlightsStage);

}

// @FXML private void handleCloseExploreFlights() throws Exception {
//     Stage addFlightsStage = new Stage();
//     addFlightsStage.getIcons().add(new Image("/image/flights_icon.png"));
//     ViewLoader.showStage(getFlights(), "/view/Flights/AddFlightView.fxml", "Explore Flights", addFlightsStage);

// }
}

