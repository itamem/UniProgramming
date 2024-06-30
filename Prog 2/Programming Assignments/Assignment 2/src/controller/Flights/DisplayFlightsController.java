package controller.Flights;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.*;


public class DisplayFlightsController extends Controller<Flights> {
    @FXML private ImageView flightsBackgroundImg;
    @FXML private TableView<Flight> flightsTv;
    @FXML private Button closeBtn;
    @FXML private TextField countrySearchTf;
    // @FXML private TableView<Flights> filteredFlightsTv;
    // @FXML private TableColumn<Flights, String> airlineClm;
    

public final Flights getFlights() {
    return model;
}
private final String getCountry() { return countrySearchTf.getText();}

@FXML private void initialize() {
    flightsBackgroundImg.setImage(new Image("/image/flight.png"));
    flightsTv.setItems(getFlights().getFlights());
    flightsTv.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    // airlineClm.setCellValueFactory(cellData -> cellData.getValue().getFlights().getFlights().airlineProperty().asString());
    if (countrySearchTf != null) {
        countrySearchTf.textProperty().addListener((o, oldText, newText) -> updateTableView());
}
}
@FXML private final void handleViewAllFlightsClose() {
    stage.close();
}
//when a user input something that matches with the 

    private final void updateTableView() {
        if (getFlights().getFilteredFlights(getCountry()) !=null) {
            flightsTv.setItems(getFlights().getFilteredFlights(getCountry()));
        }
        else {
            flightsTv.setItems(getFlights().getFlights());
        }
    }

    //if flights exist getFlights().getFilteredFlights(getCountry() != null)
    //update newText == getFlights().getFilteredFlights(getCountry())
    //else {}

}
//get countrySearchTf
//check if countrySearchTf is contained in takeoff & landing country