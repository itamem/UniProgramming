package controller.Destinations;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Destinations;

public class ExploreDestinationsController extends Controller<Destinations> {
    @FXML private ImageView destinationsBackgroundImg;
    @FXML private Button viewAllDestinationsBtn;
    @FXML private Button viewDestinationsByCountryBtn;
    @FXML private Button addDestinationsBtn;
    @FXML private Button removeDestinationsBtn;
    @FXML private Button closeBtn;

public final Destinations getDestinations() {
    return model;
}

@FXML private void initialize() {
    destinationsBackgroundImg.setImage(new Image("/image/destination.png"));
}

@FXML private void handleViewAllDestinations() throws Exception {
    Stage displayDestinationsStage = new Stage();
    displayDestinationsStage.getIcons().add(new Image("/image/destinations_icon.png"));
    ViewLoader.showStage(getDestinations(), "/view/Destinations/DisplayDestinationsView.fxml", "Display Destinations", displayDestinationsStage);

}
@FXML private void handleViewDestinationsByCountry() throws Exception {
    Stage displayFilteredDestintionsStage = new Stage();
    displayFilteredDestintionsStage.getIcons().add(new Image("/image/destinations_icon.png"));
    ViewLoader.showStage(getDestinations(), "/view/Destinations/DisplayFilteredDestinationsView.fxml", "Display Destinations Filtered", displayFilteredDestintionsStage);
}

@FXML private void handleAddDestination() throws Exception {
    Stage addDestinationsStage = new Stage();
    addDestinationsStage.getIcons().add(new Image("/image/destinations_icon.png"));
    ViewLoader.showStage(getDestinations(), "/view/Destinations/AddDestinationView.fxml", "Add Destination", addDestinationsStage);

}

@FXML private void handleRemoveDestination() throws Exception {
    Stage removeDestinationsStage = new Stage();
    removeDestinationsStage.getIcons().add(new Image("/image/destinations_icon.png"));
    ViewLoader.showStage(getDestinations(), "/view/Destinations/RemoveDestinationView.fxml", "Remove Destination", removeDestinationsStage);

}

@FXML private void handleExploreDestExit() throws Exception {
        // Stage exploreDestinationsStage = new Stage();
        stage.close();
        
//         exploreDestinationsStage.getIcons().add(new Image("/image/destinations_icon.png"));
//         ViewLoader.showStage(getDestinations(), "/view/Destinations/ExploreDestinationsView.fxml", "Explore Destinations", exploreDestinationsStage);
        

     }
}

