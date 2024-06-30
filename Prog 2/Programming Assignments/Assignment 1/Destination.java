
    //lookup(nameOfPlace).equals(destinations.getName()) && 
    //sys checks if name and country exist in getDestinations()
    //getDestinations() is how you access the list in destinations.
    public class Destination {
        private String country;
        private String name;
    
        public Destination(String name, String country) {
           this.name = name;
           this.country = country;
        }
        public String getName() {
          return this.name;
        }
        
        public String getCountry() {
          return this.country;
        }
    
        public boolean hasCountry(String country) {
          return country.equals(this.country);
        }
    
        public boolean hasName(String name) {
          return name.equals(this.name);
        }
    
       //print out Should print out the information
        // of the flight in the following format:
        //{destination name} in {country}
        //Example: Eiffel Tower in France
        @Override
        public String toString() {
          return name + " in " + country;
        }
       
    }