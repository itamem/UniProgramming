public class Board {
    private Ship ship;
    private String startPos;
    private String directionPlacement;
    private String across;
    private String down;
    private Board board;
    private String a1; 
    private String [][] map = new String[10][10];
    
    public Board() {
        this.ship = ship;
        this.startPos = startPos;
        this.directionPlacement = directionPlacement;
        this.across = "across";
        this.down = "down";
        String pos = "a1";
        this.map = map;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                map[i][j] = pos;
               pos = this.adder(pos);
            }
            int num1 = 1;
            char c =pos.charAt(0); 
            c++;              
            pos = c + Integer.toString(num1);
        }
        
    }

    public void placeShip(Ship ship, String startPosition, String directionPlacement) throws InvalidPlacementException, InvalidPositionException, InvalidShipTypeException {
        if (directionPlacement != this.across && directionPlacement != this.down) {
            throw new InvalidPlacementException();
        }
         else if (check(startPosition) == false)  {
                 throw new InvalidPositionException();
         }
         else if (ship == null) {
                throw new InvalidShipTypeException();
            }
            else {
                return;
            }
        }
    public void attack(String position) throws InvalidPositionException {

    }
    public boolean hasBeenHit(String position) throws InvalidPositionException {
        return true;
    }
    @Override
    public String toString() {
        return "";
    }
     public String displaySetup() {
        String board = "  1 2 3 4 5 6 7 8 9 10" + "\n";
        char r = 'A';
        
        for (int i = 0; i < 10; i++) {
         board += r + " "; 
            for (int j = 0; j < 10; j++) {
               board += " .";
            }
            r++;
            board += "\n";
             
       
       
       
     }
      return board.trim();
     }


    private String adder(String add) {
        add ="a1";
        String[] part = add.split("(?<=\\D)(?=\\d)"); 
        int num1 = Integer.parseInt(part[1]);
        char c =add.charAt(0);
        num1++;
        String comb = c + Integer.toString(num1);
        return comb;
    } 
    private boolean check(String checker) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == checker) {
                    return true;
                }
            }
        }
        return false;
        

 }

    
}

class InvalidPositionException extends Exception{} 
class InvalidPlacementException extends Exception{}
class InvalidShipTypeException extends Exception{}
