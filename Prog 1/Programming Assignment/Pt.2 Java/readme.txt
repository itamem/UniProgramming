Foundations of Cartography
A Grid Cell
As you know (if you don't, go back and read the wikipedia page linked in the first task), the Battleship game board is made of "grid squares", and play proceeds by "attacking" those locations. To model this, we're going to create a Cell class which will hold a Segment of a Ship. When these are put together in a grid, they will make the board (the next part).

The Starting Point
The scaffold contains a Runner class plus a version of Ship and Segment from the previous task. If you like, you can use your solutions from the previous task, but you do not need to. Runner is to facilitate you running any test/debugging code you need to complete the task, however it is not part of the tests.

You will have to create the class Cell to begin with. It should be public.

The Cell Class
Class should have the following methods:

A public constructor that takes no parameters.

A public method placeSegment that takes a Segment as a parameter and returns nothing. If this Cell is not occupied, it should place the segment in the cell, otherwise it does nothing.

A public method attack that takes no parameters and returns nothing. This method should record that this Cell has been hit, and also attack any Segment at the Cell.

A public method hasBeenHit that takes no parameters and returns true if the Cell has been hit and false if it hasn't.

A public method isOccupied that takes no parameters and returns true if there is a Segment at this Cell and false if not.

A public method displaySetup that takes no parameters and returns a String. This method will later assist in the setup stage of the game. It should return "." if there's no Segment at this Cell, and the grid representation String of the associated Ship if there is a Segment of a Ship present.

A public method toString that returns a String and overrides the inherited toString. It should return "." if the Cell has not been hit, "O" (capital o) if the Cell has been hit and there's no Segment, "X" (capital x) if the Cell has been hit and there is a Segment present, but the associated Ship has not yet been sunk, and the grid representation of the Ship otherwise.

To this you will need to add suitable fields to store information the Cell needs to function. You can also add other methods if you find them useful. All of these should be private.

FAQ
An FAQ thread for this section of the assignment can be found on the next slide.