Boarding Action
Putting the Pieces on the Board
Now we have all the basic components of the game, we can get them to start interacting. This task will be to build the board that the game will be played on (the game play itself comes next). Naturally, we will model the board with a Board class.

The Starting Point
The scaffold contains the usual Runner, plus versions of Ship, Segment and Cell, so you don't need to build those again. Runner of course is just for your own testing purposes and does not form part of the task.

You will have to create four public classes this time, the Board class and three exceptions, InvalidPositionException, InvalidPlacementException and InvalidShipTypeException.

The Exceptions
We'll cover the exceptions first because they're simple. You do not need to implement any of the complicated functions of exceptions, and can rely on inheritance to do the work needed for this task. This of course means that when you create the three, they must inherit from the correct parent class. The obvious choice is the correct one here.

The Board in Battleship
Before we discuss the code component, we will outline how the board works in the game Battleship.

The board is a 10 x 10 grid of cells, with rows indexed by a letter from a to j and the columns indexed by a number 1 to 10. Ships are placed on the board, then the other player guesses positions to attack one at a time. If there is a ship there it's a hit, if all segments of a ship have been hit, the ship is sunk. If there is no ship there, it is a miss.

The Board Class
The main component of this task is the Board class. The Board class should use Cell, Ship and Segment to complete its task. Each position on the board should be represented by a Cell. It should have the following public methods:

A constructor that takes no parameters.

A method placeShip that takes a Ship, a starting position as a String and a String for the direction the ship should be placed, and returns nothing. To make things simple, the direction String should only be across or down. If the direction is neither of these, the method should throw an InvalidPlacementException. If the position is not on the board, the method should throw an InvalidPositionException, if the Ship is null, the method should throw an InvalidShipTypeException, if the ship cannot be place at that position in that orientation (either because it would run off the board, or overlap with another already placed ship), the method should throw an InvalidPlacementException. The method should take the Ship, and starting at the given position and moving in the given orientation, place the Segments of the ship in the Cells representing those positions. When placed, a ship should start at the given position and continue down if the direction is down or to the right if the direction is across.

A method attack that takes a position String, returns nothing and throws an InvalidPositionException if that position is not on the board. If it is on the board, it should hit that position, updating the Cell as appropriate.

A method hasBeenHit that takes a position String, and returns true if that position has been hit, and false if not. If the position is not on the board, it should throw an InvalidPositionException.

A toString method that overrides the standard toString and returns a String representing the current state of the board in play. Details on the appearance of the board are given below.

A displaySetup method that takes no parameters and returns a String representing the board in the setup phase of the game. This will be similar to toString, except it will openly display any ships and does not need to take into account any attacks.

You will need to add private fields to help you complete these methods, particularly a data structure that holds all the Cells in a way that you can take a position and get the correct Cell. 

Notice again that the position Strings should be a letter from a to j, and a number from 1 to 10 - you will likely need to convert this to a more code friendly format. Your code should handle both upper and lower case letters for the row.

You can also add other methods, but they should be private.

What Does the Board Look Like?
When converted to a String, the board should have the basic format:

  1 2 3 4 5 6 7 8 9 10
A . . . . . . . . . .
B . . . . . . . . . .
C . . . . . . . . . .
D . . . . . . . . . .
E . . . . . . . . . .
F . . . . . . . . . .
G . . . . . . . . . .
H . . . . . . . . . .
I . . . . . . . . . .
J . . . . . . . . . .

Notice in particular the spacing - the header row with the column numbers is indented slightly to line the numbers up with the columns, and there is a space between every element. Although the header row is one character longer than the rest, there is only a newline at the end of the other rows (no extra space at the end).

Here's the same board, but where spaces have been replaced by • and newlines have been replaced (sort of) by ↵:

••1•2•3•4•5•6•7•8•9•10↵
A•.•.•.•.•.•.•.•.•.•.↵
B•.•.•.•.•.•.•.•.•.•.↵
C•.•.•.•.•.•.•.•.•.•.↵
D•.•.•.•.•.•.•.•.•.•.↵
E•.•.•.•.•.•.•.•.•.•.↵
F•.•.•.•.•.•.•.•.•.•.↵
G•.•.•.•.•.•.•.•.•.•.↵
H•.•.•.•.•.•.•.•.•.•.↵
I•.•.•.•.•.•.•.•.•.•.↵
J•.•.•.•.•.•.•.•.•.•.↵

Once the board has been attacked, toString should show Os, Xs, and eventually when a ship has been sunk, the grid representation of that ship. An example would be:

  1 2 3 4 5 6 7 8 9 10
A . . . . . . . . . .
B . . . . . . . . . .
C . . . . . X O . . .
D . . . . . X . . . .
E . . . . . . . . . .
F . . . . . . . . . .
G . S S S O . . . . .
H . . . O . . . . . .
I . . . . . . . . . .
J . . . . . . . . . .

Here there are few hits and misses, and a sunken submarine.

displaySetup follows the same format, however it always simply displays whatever ships are present, and does not display hit/miss information.

FAQ
As with other parts, the FAQ is on the next slide. Usual rules apply.