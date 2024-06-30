import java.util.LinkedList;
import java.text.*;

public class Agency {

    private Administrator loggedInUser;
    private Destinations destinations;
    private Flights flights;
    private Administrators admins;

    public static void main(String[] args) {
      Agency agency = new Agency();
         agency.login();
         agency.use();
        
    }

    public Agency() {
      destinations = new Destinations(this);
      flights = new Flights(this);
      admins = new Administrators();
     // loggedInUser = new Administrator("","","");
   //  this.loggedInUser = loggedInUser;
      
    }

    public void login() {
      String user;// = readUser();
      String pass;// = readPass();
     // Administrator loggedInUser;
      
      do {
        user = readUser();
        pass = readPass();

      this.loggedInUser = admins.lookup(user, pass);
     // loggedInUser = admins.lookup(user, pass);
     // admins.lookup(user, pass).getName(); 
      if (admins.lookup(user, pass) == null ||!admins.lookup(user, pass).hasLoginDetails(user, pass)) {
       // if (lookup(user, pass).hasLoginDetails(user, pass) = true) {
         // if (admins.hasLoginDetails(user, pass)) {
          System.out.println("Invalid Credentials! Try Again.");
      }
      else {
        System.out.println("Welcome to the Prog2 Travel Agency " + loggedInUser.getName() + ", Please make a selection from the menu:");
        break;
      }
    }

    while (true);//
    
    //  System.out.println("ok let's begin");
    }//now we need to useLoggedInUser

   
    private String readUser() {
      System.out.print("Username: ");
        return Utils.nextLine();
    }
    private String readPass() {
      System.out.print("Password: ");
        return Utils.nextLine();
    }
    public Administrator getLoggedInUser() {
      return loggedInUser;
    }

    public void use() {
        char choice;

       while(true) {

        choice = Utils.readChoice 
                  ("1. Explore Flights\n" +
                  "2. Explore Destinations\n" +
                  "3. Book a Trip\n" +
                  "X. Exit the System\n" +
                  "Please enter an option: ");

         if (choice == 'X') {
            System.out.println("Thanks for using the Prog2 Travel Agency.");
            break;
         }

            switch (choice) {
            case '1': System.out.println("Welcome to the Flights section " + this.loggedInUser.getName() +", Please make a selection from the menu:"); flights.FlightMenu(); break;
            case '2': System.out.println("Welcome to the Destinations section " + this.loggedInUser.getName() +", Please make a selection from the menu:"); destinations.DestMenu(); break;
            case '3': System.out.println("Welcome to the Trips section! Please make a selection from the menu:"); new Trip(this).tripMenu(); break;
            default: System.out.println("Please enter a valid choice, or press X to exit."); break; //"Choose a valid option"
            
        }  
    } while (choice != 'X');
}


    public Flights getFlights() {
      return flights;
    }

    public Destinations getDestinations() {
      return destinations;
    }

  
}