Optional Extra Credit: Generic Cycle Finding
This exercise is optional extra credit.  You can get the full 20 marks for Assignment 1 without doing this exercise.  In doing this challenge you can earn up to 3 marks of extra credit, which can be applied against any lost marks throughout the course.

Background: Generic Programming
Alexander Stepanov, creator of the Standard Template Library, which forms the core of the C++ standard library, coined the term generic programming in a 1988 paper of the same name with David Musser.  (Incidentally, David Musser created the introsort algorithm which is the most common implementation of std::sort.)

Stepanov describes the idea of generic programming like so:

"Now, let us spend some time deriving generic algorithms. The approach is quite simple. First we need to find a useful piece of code. We can use all kinds of sources: existing libraries, Knuth, application code. It should, however, be a useful piece. There should be some evidence that people use it or want to use it. Secondly, we see what makes it work and try to abstract the requirements and identify the concept on which it is really defined."

In the last exercise we saw a useful piece of code to find a cycle in linked list.  But what really makes this algorithm work?  How can we strip it down to its essence so as to apply it in the broadest context?

There seem to be two essential pieces to the tortoise and hare algorithm.  First is the idea of having a starting element and being able to go to the "next" element, which is of the same type.  Second, we need to compare elements for equality to see when the hare catches the tortoise.  The code can work in any context where we have these two things.

We can abstract this as follows.  We have elements of some type.  In the previous exercise the type was Node*, pointers to Node s.  What did the "next" function do?  It took a Node* element and gave us back another Node* element.  For this discussion we assume the linked list has a cycle to avoid discussing nullptr, which is a special case.  We can generalise the next function to be any function that takes an element of type T and again returns an element of type T.

In a more mathematical way, we can write a function 
𝑓
f that takes an element of type 
𝑇
T and returns an element of type 
𝑇
T as

𝑓
:
 
𝑇
 
→
𝑇
f: T →T

OK, so now what problem are we trying to solve?  We begin at some element x of type T.  The "next" element is f(x).  The "next" element after f(x) is f(f(x)), and so on.  The question is if the sequence

𝑥
,
 
𝑓
(
𝑥
)
,
 
𝑓
(
𝑓
(
𝑥
)
)
,
 
𝑓
(
𝑓
(
𝑓
(
𝑥
)
)
)
,
 
…
x, f(x), f(f(x)), f(f(f(x))), …

ever starts to repeat itself, i.e., contains a cycle.  In all our examples this sequence will contain a cycle, and your task is to output the length of this cycle.

Task
Your task is to implement a function with the signature

template <typename T, typename F> 
int findCycleLength(const T& x, const F& f)
Here T is the type of elements and f is a function 

𝑓
:
𝑇
→
𝑇
f:T→T

We discuss passing a function as an argument below, but within findCycleLength you can apply f as normal like 

T hare = f(x);
You are guaranteed that the sequence 

𝑥
,
 
𝑓
(
𝑥
)
,
 
𝑓
(
𝑓
(
𝑥
)
)
,
 
𝑓
(
𝑓
(
𝑓
(
𝑥
)
)
)
,
 
…
x, f(x), f(f(x)), f(f(f(x))), …

contains a cycle, and your task is to output its length.

Passing Functions
The parameter f in the function findCycleLength is itself a function.  The function f takes a single argument of type T.  You can apply f just like a normal function, for example you can say T hare = f(x) .  For writing the function findCycleLength this is all you really need to know, but you may be interested in how we can pass functions to other functions.

There are several ways to do this in C++, but perhaps the simplest is to create a class that has a call operator, that is a member function named operator().  This is called a function object.  Let's look at an example


#include <iostream>
#include <vector>
#include <numeric>

struct Multiply {
  int operator()(int x, int y) {return x * y;};
};

int main() {
    // create an instance of Multiply

You can see in this example that once we create an instance m of Multiply then m(x, y) applies the call operator of Multiply.  We can pass an instance of Multiply to another function; here we pass it to the accumulate function in order to compute the product of all the entries in the vector vec.

For small easy functions it can be more convenient to use a lambda instead.  This is syntactic sugar for writing an unnamed function object, and saves you from having to write the class yourself and introduce another name into your code.  A lambda has three parts, a head, arguments and body.  The head goes between square brackets, the arguments between parenthesis and the body between curly braces as usual.  Let's see the same example again with a lambda.


#include <iostream>
#include <vector>
#include <numeric>

int main() {
    // another way to do factorial
    // std::accumulate with a lambda
    std::vector<int> vec {1, 2, 3, 4, 5};
    std::cout << "5! = ";
    std::cout << std::accumulate(vec.begin(), vec.end(), 1, 

For a small function that you only use once you can see how this can be more convenient.  In this example the head, the part between square brackets is empty.  In general this section can be used to capture variables from the surrounding scope that you want to use in the body of the lambda.

In the test cases we will pass functions to findCycleLength both via function objects and lambdas.

Code
There are only two files on the scaffold, main.cpp and genericCycle.hpp.  Please implement your solution directly in the header file genericCycle.hpp.

Marking
You can earn up to 3 points of extra credit on this exercise.  This exercise is graded purely on the basis of passing test cases.  There are 30 test cases and you receive 0.1 points of extra credit for every test case passed.  All the 30 test cases we test your code on when you hit "mark" are included in main.cpp.

Due Date
Code submission is due by 11:59pm Friday April 12. 

Plagiarism Checking
All code will be checked for student misconduct and plagiarism using specialised code similarity detection software.  The use of Generative AI like ChatGPT is not allowed to produce code for your solution.  Do not share your code with others or post it to any public repositories before the deadline has passed.  Please include in comments at the top of your code links to any online resources you used in the construction of your solution.