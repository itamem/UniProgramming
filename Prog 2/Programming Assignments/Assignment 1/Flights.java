import java.util.InputMismatchException;
import java.util.LinkedList;

public class Flights {
    private LinkedList<Flight> flights;
    private Agency agency;

    public Flights(Agency agency) {
      this.agency = agency;
      flights = new LinkedList<Flight>();
      flights.add(new Flight("American Airlines", 575, "Canada", "France", 826.58));
       flights.add(new Flight("JetStar", 453,"France", "Canada", 417.91));
       flights.add(new Flight("United Airlines", 339, "Egypt", "France", 911.92));
       flights.add(new Flight("Etihad", 642, "France", "Egypt", 8.29));
       flights.add(new Flight("British Air", 368, "Australia", "France", 841.37));
       flights.add(new Flight("American Airlines", 162, "France", "Australia", 396.26));
       flights.add(new Flight("JetStar", 372, "Peru", "France", 636.65));
       flights.add(new Flight("United Airlines", 687, "France", "Peru", 779.25));
       flights.add(new Flight("Etihad", 905, "Canada", "Australia", 454.54));
       flights.add(new Flight("British Air", 311, "Australia", "Canada", 415.68));
       flights.add(new Flight("American Airlines", 739, "Egypt", "Australia", 611.49));
       flights.add(new Flight("JetStar", 829, "Australia", "Egypt", 420.67));
       flights.add(new Flight("United Airlines", 634, "Peru", "Australia", 491.86));
       flights.add(new Flight("Etihad", 885, "Australia", "Peru", 548.23));
       flights.add(new Flight("British Air", 967, "Canada", "Peru", 736.12));
       flights.add(new Flight("American Airlines", 130, "Peru", "Canada", 530.05));
       flights.add(new Flight("JetStar", 166, "Egypt", "Peru", 299.32));
       flights.add(new Flight("United Airlines", 208, "Peru", "Egypt", 641.98));
       flights.add(new Flight("Etihad", 860, "Canada", "Egypt", 672.90));
       flights.add(new Flight("British Air", 325, "Egypt", "Canada", 806.92));

    }

    public void FlightMenu() {
      char flightChoice;

      while (true) {
        flightChoice = Utils.readChoice(
          "1. View All Flights\n" +
          "2. View Flights by Country\n" +
          "3. Add a Flight\n" +
          "4. Remove a Flight\n" +
          "X. Return to Main Menu\n" +
          "Please enter an option: "
        );

        if (flightChoice == 'X') {
          System.out.println("Welcome to the Prog2 Travel Agency " + agency.getLoggedInUser().getName() +", Please make a selection from the menu:");
          break;
        }
        switch (flightChoice) {
          case '1': printFlightList(flights); break;
          case '2': lookupCountryFlights(); break;
          case '3': addFlight(); break;
          case '4': removeFlight(); break;
          default: System.out.println("Please enter a valid choice, or press X to exit.");
          break;
        }

      }
    }
    //flights list:
    //print flights header flightsHeader(), and then 
    //iterate over flight list via for each loop.
    //print footer

    private void printFlightList(LinkedList<Flight> flights) {
      Utils.flightsHeader();
        for (Flight flight: flights) {
          System.out.println(flight.toString());
        }
        Utils.footer();
    }

        private void lookupCountryFlights() {
          //prompt user to Type country
          String country;

          do {
            country = readCountry();

            LinkedList<Flight> matches = getFlightsByCountry(country);

            if (matches.size() == 0) {
              System.out.println("No matching flights.");
              break;
            }
            else {
              printFlightList(matches);
              break;
            }
          } while(true);
        }
        // By using a matches list, check if matches is 0
        // No matches found - break; and print flightmenu
        // else // matches == 1
        
        //Use printFlightList()| for each match print out flights by using printFlightList
        


    private LinkedList<Flight> getFlightsByCountry(String country) {
      LinkedList<Flight> matchesFlights = new LinkedList<Flight>();
      for (Flight fl: flights) {
        if (fl.getTakeoff().contains(country) || fl.getLanding().contains(country)) {
          matchesFlights.add(fl);
      }
     }
    return matchesFlights;
    }

    private String readCountry() {
      System.out.print("Country: ");
        return Utils.nextLine();
    }
    public LinkedList<Flight> getFlights() {
      return flights;
    }

    public void addFlight(Flight flight) {
      flights.add(flight);
    }

    public void removeFlight(Flight flight) {
      flights.remove(flight);
    }

