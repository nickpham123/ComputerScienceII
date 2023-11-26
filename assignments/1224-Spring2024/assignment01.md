# Computer Science II
## Assignment 1.0
### Spring 2024
---

# Overview

In the first assignment, we'll focus on getting used to your new language
(Java or python) by doing some simple standalone programs.  Follow
instructions **carefully**, failure to do so may result in
points being deducted.  

* For this first assignment, all work must be your own, no partners or
  collaboration with other student(s) is allowed.  However, you may
  discuss problems *at a high level*.  The School of Computing's
  Academic Integrity Policy is in effect: <https://computing.unl.edu/academic-integrity-policy>

* Hand in all your source files and other artifacts through the webhandin
  and verify your programs are correct by running the grader.  

* **For those in the main section(s)**: your programs must be
  written in Java, should accept command line arguments as specified,
  and execute successfully on the grader.  All your classes should
  be in the `unl.soc` package and your source files should have the
  following names: `TODO`

* **For those in the honors section**: your programs must be written
  in python (unless you have no prior Java experience, in which case,
  you should do the Java version), should accept command line arguments
  as specified, and execute successfully on the grader.  Your source
  files should have the following file names: `TODO`

# Exercises

TODO

# Installing and Using JUnit 5 in Eclipse

## Installing

First, we need to add the JUnit library to your project.  First: make
sure you are in your *Java Perspective* (*not* the "Java EE" perspective).

1. Right-click your project in the Project Explorer
2. Select "Build Path" and then "Add Libraries..."
3. Select JUnit then "Next"; make sure to select JUnit 5 and click "Finish"

You should be able to copy any provided JUnit source code
into your project now.  

## Using JUnit

To run a JUnit test suite, simply open the testing file and hit the
"play" button as you would a normal program.  Eclipse will
automatically compile a report of the number of tests passed or
failed along with any messages provided for failed test cases.

Note that there is no `main` method in a JUnit test suite.  Instead,
JUnit uses "reflection" to automatically find unit tests (methods
identified by the `@Test` annotation) and run them.  

## Optional Project Setup

In larger Java projects it is typical to keep source code and
testing code in separate locations.  With JUnit this is usually
done by putting source code in a `src/main/java` folder and JUnit
test code in a `src/test/java` folder.  In addition, JUnit tests are
usually located in the same package structure as the classes
they are testing.

To setup your Eclipse project this way:
1. Right-click your project and select "Build Path" and select "New Source Folder"
2. Create the source folder `src/main/java` (repeat this for `src/test/java`)
3. Move any code you might have had in the original `src` folder to the appropriate new folder

# Rubric

Each exercise will be graded based on the following items.  However, exercise
three will have a total of 41 correctness points.

## Style (2 pts)

-   Appropriate variable and function/method identifiers

-   Style and naming conventions are consistent

-   Good use of whitespace; proper indentation

-   Clean, readable code

## Documentation (2 pts)

-   Well written comments that clearly explain the purpose of each
    non-trivial piece of code

-   Comments explain the "what" and "why"

-   Comments are not overly verbose or overly terse

-   Code itself is "self-documenting"; it explains the "how"

## Program Design (5 pts)

-   Code is well-organized and efficient

-   Code is modular; substantial pieces of it could be reused; few
    redundancies

-   Code is easily understood and maintainable

-   It is clear that sufficient testing has been performed

-   Corner cases and bad input have been anticipated and appropriate
    error handling has been implemented

## Program Correctness (16 pts)

-   Source code compiles and executes as expected

-   Program runs as specified: correctly reads any input; correctly
    formatted output

-   Test cases successfully execute
