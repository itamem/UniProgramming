public class Ship {
    // #1 we have a type for the Ship
    // #2 we have a name for the Ship
    // #3 we have a length(size) for the Ship
    // #4 we have a grid for the ship
    // #5
    private String type;
    private String name;
    private int length;
    private String grid;
    private Segment[] segments;
    private boolean isSunk;
    //private char hit;
    
   // private Ship(char hit) {
    //    this.hit = hit;
    //}
//#1(COMP) private constructor, type string, representing the type of the ship
    private Ship(String type) {
        this.type = type;
        this.isSunk = isSunk;
        this.segments = new Segment[length()];//pass in a shipobj
        //segments[0] = battleship.length;
       // Segment[] segments = {battleship,carrier,destroyer,submarine,patrolboat};
        for (int i = 0; i < length(); i++) {
           segments[i] = new Segment(this);
       


        //segments[0] = battleship.length();
        // segments[1] = carrier.length();
         //segments[2] = destroyer.length();
        // segments[3] = submarine.length();
        // segments[4] = patrol boat.length();
      
      }
    }
    
    
//#2 public method, type int, representing the length
//of the ship. No paras, returns the number of segments in that ship
//what is segements???
    public int length() {

        switch (this.type) {
            case "battleship":
                this.length = 4;
                break;//yes correct
            case "carrier":
                this.length = 5;
                break;
            case "destroyer":
                this.length = 3;
                break;
            case "submarine":
                this.length = 3;
                break;
            case "patrol boat":
                this.length = 2;
                break;
            default:
                break;
        }
        return length; 
    }
    // #3
    public String name() {
        switch (this.type) {
            case "battleship":
                this.name = "Battleship";
                break;
            case "carrier":
                this.name = "Carrier";
                break;
            case "destroyer":
                this.name = "Destroyer";
                break;
            case "submarine":
                this.name = "Submarine";
                break;
            case "patrol boat":
                this.name = "Patrol Boat";
                break;
            default:
            break;
        }
        return this.name; 
    }
    public boolean sunk() {// SKIP AND COME BACK AFTER DOING STEP 2 OF THE SEGMENT
      
         for (Segment boom: segments) {
           if (boom.hit() == false) {
               return false;
           }
         
        else {
        
       }
    }
        return true;
    }
    public String toString() {
        switch (type) {
            case "battleship":
                this.grid = "B";
                break;
            case "carrier":
                this.grid = "C";
                break;
            case "destroyer":
                this.grid = "D";
                break;
            case "submarine":
                this.grid = "S";
                break;
            case "patrol boat":
                this.grid = "P";
                break;
            default:
                break;
        }
        return this.grid;
    }
    public Segment getSegment(int segPos) {
      //Segment[] segments = new Segment[length()];
      int i = 1;
      if (i <= segPos  && segPos <= this.length) {
        return segments[(segPos - 1)]; //segments is null
      }
            

         //   segments[i] = new Segment();
        //}
      //Segment battleship = new Segment(4);
      //Segment carrier = new Segment(5);
      //Segment destoryer = new Segment(3);
      //Segment submarine = new Segment(3);

    else {
      return null;
    }

     

          
    
        //for (int i = 0; i < Ship.length; i++) {

        
    }
     public static Ship createShip(String type) {
        type = type.toLowerCase();
        switch (type) {
        case "battleship", "carrier", "destroyer","submarine","patrol boat":
            return new Ship(type.toLowerCase());
        default:
            return null;
        }   
    }
}


