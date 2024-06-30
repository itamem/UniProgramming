#include <iostream>
#include <utility>
#include <string>
#include "myList.hpp"
#include "myInteger.hpp"

// default constructor
template <typename T>
MyList<T>::MyList() {}

// copy constructor
template <typename T>
MyList<T>::MyList(const MyList& other){
  //creating an instance of a list    
    for (Node* cur = other.head_; cur != nullptr; cur = cur->next) {  
      // Node* newNode = new Node(cur->data)
      push_back(cur->data);
    }
} 

// COME BACK TO (2)
// assignment operator
template <typename T>
MyList<T>& MyList<T>::operator=(MyList other) {
  std::swap(head_, other.head_);
  std::swap(tail_, other.tail_);
  std::swap(size_, other.size_);
  // std::swap(val, other.size_);
  return *this;
  // the logic for how to copy the contents of list called other into the current list
  // (i.e. currentList = otherList)
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
    
    // --size_;
  }
  if (size_ > 1){
    temp = head_;
    head_ = temp->next;
    // tail_->next = nullptr;
    // delete temp;
    // --size_;
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

// return the first element by reference (done)
template <typename T>
T& MyList<T>::front() {
    return head_->data;
}

// return the first element by const reference (done)
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

// is the list empty? (done)
template <typename T>
bool MyList<T>::empty() const {
  return size_ == 0;
}

// return the number of elements in the list (done)
template <typename T>
int MyList<T>::size() const {
  return size_;
}
// return an iterator pointing to the first element
template <typename T>
typename MyList<T>::Iterator MyList<T>::begin() const {}

// return an iterator pointing to the last element
template <typename T>
typename MyList<T>::Iterator MyList<T>::end() const {}

// insert an element into the linked list before *it with the value val
template <typename T>
void MyList<T>::insert(const Iterator& it, const T& val) {}

// remove *it from the list
template <typename T>
void MyList<T>::erase(const Iterator& it) {}

// Iterator constructor
template <typename T>
MyList<T>::Iterator::Iterator(Node* pointer) {}

// (pre-)increment an iterator
template <typename T>
typename MyList<T>::Iterator& MyList<T>::Iterator::operator++() {}

// (pre-)decrement an iterator
template <typename T>
typename MyList<T>::Iterator& MyList<T>::Iterator::operator--() {}

// return the value pointed at by an iterator
template <typename T>
T& MyList<T>::Iterator::operator*() const {}

template class MyList<int>;
template class MyList<std::string>;
template class MyList<MyInteger>;
