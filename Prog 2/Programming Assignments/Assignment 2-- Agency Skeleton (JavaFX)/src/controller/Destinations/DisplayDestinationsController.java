package controller.Destinations;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.*;

public class DisplayDestinationsController extends Controller<Destinations>  {
    @FXML private ImageView destinationsBackgroundImg;
    @FXML private TableView<Destination> destinationsTv;
    @FXML private TextField countrySearchTf;

public final Destinations getDestinations() {
    return model;
}
private final String getCountry() { return countrySearchTf.getText();}


@FXML private void initialize() {
    destinationsBackgroundImg.setImage(new Image("/image/destination.png"));
    destinationsTv.setItems(getDestinations().getDestinations());
    destinationsTv.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    if (countrySearchTf != null) {
        countrySearchTf.textProperty().addListener((o, oldText, newText) -> updateTableView());
}
}

private final void updateTableView() {
    if (getDestinations().getFilteredDestinations(getCountry()) !=null) {
        destinationsTv.setItems(getDestinations().getFilteredDestinations(getCountry()));
    }
    else {
        destinationsTv.setItems(getDestinations().getDestinations());
    }
}

    @FXML private void handleViewAllDestinationsClose() throws Exception {
        stage.close();
    }

    @FXML private void handleDestinationsByCountryClose() throws Exception {
        stage.close();
    }
    
    
}
