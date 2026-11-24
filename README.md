4. README / Project Documentation Content
Application Purpose
A2 Motors Data Structures Explorer is a menu-driven Java console program. It uses a small set of dealership vehicle data to show how common data structures and algorithms store, find and reorder records. Each operation prints its steps to the screen.
Dataset Description
The data is a set of vehicle records for A2 Motors. It is written directly into the Java source files, so there is no external file to load. The repository uses these groups of values, each with at least 10 entries where a search or sort needs them:
Used by
Data
Binary search
Ten vehicle IDs: V001 to V010.
Linear search
Ten model names, with duplicates on purpose: Accord, Accord, Civic, Civic, CR-V, HR-V, Odyssey, Passport, Pilot, Ridgeline.
ArrayList and linked list
Starting inventory of five models (Civic, Accord, HR-V, CR-V, Tesla). Pilot, Passport and Odyssey are added or swapped in during the demo.
Sorting
Ten integers in reverse order, 10 down to 1. This is the worst case for bubble sort, which makes the steps easy to follow.

Algorithms and Data Structures Demonstrated
Name
File
Status
Notes
Array
BinarySearch.java, LinearSearch.java, Sorting.java
Done
Fixed-size storage that the searches and sorts work on.
ArrayList
ArrayListDemo.java
Done
Add, insert at an index, update, remove, search, size.
Singly linked list
LinkedList.java
Done
Hand-built nodes, add at end, remove, forward and backward display.
Linear search
LinearSearch.java
Done
O(n). Finds every match, case-insensitive.
Binary search
BinarySearch.java
Done
O(log n). Needs sorted data, so the array is sorted first.
Bubble sort
Sorting.java
Done
O(n²). Prints every swap.
Quick sort
Sorting.java
Done
O(n log n) on average. Prints each partition and pivot.
Merge sort
Sorting.java
Done
O(n log n). Prints each split and merge.
Queue
To be added
In progress
First in, first out.
Stack
To be added
In progress
Last in, first out.
Binary tree
To be added
In progress
Ordered tree of vehicle IDs.
Hash table
To be added
In progress
Key-to-record lookup.
Graph
To be added
In progress
Connected locations or records.

How to Run
we need a JDK (Java 17 or newer) and Git. Open a terminal and run:
git clone https://github.com/Ramesh-Bartaula/DS_OverviewProject.git
cd DS_OverviewProject
javac *.java
java main

The program shows a menu. Type 1 for binary search, 2 for linear search, 3 for the sorting menu (then 1 bubble, 2 quick, 3 merge) or 4 to exit. Anything that is not a number is rejected and the menu appears again.
ArrayListDemo and LinkedList have their own main methods and run on their own:
java ArrayListDemo
java LinkedList

5. Final Demonstration
Finished
ArrayList
Why: A dealership inventory changes all the time and needs fast access by position. An ArrayList grows by itself and lets you read any item by index.
What happens to the data: The list starts as Civic, Accord, HR-V, CR-V, Tesla. Pilot goes onto the end. Passport is inserted at index 1, so everything after it slides one place to the right. Odyssey overwrites the item at index 2 (Accord). Removing CR-V closes the gap by sliding later items left. The last two operations look up Civic (index 0) and print the size, which ends at 6 with the list Civic, Passport, Odyssey, HR-V, Tesla, Pilot.
Linked list
Why: Adding or removing a record in a linked list only means changing a pointer, with no shifting. It also shows what an ArrayList hides: each item is a node that knows only the next one.
What happens to the data: Five nodes are chained in order. Pilot is attached after Tesla. HR-V is removed by pointing Accord straight at CR-V, which leaves HR-V with no way to be reached. The program prints the second item (Accord), then the whole list forward. To print backward it calls a recursive method that goes to the end first and prints on the way back, because a singly linked list has no previous pointer. The final list is Civic, Accord, CR-V, Tesla, Pilot.
Linear search
Why: It works on unsorted data and finds every match, which suits a list that has repeated models.
What happens to the data: The loop looks at each model from index 0 to 9 and compares it to "pilot" without caring about case. Each hit prints its position and raises a counter. With this data Pilot is found once, at index 8. If the counter stays at 0 the program says the model was not found.
Binary search
Why: Looking up a vehicle ID in a sorted list does not need a full scan. Each comparison throws away half of what is left.
What happens to the data: The ten IDs are sorted first, because the method only works on ordered data. Searching for V001 takes three rounds: the middle item is index 4 (V005), which is larger, so the search drops to indexes 0 to 3. The next middle is index 1 (V002), still larger, so it drops to index 0. The middle is now index 0 and it matches. A scan could have needed up to ten comparisons for the same answer.

Bubble, quick and merge sort
Why: The three sorts give a direct comparison of a simple method and two faster ones on the same input.
What happens to the data: All three start from a copy of 10, 9, 8 ... 1, so the original stays untouched. Bubble sort swaps neighbours pass after pass and prints each swap, which for this input comes to 45 swaps. Quick sort picks the last element as the pivot, moves smaller values to its left, drops the pivot into place and repeats on each side. Merge sort splits the range in halves until single items remain, then merges the halves back in order while printing each merge. All three end with 1 to 10.
Being added
The five structures below are not in the repository yet. This is how each one will use the A2 Motors data. Update these paragraphs to match the final code once it is pushed.
Queue
Why: Customers waiting for a test drive or a service slot should be handled in the order they arrived, which is first in, first out.
What happens to the data: Enqueue adds a customer at the back. Dequeue removes the one at the front. Nobody in the middle is touched, and the program will print the line after every change.
Stack
Why: A stack suits anything that must be undone in reverse order, such as the last inventory change or the vehicles a user looked at most recently.
What happens to the data: Push places a record on top and pop takes the top one off, so the newest item always leaves first. Peek shows the top without removing it.
Binary tree
Why: A binary search tree keeps vehicle IDs in order while still allowing quick inserts, which a sorted array cannot do cheaply.
What happens to the data: Each new ID is compared to the node it meets: smaller goes left, larger goes right, until an empty spot is found. Searching follows the same path. An in-order traversal prints the IDs from smallest to largest.
Hash table
Why: When the user already has a vehicle ID, a hash table can return the record almost at once, without searching.
What happens to the data: The ID is run through a hash function that gives a bucket number, and the record is stored there. A lookup repeats the same calculation. If two IDs land in the same bucket, they are kept together in a chain, and the program will show the bucket contents.
Graph
Why: Some A2 Motors data is about connections, such as dealership branches and the routes between them.
What happens to the data: Each location is a vertex and each route is an edge, stored in an adjacency list. Breadth-first and depth-first traversals will print the order in which locations are reached from a starting point.
