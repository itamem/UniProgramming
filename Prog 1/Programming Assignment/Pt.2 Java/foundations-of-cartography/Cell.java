public class Cell {
	private boolean isHit;
	private boolean isAttack;
	private boolean occupy;
	private Segment segment;
	private boolean notHit;
	private Ship ship;
	//private boolean hit;
	//private boolean isEmpty;
	//private String empty;
	//private Segment segment;
	//private String cell;

	public Cell() {
		this.segment = null;
		this.isHit = false;
		//this.segment = segment;
		//this.cell = cell;
		//this.cell = new Cell();
		//for(int i = 0; i < cell.length; i++) {

	//	}
	}

	public void placeSegment(Segment segment) {
		 if (segment != null && this.occupy == false) {
			this.occupy = true;
			this.segment = segment;
			
		 }
		 else {
		return;
		 }
	}
	
	public void attack() {
		  isHit = true;
		  isAttack = true;
		  if (segment != null) {
			segment.attack();
		  }
		  return;
	}
	
	public boolean hasBeenHit() {
		if (isHit) {
			
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isOccupied() {
		if (this.occupy) {
		return true;
		}
		else {
			return false;
		}
	}

	public String displaySetup() {
		if (this.occupy == false) {
		return ".";
		}
	//ship.toString()
		else {
			return this.segment.toString();
		}
	}
	public String toString() {
		if (hasBeenHit() == false) {
		return ".";
		}
		else if 
			(hasBeenHit() == true && isOccupied() == false) {
			return "O";
		}
		else if 
			(hasBeenHit() == true && isOccupied() == true) {
			
			
			
			if (segment.getShip().sunk()) return this.segment.getShip().toString();
			}
		else {//wow
		
			
			return "X";
			}
		return "X";	
	}
	private boolean occupy() {
		return this.occupy;
	}

	//private boolean isEmpty() {
	//	this.isEmpty = isEmpty;
	}	
//}


