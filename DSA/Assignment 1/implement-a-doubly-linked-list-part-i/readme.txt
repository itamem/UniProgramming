Implement a Doubly Linked List (part I)
This first exercise is worth 10 points out of the 20 total points for programming assignment 1.  In this exercise you will implement a toy version of a  std::list, which is a doubly linked list.  Just like in the standard library, the type of element in the list can be passed as a template parameter and we will test your solution instantiating the template type with int, std::string, and MyInteger the class we made in tutorial.  You are not allowed to use any of the standard library sequence containers std::list, std::forward_list, std::vector, std::deque  in this exercise.  

Our toy version of std::list will be called MyList.  As in the ForwardList Challenge from the Week 4 tutorial, MyList contains a Node class, which now has both next and prev pointers to implement a doubly linked list.  

There are many ways to design a doubly linked list.  We give you full freedom to make these architectural decisions, and you are free (and indeed will need) to add member variables and member functions to the MyList scaffold in the construction of your solution.  In part 2 of this programming assignment you will add iterator functionality to your linked list.  You may wish to read the project description of part 2 before you get started as this might affect the architectural decisions you make.

You can also look at the Week 4 tutorial that featured a singly linked list to see how to traverse a linked list and print out the values at the nodes, which may be helpful in your debugging.

We now go through the member functions you have to implement.

Basic Constructors:
  // Default Constructor
  // Do some setup of your list architecture?
  MyList(); 

  // Construct a list from an initializer list
  // This lets us create a list with the ints 1,2,3,4 by saying
  // MyList<int> li {1,2,3,4};
  MyList(std::initializer_list<T> vals);


The Big Three
  // Copy Constructor
  MyList(const MyList&); 

  // Operator=
  MyList& operator=(MyList); 

  // Destructor
  // free all memory allocated with new
  ~MyList();

Front and Back
Member functions to get the first and last element of the list.  These functions should work in constant time.

  // return the last element by reference
  T& back();
  // return the last element by const reference
  // this one can be used on a const MyDeque
  const T& back() const;
  // return the first element by reference
  T& front();
  // return the first element by const reference
  // this one can be used on a const MyDeque
  const T& front() const;

Add/Remove elements to the front/back
Member functions to add or remove elements from the front or back of the list.  These functions should work in constant time.

  // add an element to the front of the list
  void push_front(T);
  // remove the first element
  void pop_front();

  // add an element to the back of the list
  void push_back(T);
  // remove the last element
  void pop_back();

Functions Related to the Number of Elements
Two functions related to the number of elements in the MyList.  These should work in constant time.

  // does the list have any elements?
  bool empty() const;
  // return the number of elements in the list
  int size() const;
The Code
There are 4 files on the scaffold, myInteger.hpp, main.cpp, myList.hpp, and myList.cpp.  The file myInteger.hpp is included so that we can populate the list with myInteger s.  The file main.cpp has some tests to get you started and you are free to modify it as you wish for your own testing.

Your implementation should go in the file myList.cpp.  You are free to add additional member variables and functions as needed, and can modify myList.hpp to declare these.

Testing
We include 20 tests in main.cpp to get you started.  When you hit "mark" your code will be run against these 20 tests and an additional 10 hidden test cases.

Marking
The MyList exercise is worth 10 points out of the 20 points for programming assignment 1.  These points are broken down as follows

Functionality (8 points) This will be marked automatically when you press the "mark" button and will be verified by the teaching team.  Each of the 30 tests has equal weight.  The total points you receive for functionality is 4*n/15 if you pass n tests.  Note that your code has to compile and complete all the tests within the time limit in order to receive a score by the marker.

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