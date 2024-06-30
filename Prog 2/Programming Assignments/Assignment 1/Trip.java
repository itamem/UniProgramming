
public class Trip {

    private Flights flights;
    private Destinations destinations;
    private Agency agency;

    public Trip(Agency agency) {
        this.agency = agency;
        flights = new Flights(agency);
        destinations = new Destinations(agency);
        this.destinations.getDestinations().clear();
        this.flights.getFlights().clear();
    }
//access agency to access flights?
//access agency to access destinations?
    public void tripMenu() {
        char tripChoice;

        while (true) {
            tripChoice = Utils.readChoice(
                "1. Add a Destination\n"+
                "2. Remove a Destination\n"+
                "3. Add Connecting Flights\n" +
                "4. View Trip Details\n"+
                "X. Return to Main Menu\n"+
                "Please enter an option: "
            );

            if (tripChoice == 'X') {
                System.out.println("Welcome to the Prog2 Travel Agency " + agency.getLoggedInUser().getName() +", Please make a selection from the menu:");
                break;
            }

            switch (tripChoice) {
                case '1': addDestination(); break;
                case '2': destinations.removeDestination(); break;
                case '3': Connectingflights(); break;
                case '4': tripView(); break;
                default: System.out.println("Please enter a valid choice, or press X to exit.");
            }
        }
    }    

   private void addDestination() {
    String nameOfPlace;
    String country;
    do {    

    //lookup information from agency's list
    //clear the destinations list of trip and add a destination if the lookup agency's list is not null
    //how exactly can I lookup the agency's list
    //user clicks "Add a Destination"
    nameOfPlace = readNameOfPlace();
    country = readCountry();
    //sys prompts Name:
    //sys prompts Country:
    //use a getter
     if (agency.getDestinations().lookup(nameOfPlace, country)!= null) { //&& agency.getCountry().lookup(country).equals(country)) {
         System.out.print("Destination added.\n");
         this.destinations.getDestinations().add(new Destination(nameOfPlace, country));
         //System.out.print(this.destinations.getDestinations()+"\n");
         break;
     }
     else {
         
         //destinations.addDestination(new Destination(nameOfPlace, country));
         System.out.print("No such destination in the agency.\n");
    }
    //lookup(nameOfPlace).equals(destinations.getName()) && 
    //sys checks if name and country exist in getDestinations()
    //getDestinations() is how you access the list in destinations.
    //if name and country dont exist,-> print No such dest...
    //if name and country exist, add to the the list(1)
    //the way you add by the list could be by:
    //destinations.getDestinations.add(...)
    //after that, print "dest added" and break
    }
    while(true);
}
//print whatever that's matched which is not 
//if lookup contains country, print out that country
    private void tripView() {
    Utils.tripHeader();
    if (this.flights.getFlights().size() == 0) {
     // this.destinations.printDestinationListForTrip(this.destinations.getDestinations());
        for (Destination dests: this.destinations.getDestinations()) {
        System.out.println(dests);
     }System.out.println("Total Cost: 0.0");
    }
    else {
        // for (Destination dests: this.destinations.getDestinations()) {
        //     System.out.print(dests +"\n");
        
        for (int i = 0; i < this.destinations.getDestinations().size(); i++) {
         //we want to print out the flights which contain the takeoff and landing from the list
         System.out.print(this.destinations.getDestinations().get(i)+ "\n");
        
        if (i !=this.flights.getFlights().size()) {
            System.out.print(this.flights.getFlights().get(i)+ "\n");
        }
        

}System.out.println("Total Cost: " + String.format("%.2f", cost()));
       }

        
     Utils.footer();
      // public void printDestinationListForTrip(LinkedList<Destinations> destinations) {
    //  Utils.tripHeader();
    //      for (Destination dests: agency.getDestinations().getDestinations()){ 
    //         System.out.println(dests);
    
             } 
    //         System.out.println("Total Cost: 0.0" );
    //     Utils.footer(); 
     


    // System.out.println("Total Cost: 0.0" );
    // Utils.footer(); 
    //if case 3 happens, 
    //and then case 4 happens afterwards
    //case 4

//(1)User adds two destinations
//(2)User adds connecting flights associated with those destinations
//(3)current destination A landing matches next destination B takeoff

//HOW TO DO (3):
//

//how to refer to current destination A?
//look into the trips destination list, and then if the countries in the trips destinations list contains
//the landing country flights agency list matches takeoff country of 

        //if (flights.matchFlightsByTakeoffAndLanding.size() == 1)
            //


//iterate through added destinations list
//checking if they have a matching flight between them


    //print "Connecting flights added"
    //add flights to the this.destinations list and connect 2 countrys that have been inputted
    //ONLY add flights if more than 1 destinations has been added
    //i.e. if Uluru country destination added
    //just do tripview(); --NO YOU DON'T
    //if landing matches with takeoff
    private void Connectingflights() {
        this.flights.getFlights().clear();
        //CLEAR THE FLIGHTS LIST
        /*<retrieve the list>.clear()
            OR
        flights = <a new instance of flights>*/
        
        System.out.print("Connecting flights added.\n");
        String potentialTakeoff;
        String potentialLanding;
        
//iterate through the trips destinations list,
//iterate through agencys flights list,
//look for a flight which contains the first destination(potential takeoff country) and the- 
//-second destination(potential landing country)
//if flight is found, addFlight() to trips flights list, and then print out trips flights list
//in between two destinations, likely with a for loop ++2?

       for (int i = 0; i < this.destinations.getDestinations().size()-1; i++) {
        potentialTakeoff = this.destinations.getDestinations().get(i).getCountry();
        potentialLanding = this.destinations.getDestinations().get(i+1).getCountry();
         //if(agency.getFlights().matchFlightsByTakeoffAndLanding(potentialTakeoff, potentialLanding) != null) {
             for (Flight fl: agency.getFlights().getFlights()) {
             if(fl.getTakeoff().contains(potentialTakeoff) && fl.getLanding().contains(potentialLanding)) {
                this.flights.getFlights().add(fl);
               // this.flights.addFlight();
                
        
      }
            
    }        
            
            }
            
        

     }

    private String readNameOfPlace() {
    System.out.print("Name: ");
    return Utils.nextLine();
   }

    private String readCountry() {
    System.out.print("Country: ");
    return Utils.nextLine();
   }

    

   private double cost() {
        double sum = 0;
        for (Flight fly: this.flights.getFlights()) {
             sum += fly.getCost();
        }
        return sum; 
   }
}
    
