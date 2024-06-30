package controller;

import java.io.IOException;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Administrators;
import model.Agency;
import model.Exceptions.ErrorModel;
import model.*;

public class LoginController extends Controller<Agency> {
    private Administrators administrators = new Administrators();
    // private Administrator  loggedInUser;
    @FXML private TextField usernameTf;
    @FXML private PasswordField passwordPf;
    @FXML private Button loginBtn;
    @FXML private Button exitBtn;
    @FXML private Label nameLbl;
    // @FXML private Text authTxt;

    public final Agency getAgency() {
        return model;
    }

    public final Administrators getAdministrators() { return administrators;}
    private final String getUsername() { return usernameTf.getText();}
    private final String getPassword() { return passwordPf.getText();}
    // private final void setUsername(String login) { usernameTf.setText(""+login);}
    
    
    @FXML private void initialize() {
        // nameLbl.textProperty().bind(getAgency().getLoggedInUser().getName().asString());   
    }
    @FXML private void handleLogin() throws IOException {
        // Agency agency = new Agency();
        //admins = getAgency.getAdministrators()
        try {  
            getAgency().getAdministrators().hasAdministrator(getUsername(), getPassword()); 
            getAgency().setLoggedInUser(getAgency().getAdministrators().getAdministrator(getUsername(), getPassword()));
            stage.close();
            Stage agencyStage = new Stage();
            agencyStage.getIcons().add(new Image("/image/agency_icon.png"));
            ViewLoader.showStage(getAgency(), "/view/AgencyView.fxml", "Prog2 Travel Agency", agencyStage);
        }
        catch(Exception e) {
            ErrorModel errorModel = new ErrorModel(e,"Incorrect Login Information");
            ViewLoader.showErrorWindow(errorModel);
           
            // ViewLoader.showStage(get(), "/view/AgencyView.fxml", "Prog2 Travel Agency", loginErrorStage)
        }
        // finally {
        //     stage.close();
        // }
        //output viewLoader...
        //else System.out.print("error")--> meant to be an error window...
        
        // ViewLoader.showStage(getAgency(), "/view/AgencyView.fxml", "Prog2 Travel Agency", agencyStage);
    }
    //  private ErrorModel getException() {
    //     return model.Exception;
    // }

    @FXML private void handleExitLogin() throws Exception {
        stage.close();
     }

    // @FXML private void initialize() {
        // usernameTf.textProperty().bind(administrator.getUsername())
    
        // question: how exctly can I call the administrator class/method when it requires arguments. Am I meant to set the usernameTf and passwordPf to a string?
    
    // @FXML private void handleLogin(ActionEvent event) {
    //     administrators.getAdministrator(login, )
    //     if (administrators.getAdministrator(login, password).getLogin().equals(usernameTf) &&
    //     administrators.getAdministrator().getPassword().equals(passwordPf))
    //     System.out.println("yes");
    // }
    // else {
    //     System.out.println("no");
    // }
    //     admins = getAdministrators();
    //     if (admins.hasAdministrator(usernameTf && passwordPf))
    //         admins
    // }
}
