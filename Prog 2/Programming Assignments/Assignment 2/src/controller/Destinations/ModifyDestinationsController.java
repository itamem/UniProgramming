package controller.Destinations;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.*;

public class ModifyDestinationsController extends Controller<Destinations> {
    //For AddFlight & RemoveFlight
    @FXML private ImageView destinationsBackgroundImg;
    //Add Flight

    @FXML private TextField addNameofDestinationTf;
    @FXML private TextField addCountryTf;
    @FXML private Button addDestinationBtn;
    @FXML private Button closeAddDestinationBtn;
    
    @FXML private TextField removeNameofDestinatonTf;
    @FXML private TextField removeCountryTf;
    @FXML private Button removeDestinationBtn;
    @FXML private Button closeRemoveDestinationBtn;


    public final Destinations getDestinations() {
        return model;
    }
    
    private final String getName() { return addNameofDestinationTf.getText();}
    private final String getCountry() { return addCountryTf.getText();}
    private final String getRemoveName() { return removeNameofDestinatonTf.getText();}
    private final String getRemoveCountry() { return removeCountryTf.getText();}

    @FXML private void initialize() {
    destinationsBackgroundImg.setImage(new Image("/image/destination.png"));
}
//the user must click addDestinationBtn to add a country

    @FXML private void handleAddDestination() throws Exception {
        try {
            if (!getDestinations().hasDestination(getName(), getCountry())) {
            getDestinations().addDestination(new Destination(getName(), getCountry()));
        }
    }
        catch (Exception e) {
            System.out.println("error");
        }
    }
    

    @FXML private void handleRemoveDestination() throws Exception {
        try {
            if (getDestinations().hasDestination(getRemoveName(), getRemoveCountry())) {
            getDestinations().removeDestination(getDestinations().destination(getRemoveName(), getRemoveCountry()));
        }
    }
        catch (Exception e) {
            System.out.println("error");
        }
    }


    @FXML private void handleCloseAddDestinations() throws Exception {
        stage.close();

    }

    @FXML private void handleCloseRemoveDestinations() throws Exception {
        stage.close();
    }
        @FXML private void handleCloseRemoveFlights() throws Exception {
            stage.close();
    

    }
}