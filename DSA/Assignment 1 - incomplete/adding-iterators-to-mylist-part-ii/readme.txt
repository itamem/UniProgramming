Adding Iterators to MyList (part II)
This challenge continues to build on MyList by adding functionality for iterators.  This part is worth 6 points out of the 20 points for Assignment 1.  All the member functions from part I are here again, you can begin by copying your code for these member functions from part I to this part.  

We add iterator functionality by adding an Iterator class inside MyList.  This will let us implement several other features present in a std::list, for example:

Use range based for loops.

Add an insert member function, to insert a value before the Node pointed to by an iterator

Add an erase member function, to erase the value at a Node pointed to by an iterator.

The interface for the Iterator class looks as follows.

   class Iterator {
    // useful reference
    // https://www.internalpointers.com/post/writing-custom-iterators-modern-cpp
   private: 
    Node* current_;

   public:
    // construct an Iterator from a pointer to a Node
    Iterator(Node*); 
    // advance an iterator to the next Node (pre-increment)
    Iterator& operator++();
    // Move iterator to previous Node (pre-decrement)
    Iterator& operator--();
    // return value at the node pointed to by the iterator
    T& operator*() const;

    // test if two iterators are equal
    friend bool operator==(const Iterator& a, const Iterator& b) {
      return a.current_ == b.current_;
    }
    // test if two iterators are not equal
    friend bool operator!=(const Iterator& a, const Iterator& b) {
      return not (a == b);
    }
  };

You are to implement the constructor, pre-increment, pre-decrement, and dereferencing functions in the Iterator class.  We implement the functions comparing two iterators for you.  

Now that we have iterators, we can also add more member functions to MyList to bring its functionality closer to std::list.  Specifically we will add the insert and erase functions and the begin and end functions (which return an iterator).  Your MyList should also implement all of the member functions from the first part of the assignment.

Insert/Erase
These functions should work in constant time.

  // add an element to the list before the node pointed to by the Iterator
  void insert(const Iterator&, const T&);
  // remove the element of the list pointed to by the Iterator
  void erase(const Iterator&);
Begin and End
  // return an Iterator pointing to the first element
  Iterator begin() const;
  // return an Iterator that does not point to any element in the list.
  // This serves as a sentinel for having reached past the end of the list.
  Iterator end() const;
Architectural Decisions
The introduction of iterators puts more constraints on how we can implement the linked list under the hood, in particular how we represent the beginning and end of the list.  In a std::list we can do the following


#include <iostream>
#include <list>

int main() {
    std::list<int> li {1,2,3,4};
    auto it = li.end();
    --it;
    std::cout << "the last element is " << *it << '\n';
    return 0;
}
and your MyList must replicate this functionality.  Think carefully about how to design your MyList so that this is possible.

The Code
There are 4 files on the scaffold, myInteger.hpp, main.cpp, myList.hpp, and myList.cpp.  The file myInteger.hpp is included so that we can populate the list with myInteger s.  The file main.cpp has some tests to get you started and you are free to modify it as you wish for your own testing.

Your implementation should go in the file myList.cpp.  You are free to add additional member variables and functions as needed, and can modify myList.hpp to declare these.

Testing
We include 20 tests in main.cpp to get you started.  When you hit "mark" your code will be run against these 20 tests and an additional 10 hidden test cases.

Marking
The MyList exercise is worth 6 points out of the 20 points for programming assignment 1.  These points are broken down as follows

Functionality (4 points) This will be marked automatically when you press the "mark" button and will be verified by the teaching team.  Each of the 30 tests has equal weight.  The total points you receive for functionality is 2*n/15 if you pass n tests.  Note that your code has to compile and complete all the tests within the time limit in order to receive a score by the marker.

Design (1 point) This will be marked by the grading team.  We will judge your code according to the following criteria

 1) Time complexity: All member functions work in the required complexity bound as stated above.

 2) Bugs: the tests do not catch all errors. The tutors will additionally look for bugs when reading your code.

 3) Succinctness: The path to the solution is clear and direct. No more code is used than necessary.

Style (1 point) This will be marked by the grading team according to the following criteria:

 1) comments --- comments should explain blocks of code where the intention is not immediately clear from the code itself. 

 2) variable names --- variables are given names that explain their role and use. 

 3) formatting --- consistent formatting in indentation and use of braces.

 4) compiles without warnings.

The style score is prorated by the number of member functions implemented.

We will provide feedback about your code online via Ed.

Submission
You must submit your code by pressing the "mark" button on Ed. No other forms of submission will be accepted. You are welcome to develop your code elsewhere, but remember it must compile and run on Ed. We compile with g++ -std=c++20 -Wall -Wextra -fsanitize=address for this assignment. 

You may submit as many times as you like before the due date.

Due Date
Code submission is due by 11:59pm Friday April 12.  Work submitted late without an approved extension is subject to a late penalty of 10 per cent of the total available marks deducted per calendar day that the assessment is overdue.

Plagiarism Checking
All code will be checked for student misconduct and plagiarism using specialised code similarity detection software.  The use of Generative AI like ChatGPT is not allowed to produce code for your solution.  Do not share your code with others or post it to any public repositories before the deadline has passed.  Please include in comments at the top of your code links to any online resources you used in the construction of your solution.