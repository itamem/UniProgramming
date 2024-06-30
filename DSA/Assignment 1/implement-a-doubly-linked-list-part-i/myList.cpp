//https://www.youtube.com/watch?v=hJ7lVSt0AsQ 
//^ Used to understand the logic of popback
//https://www.alphacodingskills.com/cpp/ds/cpp-delete-the-first-node-of-the-doubly-linked-list.php
//^Used(not really) to figure out why pushback and or popfront was failing
//https://stackoverflow.com/questions/61078676/what-does-addresssanitizer-segv-on-unknown-address-0x000000000000-mean
//^Used to double check what this seg fault meant at first
//https://www.youtube.com/watch?v=YJRRpXYldVQ
//Similar to lecture slides^, helped make things such as struct less complicated
//https://www.youtube.com/watch?v=-StYr9wILqo
//^Used to understand pointer logic in doubly linkedlist(again)
//https://www.youtube.com/watch?v=PXcRe-W2w7s + rule of 3 intro video
//^Used to get an idea of what I'm meant to put into the copy constructor and assignment operator
//Started to make if statements such as if (size == 1) and (size >0) due to:
// https://edstem.org/au/courses/14394/discussion/1900046
// and https://edstem.org/au/courses/14394/discussion/1903082
//https://stackoverflow.com/questions/4172722/what-is-the-rule-of-three/4172724#4172724
// https://stackoverflow.com/questions/33220226/how-to-traverse-through-n-elements-in-a-doubly-linked-list-in-c
//To try and traverse (for copy constructor)^
// https://www.youtube.com/watch?v=yy8Blgqf41k
//understanding copy constructors in doubly linked lists^

#include <iostream>
#include <utility>
#include <string>
#include "myList.hpp"
#include "myInteger.hpp"

// default constructor
template <typename T>
MyList<T>::MyList() {
}

// copy constructor
template <typename T>
MyList<T>::MyList(const MyList& other){
    for (Node* cur = other.head_; cur != nullptr; cur = cur->next) {  
      push_back(cur->data);
    }
} 

// assignment operator
template <typename T>
MyList<T>& MyList<T>::operator=(MyList other) {
  std::swap(head_, other.head_);
  std::swap(tail_, other.tail_);
  std::swap(size_, other.size_);
  return *this;
}

// destructor (done)
template <typename T>
MyList<T>::~MyList() {
    for (Node* cur = head_; cur != nullptr;) {
    Node* tmp = cur;
    cur = cur->next;
    delete tmp;
    --size_;
  }
}

// constructor from an initializer list
template <typename T>
MyList<T>::MyList(std::initializer_list<T> vals) {
  for (auto it = std::rbegin(vals); it != std::rend(vals); ++it){
    push_front(*it);
  }
}

// push back
template <typename T>
void MyList<T>::push_back(T val) {
  Node* newNode = new Node(val, tail_, nullptr);
  if (empty()){
    head_ = tail_= newNode;
  }
  if (size_ == 1){ 
    head_->next = newNode;
    newNode->prev = head_;
    tail_ = newNode;
    tail_->next = nullptr;
  }
  if (size_ > 1){
    tail_->next = newNode;
    newNode->prev = tail_;
    tail_ = newNode;
    tail_->next = nullptr;
  }
  ++size_;
  tail_->next = nullptr;
}

// pop back (done)
template <typename T>
void MyList<T>::pop_back() {
  if (empty()){
  return;
}
Node* temp; 
  if (size_ == 1){ //working
    temp = head_ = tail_;
    head_ = tail_ = nullptr;
  }

  if (size_ > 1){
    temp = head_;
    head_ = temp->next;
  }
  delete temp;
  --size_;
}

template <typename T>
void MyList<T>::push_front(T val) {
  Node* pushedFrontNode = new Node(val, nullptr, head_);
  if (empty()){
    head_ = tail_ = pushedFrontNode;
  }
  if (size_ > 0) {
    head_ = head_->prev;
  }
  head_ = pushedFrontNode;
  ++size_;
}

template <typename T>
void MyList<T>::pop_front() {
  if (empty()){
    return;
  }
  Node* temp;
  if (size_ == 1){
    temp = head_ = tail_;
    head_ = tail_ = nullptr;
  }
  if (size_ > 1){
  temp = head_;
  head_ = temp->next;
  }
  delete temp;
  --size_;
}

// return the first element by reference 
template <typename T>
T& MyList<T>::front() {
    return head_->data;
}

// return the first element by const reference 
template <typename T>
const T& MyList<T>::front() const {
   return head_->data;
}

// return the last element by reference
template <typename T>
T& MyList<T>::back() {
  return tail_->data;
}

// return the last element by const reference
template <typename T>
const T& MyList<T>::back() const {
  return tail_->data;
}

// is the list empty? 
template <typename T>
bool MyList<T>::empty() const {
  return size_ == 0;
}

// return the number of elements in the list 
template <typename T>
int MyList<T>::size() const {
  return size_;
}

// Print out the list
template <typename T>
void MyList<T>::display() const {
  if (head_ != nullptr) {
    std::cout << "head: " <<head_->data << '\n';
  }
  for (Node* cur = head_->next; cur != nullptr; cur = cur->next) {
    std::cout << "current: " << cur->data << '\n';
  }
}

// These lines let the compiler know with which types we will be
// instantiating MyList
template class MyList<int>;
template class MyList<std::string>;
template class MyList<MyInteger>;
