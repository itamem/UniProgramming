public class Segment {
   private Ship ship;
   private boolean isHit;
   
    //?
   public Segment(Ship ship) {
      this.ship = ship;
   }
   public boolean hit() {
    if (isHit) {
      return true;
    }
      else {
         return false;
      }
   }
   public void attack() {
      isHit = true;
         return;
      
   } 
   public Ship getShip() {
      return this.ship;
   }
   public String toString() {
      return ship.toString();
   }
}

