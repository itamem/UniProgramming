Finding a Cycle
Continuing on the theme of linked lists, in this exercise you will write a function to determine if a linked list has a cycle, and if so, compute the length of the cycle.  This exercise is worth 4 points out of the 20 points fo Assignment 1.  Specifically, the function you are to write has the signature

int findCycleLength(Node* start);
This function should return -1 if the chain of Node s following start has no cycle, and otherwise, if the chain of Node s following start has a cycle, return the length of this cycle.  In the test cases you will encounter three possible situations:


This linked list has no cycle.  The function should return -1.


This is the "P-shaped" case.  There is a "handle" before the cycle begins.  The length of the cycle here is 4.


In this case the cycle involves all the nodes.  The length of the cycle is 8.

Note that the values at the nodes are immaterial for this question.  We only care about the link structure of the linked list.

Algorithm
We are short of memory for this exercise.  We want your solution to only use a constant amount of memory.  This means that you can only store information about a constant number of nodes at any one time.

There is a classic constant memory solution to this problem due to Robert Floyd based on the tortoise and the hare.  This is the approach that we would like for you to use for this problem.

We start out with

Node* tortoise {start};
Node* hare {start->next};
Then we have a loop where in each iteration we advance the tortoise by one node and the hare (provided it does not become nullptr) by two nodes.  If there is no cycle, then the hare will eventually become nullptr.  If there is a cycle, then at some point the hare will reach it and go around and around it.  Now consider the time when the tortoise first enters the cycle.  At this time the hare is "behind" the tortoise by some number of nodes k.  However, on every iteration of the loop, the hare gets one node closer to the tortoise, as the hare moves by 2 nodes and the tortoise only by 1.  Thus after k more iterations the hare and tortoise will be at the same node.  This is the condition we can check for to indicate we have found a cycle.  

Once we have found a node on the cycle it is a straightforward matter to traverse the cycle one more time to determine its length.

The Code
There are 3 files on the scaffold, main.cpp, findCycle.hpp, and findCycle.cpp.  The file main.cpp has some tests to get you started and you are free to modify it as you wish for your own testing.  Your implementation should go in the file findCycle.cpp.  You are free to add additional functions to findCycle.cpp as needed for your solution.

Testing
We include 9 tests in main.cpp to get you started.  When you hit "mark" your code will be run against these 9 tests and an additional 11 hidden test cases.

Marking
This exercise is worth 4 points out of the 20 points for programming assignment 1.  These points are broken down as follows

Functionality (3 points) This will be marked automatically when you press the "mark" button and will be verified by the teaching team.  Each of the 20 tests has equal weight.  The total points you receive for functionality is 0.15*n if you pass n tests.  Note that your code has to compile and complete all the tests within the time limit in order to receive a score by the marker.

Algorithm (1 point) This will be marked by the grading team.  You will receive this point if your algorithm uses a constant amount of memory and the markers cannot come up with a test case for which your algorithm would fail.  

We will provide feedback about your code online via Ed.

Submission
You must submit your code by pressing the "mark" button on Ed. No other forms of submission will be accepted. You are welcome to develop your code elsewhere, but remember it must compile and run on Ed. We compile with g++ -std=c++20 -Wall -Wextra -fsanitize=address for this assignment. 

You may submit as many times as you like before the due date.

Due Date
Code submission is due by 11:59pm Friday April 12.  Work submitted late without an approved extension is subject to a late penalty of 10 per cent of the total available marks deducted per calendar day that the assessment is overdue.

Plagiarism Checking
All code will be checked for student misconduct and plagiarism using specialised code similarity detection software.  The use of Generative AI like ChatGPT is not allowed to produce code for your solution.  Do not share your code with others or post it to any public repositories before the deadline has passed.  Please include in comments at the top of your code links to any online resources you used in the construction of your solution.