package controller.Trip;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Trip;

public class BookTripController extends Controller<Trip> {
    @FXML private ImageView bookATripBackgroundImg;
    @FXML private Button addDestinationBtn;
    @FXML private Button removeDestinationBtn;
    @FXML private Button AddConnectingFlightsBtn;
    @FXML private Button viewTripBtn;
    @FXML private Button closeBtn;


public final Trip getTrip() {
    return model;
}

@FXML private void initialize() {
    bookATripBackgroundImg.setImage(new Image("/image/trip.png"));
}
@FXML private void handleExitATrip() throws Exception {
    stage.close();
 }

}