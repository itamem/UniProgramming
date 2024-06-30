package controller.Error;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
// import model.Exceptions.ErrorModel;

public class ErrorController extends Controller<model.Exceptions.ErrorModel>{
    @FXML ImageView errorBackgroundImg;
    @FXML Button closeBtn;
    @FXML Label exceptionLbl;
    @FXML Label exceptionMsgLbl;

    private final Exception getException() {
        return model;
    }

    @FXML private void initialize() {
        errorBackgroundImg.setImage(new Image("/image/error.png"));
        // exceptionLbl.setText(getException().asString());
        exceptionMsgLbl.setText(getException().getMessage());
        // errorBackgroundImg.prefWidth(250.0);
        // errorBackgroundImg.prefHeight(300.0);
    }

    @FXML private void handleClose() {
        stage.close();
    }
}
