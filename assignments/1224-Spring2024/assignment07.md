# Computer Science II
## Assignment 7 - Project Phase VI
## Integrating a Data Structure
---

# Introduction

You will extend the functionality of your application by
designing, implementing and incorporating a sorted list data
structure. Specifically, you will design and implement a list class (or
classes) to hold an arbitrary number of objects which will
***maintain*** an ordering of each of the objects according to some criteria.
You will need to provide implementations (or variations on
implementations) to support each of the following three orders:

-   Last name/first name of the customer in alphabetic ordering

-   Total value of the sale highest-to-lowest

-   An ordering that groups all sales by their store and then by the
    sales person by last name/first name.

You are not allowed to use any of the standard JDK collections objects
or algorithms, nor are you allowed to exploit sorting functionality
provided by your MySQL database or to implement a sorting algorithm
outside your list class.

In prior assignments, you may have maintained a collection of sales
using an array or some `List` implementation. You will need to
update your code to take advantage of your new list implementation
instead.

# Requirements

As with the last assignment, your program will still connect to your
MySQL database on the `cse-linux-01` server. You can (and should) use any test data that you
wish, but when you hand in the final homework we will use our test
cases. However, for this assignment, it will suffice to print a summary
table for each of the orderings specified above, you need not include
the other reports. An example of what the output might look like is
provided at the end of this document.

# Design Process

The details of how you implement your list ADT are a design decision
that you need to make. Some possibilities may include the following.

-   Your list ADT may be array-based, linked-list based, or something
    else entirely.

-   You should implement standard list ADT methods to facilitate adding,
    removing, and retrieving/iterating over elements. Keep in mind that
    order should be *maintained*, not imposed or updated/changed by a
    method call.

-   You should implement any convenience methods (batch adds, size,
    get-by-index, etc.) that you feel would simplify interactions with
    your list ADT.

-   You should make your implementation generic by parameterizing it.

-   To unify your design you should design your class such that a user
    can construct your list with a `Comparator` which your list
    implementation then uses to maintain the ordering defined by the
    `Comparator`.

-   You may consider making your list implement the `Iterable`
    interface so that it can be used in an enhanced for-loop.

# Artifacts

You will turn in all of your code and artifacts using the usual process.
Name your JAR file `Project.jar` and hand it in using the CSE
webhandin.

# Design Write-up

You will update and modify your Design Document draft to include details
on your new Sorted List ADT. You must hand in an updated electronic copy
1 week prior to the assignment due date. In the new section, make sure
to given enough details so that a technically competent individual would
be able to reasonably reproduce an implementation of your design. Be
sure to address at least the following.

-   What is/are the public interface(s) to your list ADT class? How is
    it constructed?

-   How is your list class(es) implemented internally? Is it implemented
    using an array? A linked list? Something else?

-   How does the list's capacity expand and/or contract in response to
    the insertion or removal of elements?

-   How is order maintained in your list ADT?

-   How are adds/removes taken care of in your list? How do you handle
    additions to the list?

-   Is your implementation general? That is could it hold other types of
    objects or is it limited?

# Common Errors, Issues, & Questions

The following is a list of common errors and issues that past students
have encountered and lost points on. These are issues that you will need
to avoid and/or address.

1.  You are not allowed to use the standard JDK collections library for
    your sorted list ADT (and your class should not simply be a
    *wrapper* to any other class). However, you may use the standard JDK
    collections in other respects or internally to other classes.

2.  A sorted list ADT is an ADT that maintains an ordering. That
    ordering should either be defined at instantiation or by design but
    should not be mutable at different points in its lifecycle. It would
    be wrong to have functionality that allows the outside world to
    change the ordering.

3.  Some designs have pre-sorted objects and then given them to the
    "sorted list" ADT. This is an explicitly bad and incorrect design as
    it defeats the purpose of having a sorted list entirely. The purpose
    of such an ADT is that the particulars of how it represents and
    maintains and order is encapsulated in the class and we deal only
    with the abstract add, remove, and retrieve methods.

4.  Some designs have attempted to sort by requiring the user of the
    class to call an explicit sort-by method for whatever ordering you
    wanted to impose. This is not an Object-Oriented Design; in OOP we
    design objects with semantic meaning that should be invariant
    throughout an object's life cycle (recall the square/rectangle or
    ellipse/circle problem). An object's definition should not change
    based on the program state up to that point (this would be a
    structural paradigm, not OOP). Defining and implementing a list that
    sorts by the same ordering throughout its life cycle is more in-line
    with OOP principles.

5.  Many write-ups fail to adequately describe how the list dynamically
    expands/contracts as elements are added/removed from the list. Make
    sure that you are addressing all issues as described in the rubric.

# Output Example

``` text
+-------------------------------------------------------------------------+
| Sales by Customer                                                       |
+-------------------------------------------------------------------------+
Sale       Store      Customer             Salesperson          Total     
s00002     73668b     Leavold, Wit         Halse, Farand        $   9475.38
s00003     9f352c     Leavold, Wit         Witherbed, Denny     $      0.00
s00001     3c0234     Quarry, Staci        Halse, Farand        $ 133439.37
s00004     3c0234     Stammers, Bernadette Soloway, Keslie      $  11174.15
+-------------------------------------------------------------------------+
| Sales by Total                                                          |
+-------------------------------------------------------------------------+
Sale       Store      Customer             Salesperson          Total     
s00001     3c0234     Quarry, Staci        Halse, Farand        $ 133439.37
s00004     3c0234     Stammers, Bernadette Soloway, Keslie      $  11174.15
s00002     73668b     Leavold, Wit         Halse, Farand        $   9475.38
s00003     9f352c     Leavold, Wit         Witherbed, Denny     $      0.00
+-------------------------------------------------------------------------+
| Sales by Store                                                          |
+-------------------------------------------------------------------------+
Sale       Store      Customer             Salesperson          Total     
s00001     3c0234     Quarry, Staci        Halse, Farand        $ 133439.37
s00004     3c0234     Stammers, Bernadette Soloway, Keslie      $  11174.15
s00002     73668b     Leavold, Wit         Halse, Farand        $   9475.38
s00003     9f352c     Leavold, Wit         Witherbed, Denny     $      0.00
```

# Rubric (75 pts)

Style (2)

  *  Clean, well-organized and readable code
  *  Meaningful identifier names
  *  Proper use of whitespace
  *  Consistent style
  *  No debugging or dead code remains

Documentation (3)

  *  Class and method-level documentation for all non-trivial methods
  *  Complex blocks of code are commented
  *  No unnecessary or development-style comments remain
  *  Code is otherwise self-documenting

Design (50)

* Proper objected oriented design
  *  ADT is properly abstracted and awareness of its state is not required for proper use
  *  Data and functionality is properly encapsulated
  *  Design supports code resuse
* ADT provides means to:
  *  Add elements
  *  Remove elements
  *  Retrieve elements
*  External or built-in libraries or code are not used
*  Order is maintained rather than resorting
*  Collection dynamically resizes and capacity is not fixed
*  Leaky abstractions: -5 for each instance
*  Bad abstractions: -10 any public method that allows arbitrary inserts or would otherwise not make it a *sorted list*
*  Using a java collection in the class: -20
*  Using a `.sort` method (your own or Java's): -20

Correctness (20)

  *  Submitted JAR must contain code and artifacts and properly run on the grader
  *  All test cases properly execute and display correct output
  *  Output is valid and well-formatted

Bonus/Honors Items (20)

  *  The Sorted List ADT is generic and parameterized (5)
  *  There is a single implementation that uses a comparator (5)
  *  The class implements the iterable interface (10)
