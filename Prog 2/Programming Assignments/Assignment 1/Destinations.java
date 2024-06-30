import java.util.LinkedList;

public class Destinations {

    private LinkedList<Destination> destinations;
    private Agency agency;

    public Destinations(Agency agency) {
        this.agency = agency;
        destinations = new LinkedList<Destination>();
        destinations.add(new Destination("Eiffel Tower", "France"));
        destinations.add(new Destination("Opera House", "Australia"));
        destinations.add(new Destination("Uluru", "Australia"));
        destinations.add(new Destination("Machu Picchu", "Peru"));
        destinations.add(new Destination("Great Pyramids", "Egypt"));
        destinations.add(new Destination("Niagara Falls", "Canada"));
        }
//add flights to destinations after destination
//

    public void DestMenu() {
      char destChoice;
    
      while (true) {

        destChoice = Utils.readChoice(
          "1. View All Destinations\n" +
          "2. View Destinations by Country\n" +
          "3. Add a Destination\n" +
          "4. Remove a Destination\n" +
          "X. Return to Main Menu\n" +
          "Please enter an option: ");

           if (destChoice == 'X') {
            System.out.println("Welcome to the Prog2 Travel Agency " + agency.getLoggedInUser().getName() +", Please make a selection from the menu:");
              //agency.use(); //issue is here if X has been input twice in a row, break...not really possible.
              break;
           }
           switch (destChoice) {
            case '1': printDestinationList(destinations); break;// "Explore Flights"
            case '2': lookupCountry();             break;
            case '3': addDestinations(); break;
            case '4': removeDestination(); break;
            default: System.out.println("Please enter a valid choice, or press X to exit.");
            break;
      }
      }
    }
    //Prompt the user to enter a country
    //prints the header
        public void lookupCountry() {
            String country;
           //read in an inpu
           do {
           country = readCountry();
           //check for all matches
           LinkedList<Destination> matches = getDestinationsByCountry(country);

        if (matches.size() == 0) {
        System.out.println("No matching destinations found.");

        }
        else {
            printDestinationList(matches);
            // Utils.destinationsHeader();
            //     for (Destination match: matches) {
            //             System.out.println(match);
            // }
            //     Utils.footer();
                break;
        }




           } while(true);
        }
        private LinkedList<Destination> getDestinationsByCountry(String country) {
            LinkedList<Destination> matches = new LinkedList<Destination>();
            for (Destination dests: destinations) {
                if (dests.getCountry().contains(country)) {
                matches.add(dests);
            }
        }
        return matches;
    }


    public void printDestinationList(LinkedList<Destination> destinations) {
     Utils.destinationsHeader();
        for (Destination dests: destinations){ 
            System.out.println(dests);
            } 
            Utils.footer(); 
    }
//call LinkedList

    public void printDestinationListForTrip(LinkedList<Destination> destinations) {
     Utils.tripHeader();
        for (Destination dests: destinations){ 
            System.out.println(dests);
           // System.out.println(agency.getFlights().getFlights());
            } 
            System.out.println("Total Cost: 0.0" );
            Utils.footer();
        
    }
           // if matches is 0
           // No matches found - ask for country again
           // else // more than 1
           // print header
            // for each match print out Destination
           // print footer

        
        //while(lookup(country) == null);}
        public Destination lookup(String country) {
            for (Destination lookup : destinations) {
                if (lookup.hasCountry(country)) {
                    return lookup;
                }
            }
            return null;
        }

        

  

    private String readCountry() {
      System.out.print("Country: ");
        return Utils.nextLine();

    }
    public LinkedList<Destination> getDestinations() {
        return destinations;
    }
    public void addDestination(Destination destination) {
        destinations.add(destination);
    }
    public void removeDestination(Destination destination) {
        destinations.remove(destination);
    }

    public void addDestinations() {
        //the user inputs a 


        String newPlace = readNameOfPlace();
        String newCountry = readCountry();
     //   LinkedList<Destination> matches = GetDestinationsByCountry(newPlace);
        //yes, you should add destinations if they don't exist.
       // if (hasDestination(newPlace, newCountry) == false) {
            destinations.add(new Destination(newPlace, newCountry));
            System.out.println("Destination added.");
        } 
                   
       // else {
          //  System.out.print("This Destination already exists");
        //}

    //goals, rewrite removeDestination()
    //add a linkedlist and match. if there is no match, prompt name and country again, 
    //if there is a match, remove the destination from the destination list

    //removeDestination()
    //prompt user to write "Name: " of destination followed by "Country: "
    //Use the linkedlist to check for matches. If matches found, remove the field which contains that place and country destination.
    //use a do while loop. 'do { code while(name, country is not matched)}, if matched, print "Destination removed" and exit'
        public void removeDestination() {
        String newPlace; 
        String newCountry;

        do {
            newPlace = readNameOfPlace();
            newCountry = readCountry();

            LinkedList<Destination> matchesRemoveDestinations = GetDestinationsByNameAndCountry(newPlace, newCountry);
        
        
        if (matchesRemoveDestinations.size() == 0) {
            System.out.println("No matching destinations found.");

        }
        else {
            for (Destination matched: matchesRemoveDestinations) {
           destinations.removeAll(matchesRemoveDestinations);//removeAll !!
            System.out.println("Destination removed.");
            break;
        }break;
        }
        }while(true);
    }
        private LinkedList<Destination> GetDestinationsByNameAndCountry(String name, String country) {
            LinkedList<Destination> matchesRemoveDestinations = new LinkedList<Destination>();
            for (Destination dests: destinations) {
                if (dests.getName().contains(name) && dests.getCountry().contains(country)) {
                matchesRemoveDestinations.add(dests);
            }
        }
        return matchesRemoveDestinations;
    }
    
        private String readNameOfPlace() {
            System.out.print("Name: ");
            return Utils.nextLine();
        }



    public boolean hasDestination(String name, String country) {
        return true;
    }


    public Destination lookup(String name, String country) {
         for (Destination lookup : destinations) {
             if (lookup.getCountry().contains(country) && lookup.getName().contains(name)) {
                return lookup;
             }
          }
          return null;
       }



   

}