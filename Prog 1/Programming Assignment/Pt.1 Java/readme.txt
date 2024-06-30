Working in the Shipyards
Ships and Segments
For the first part of the assignment, we'll build two classes in Java that will together represent a ship in our game of Battleship - the classes Ship and Segment. Although it will become clearer later, a Ship represents the ship as a whole, and Segment represents a part of the ship at a particularly location on the grid.

The Starting Point
The scaffold contains a Runner class, and nothing else. Runner is to facilitate you running any test/debugging code you need to complete the task, however it is not part of the tests.

You will have to create the two classes Ship and Segment to begin with. They should both be public classes.

The Ship Class
Ship should have the following methods:

A private constructor that takes a single String parameter representing the type of the Ship to be created.

A public length method that takes no parameters and returns the number of segments in that Ship.

A public name method that takes no parameters and returns the name of the type of Ship.

A public sunk method that takes no parameters and returns true only when all Segments of the Ship have been hit.

A public toString method that overrides the standard toString method, returning the representation of that ship type to be used in the grid later on.

A public getSegment method that takes an integer from 1 to the length of the Ship inclusive and returns the Segment corresponding to that position. If the segment number is invalid, the method should return null.

A public static createShip method that takes a single String parameter representing the type of ship to be created and returns a Ship object that fulfils the requirements of that type. If the argument passed to the method is not a type of ship, the method should return null.

To this you will need to add fields (data members) to store suitable information to make the class work. You may also add other methods if you find it necessary, but these, and all fields, should be private.

Ship Types
There are five types of ship, with the following characteristics:
Type	Name	Length	Grid Repr.
battleship	Battleship	4	B
carrier	Carrier	5	C
destroyer	Destroyer	3	D
submarine	Submarine	3	S
patrol boat	Patrol Boat	2	P


Each ship should have the same number of Segments as its length. Any code handling the type should account for different capitalisations of the word(s). Both the name and grid representation should be capitalised exactly as written.

The Segment Class
The Segment class represents a segment of a Ship, and will be useful in later tasks in placing the ship on the game grid and in keeping track of which parts of the ship have been hit.

Segment should have the following methods:

A public constructor that takes a single parameter of type Ship that is the Ship the Segment belongs to.

A public hit method that takes no parameters and returns a boolean indicating whether the Segment has been hit or not.

A public attack method that takes no parameters and returns nothing, and "hits" the Segment.

A public getShip method that takes no parameters and returns the Ship that the Segment belongs to.

A public toString method that overrides the standard toString method and returns the grid representation of the ship type the Segment belongs to.

As with Ship, you will need to add fields to keep track of the various data that need to be tracked. These fields should be private. You may also add other methods, but these should also be private.

FAQ
An FAQ thread for this section of the assignment can be found on the next slide.