    public void addFlight() {
  //String airline, int flightNo, String takeoff, String landing, double cost
      String newAirline; 
      int newFlightNo; 
      String newTakeoff; 
      String newLanding; 
      double newCost;

      //type in all the lines of code
      do {
        newAirline = readNameOfAirline();
        newFlightNo = readFlightNumber();
        newTakeoff = readNameOfTakeoffCountry();
        newLanding = readNameOfLandingCountry();
       // newCost = Utils.nextDouble();

     //  LinkedList<Flight> CheckIfFlightMatchedBeforeCostInput = GetFlightsByAirlineFlyNoToffAndLandWithoutCost(newAirline, newFlightNo, newTakeoff, newLanding);
       LinkedList<Flight> matchedFlightsByTakeoffAndLanding = matchFlightsByTakeoffAndLanding(newTakeoff, newLanding);

      
      if (matchedFlightsByTakeoffAndLanding.size() == 1){
        System.out.print("This flight already exists.\n");  
        
      }
      else {
        try {
          newCost = readCost();
        } catch (InputMismatchException ok) {
          System.out.print("Invalid input.\n");
          Utils.clearConsole();
          continue;
        }
        flights.add(new Flight(newAirline, newFlightNo, newTakeoff, newLanding, newCost));
        System.out.print("Flight added.\n");
        break;
        // FlightMenu();
      }

      
        

      }while (true);
      }
    
    public LinkedList<Flight> matchFlightsByTakeoffAndLanding(String takeoff, String landing) {
        LinkedList<Flight> matchedFlightsByTakeoffAndLanding = new LinkedList<Flight>();
        for (Flight flys: flights) {
          // System.out.println(takeoff + flys.getTakeoff());
          // System.out.println(landing + flys.getLanding());
          if (flys.getTakeoff().contains(takeoff) && flys.getLanding().contains(landing)) {
          matchedFlightsByTakeoffAndLanding.add(flys);
        }
    }
    return matchedFlightsByTakeoffAndLanding;
  }
    private LinkedList<Flight> getFlightsByAirlineFlyNoToffLandAndCost(String airline, int flightno, String takeoff, String landing, double cost) {
        LinkedList<Flight> nonMatchedFlights = new LinkedList<Flight>();
        for (Flight flys: flights) {
          if (flys.getAirline().contains(airline) && flys.getFlightNo() == (flightno) && flys.getTakeoff().contains(takeoff) && flys.getLanding().contains(landing) && flys.getCost() == (cost)) {
          nonMatchedFlights.add(flys);
        }
    }
    return nonMatchedFlights;
  }
   private LinkedList<Flight> getFlightsByAirlineFlyNoToffAndLandWithoutCost(String airline, int flightno, String takeoff, String landing) {
        LinkedList<Flight> checkIfFlightMatchedBeforeCostInput = new LinkedList<Flight>();
        for (Flight flys: flights) {
          if (flys.getAirline().contains(airline) && flys.getFlightNo() == (flightno) && flys.getTakeoff().contains(takeoff) && flys.getLanding().contains(landing)) {
          checkIfFlightMatchedBeforeCostInput.add(flys);
        }
    }
    return checkIfFlightMatchedBeforeCostInput;
  }

  public void removeFlight() {
    String potTakeoff;
    String potLanding;
    
    //Prompt user to type in takeoff country
    //prompt user to type in landing Country
    //if match.size() = 0, print "no matching flight found"
    //else (flight.toString removed)
    do {

    potTakeoff = readNameOfTakeoffCountry();
    potLanding = readNameOfLandingCountry();
    LinkedList<Flight> matchedFlightsByTakeoffAndLanding = matchFlightsByTakeoffAndLanding(potTakeoff, potLanding);
    
 

    if (matchedFlightsByTakeoffAndLanding.size() == 0) {
      System.out.print("No matching flight found.\n");
      continue;
    }
    else {
      for (Flight matched: matchedFlightsByTakeoffAndLanding) {
        flights.removeAll(matchedFlightsByTakeoffAndLanding);
        System.out.println(matched.toString() + " removed.");
      }
    }break;
    }while(true);
  }

    public boolean hasFlight(String takeoff, String landing) {
      return true;
      }
      // hasFlight.equals(getTakeoff, getLanding);
    private String readNameOfAirline() {
      System.out.print("Airline: ");
      return Utils.nextLine();
    }

    private int readFlightNumber() {
      System.out.print("Flight Number: ");
      return Utils.nextInt();
    }

    private String readNameOfTakeoffCountry() {
      System.out.print("Takeoff: ");
      return Utils.nextLine();
    }

    private String readNameOfLandingCountry() {
      System.out.print("Landing: ");
      return Utils.nextLine();
    }
    private double readCost() {
      System.out.print("Cost: ");
      return Utils.nextDouble();
    }
    public LinkedList<Flight> tripMatchFlightsByTakeoffAndLanding() {
      LinkedList<Flight> matchedTripFlightsByTakeoffAndLanding = new LinkedList<Flight>();
        for (Flight flys: flights) {
          // System.out.println(flys.getTakeoff());
           //System.out.println(flys.getLanding());
           if (flys.getTakeoff().equals(flys.getLanding())) { //&& (flight).contains(flys.getTakeoff().equals(flys.getLanding())))) {
           matchedTripFlightsByTakeoffAndLanding.add(flys);
         }
     }
     return matchedTripFlightsByTakeoffAndLanding;
   }

  //create a matches method to check if a flight exists
  //if flight does not exist, add flight.
}
