# Computer Science II
## Assignment 1.0
### Spring 2024
---

# Overview

In the first assignment, we'll focus on getting used to your new language
(Java or Python) by doing some simple standalone programs.  Follow
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
  following names: `Wins.java`, `WaterUtils.java`, `PatientData.java`

* **For those in the honors section**: your programs must be written
  in python (unless you have no prior Java experience, in which case,
  you should do the Java version), should accept command line arguments
  as specified, and execute successfully on the grader.  Your source
  files should have the following file names: `wins.py`, `water_utils.py`,
  and `patient_data.py`

# Exercises

## Exercise 1 - Predicted Wins (Basic I/O)

In sports, a team's season wins and losses can be predicted using
a Pythagorean expectation which is an adaptation of the Pythagorean
theorem used in geometry.  The wins (and thus losses, no ties are
considered) can be estimated based on the number of points the team
has scored ($p$) and the number of points that have been scored
*against* them ($a$).  For NCAA football, the formula used is:

$$\frac{p^{2.37}}{p^{2.37} + a^{2.37}}$$

For example, in the 2022 season the Nebraska Cornhuskers scored
$p = 271$ total points in 12 games while $a = 331$ points were
scored *against* them.  Applying the formula:

$$\frac{271^{2.37}}{271^{2.37} + 331^{2.37}} = 0.38367$$

Which means that Nebraska was estimated to have won 38.367%
of their games.  In a 12 game season that would be
$.38367 \times 12 = 4.60404$ wins; when rounded properly this
gives us an expectation of 5 wins and thus 7 losses.  In 2022
Nebraska actually won 4 games and lost 8 which is fairly
close to the estimation.  

### Instructions

Write a program that accepts the points for $p$ and
points against $a$ as *command line arguments* and computes
the expected win percentage as well as an expected number
of wins and losses for a 12 game season.  For the first
example above the output should look something like:

```text
Win Percentage: 38.37%
Win/Loss: 5/7
```

* You should perform basic input error checking and
  input validation, exiting with an appropriate message.

## Exercise 2: Water Utilities (Arrays, Testing)

Korra is a water manager at Future Industries, a utility company.
As manager, she has tasked you to write several utilities as part
of the company's new water management software system.  
She wants you to write the following set of utility functions.

### Water Usage Limits

During a drought, each household in a village is restricted to a
certain `limit` of liters of water.  The current water usage
of each household is tracked and stored in a list.

For example, the current `usage` for 5 households could be
represented in the following array:

`[3.5, 8.5, 10, 0, 20]`

(the first has used 3.5 liters, the second 8.5 liters, etc.).

Write a method/function to determine the *remaining* amount
of water each household is allowed to use and returns a new list
containing these figures.  If a household has already reached or
exceeded the `limit`, the they are not allowed any more water.
For the example above for a limit of `10.0` liters, the
method/function should return a list containing the following values.

`[6.5, 1.5, 0.0, 10.0, 0.0]`

The 3rd and 5th households have met and exceeded the `limit`
respectively and have 0 remaining liters available.

### Rainfall Map

Rainfall monitors from the Airbender tribe take regular measurements
of rainfall in an area represented by a two dimensional `n` x `m` grid and
store it as a 2 dimensional array/list. For example, consider
the following 3x5 `map`:

```text
[ 0.75, 0.50, 0.00, -1.00, 0.10 ]
[ 1.00, 0.25, 0.125, 0.00, -5.0 ]
[ 1.25, 0.50, -1.0,  0.10, 2.75 ]
```

When data is not available a negative value is used.  In this
example 3 of the data points are negative so we ignore them.  

Write the a method/function that takes a map and returns the
average rainfall.  In the example above, 12 data points are valid
and sum to 7.325 for an average of 7.325 / 12 = 0.610 units of
rain (the actual units are irrelevant).

### Instructions & Unit Testing

For the Java version, we have provided a starter file with specific method
signatures.  We have also provided a JUnit starter file that
has several test cases already written.  In addition to implementing all methods
as specified, you will be required to *add* additional test cases to the JUnit
testing suite.  Specifically, you need to add at least 2 valid test cases *for
each method* you need to implement.  

For the Python version, we have provided a starter file with specific function
signatures.  We have also provided a `unittest` starter file that
has several test cases already written.  In addition to implementing all function
as specified, you will be required to *add* additional test cases to the `unittest`
testing suite.  Specifically, you need to add at least 2 valid test cases *for
each function* you need to implement.  

## Exercise 3: Patient Data Reports

LSP Inc. is a large pharmaceutical company that has been administering
various doses (in mg) of 4 experimental medications (Nodiathol, Kihpliva,
Xpensiv, and Playceibitol) to thousands of patients over several years.
They are now at the end of their medical trial period and need to
compile several reports.  They have provided you with several data
files (of various sizes for troubleshooting).

### The Data

The data is provided in a CSV file format.  Each line represents
a single dose of one of the four medicines and includes the following data:
  * A UUID of the patient
  * The patient's first and last names,
  * The patient's blood type (A, B, AB, or O)
  * An date/time when the medication was administered in the ISO 8601
    format (so that it is lexicographically ordered)
  * The medicine and dosage (in mg)

An example:

`e3aab55e-697b-4949-b312-42f6018f0daa,Tim,Carlson,A,2022-03-13T05:58:26,Xpensiv,220`

Patients can and will appear multiple times (one for each dose of each
medication they received).  We have provided code that loads up data
file(s) in this format in a data representation (see the provided files).

### Report 1: Totals Report

Your first task is to produce a report of the total number of doses and
total number of milligrams (mg) for each medication.  Your report should
look like the following.

```text
Dose and Dosage Total Report
          Nodiathol     Kihpliva    Xpensiv    Playceibitol
Doses            39           23          8              10
Dosage         5230         2520       1170            1520
```

### Report 2: Blood Type Counts

We need to verify how many *unique* patients are in the data and how
many of each blood type we have for further research.  Take care:
the same patient (identified by a UUID) may appear *many* times in
the data and should not be counted more than once for this report.

Your report should look like the following:

```text
Blood Type Patient Total Report
A         2
B         4
AB        3
O         4
Total    13
```

### Report 3: Bad Dosage Data Report

The data provided was compiled from several different sources, including
data entered by medical professionals, some reported by patients and from
inventory records.  It is possible that dosages were reported incorrectly.
For that reason, LSP Inc has compiled a second set of data and wants you
to find any differences between the two data sets.  

In the first data set (the same one you used to produce the above reports),
for each record: find the record in the second data set (identified by
having the same patient UUID and date/time) and report it if *either*
the medicine or the dosage is different *or*, if the record cannot be
found in the second data set, report it as *missing*.  Your report
should look like the following and all data anomalies should be reported
in order of patient (by UUID), then by date.

```text
Bad Dosage Data Report:
Missing record:
  Thomas, David        (6ca06d8a-274e-4179-8a2f-20cf2510b18a, AB) Playceibitol  210mg on 2022-02-23T00:30:06
Incorrect Dosage:
  Anderson, Jeffrey    (f496f9ad-a888-4ea6-8d98-4c8f3270bda4,  O) Nodiathol     210mg on 2022-03-05T20:15:07
  Anderson, Jeffrey    (f496f9ad-a888-4ea6-8d98-4c8f3270bda4,  O) Nodiathol     120mg on 2022-03-05T20:15:07
Missing record:
  Sanders, Brandy      (f0a1c85b-78bd-40a0-9fd6-54d9745f2acf,  O) Xpensiv        50mg on 2022-03-13T16:01:31
Incorrect Medicine:
  Sanders, Brandy      (f0a1c85b-78bd-40a0-9fd6-54d9745f2acf,  O) Xpensiv       180mg on 2022-03-26T08:24:01
  Sanders, Brandy      (f0a1c85b-78bd-40a0-9fd6-54d9745f2acf,  O) Nodiathol     180mg on 2022-03-26T08:24:01
Incorrect Dosage:
  Long, April          (940ec4f3-6c32-4050-9998-9809fb9fd910,  O) Nodiathol     220mg on 2022-04-27T02:48:32
  Long, April          (940ec4f3-6c32-4050-9998-9809fb9fd910,  O) Nodiathol     210mg on 2022-04-27T02:48:32
Incorrect Medicine:
  Anderson, Jeffrey    (f496f9ad-a888-4ea6-8d98-4c8f3270bda4,  O) Nodiathol     170mg on 2022-08-16T05:59:56
  Anderson, Jeffrey    (f496f9ad-a888-4ea6-8d98-4c8f3270bda4,  O) Xpensiv       170mg on 2022-08-16T05:59:56
Total Missing Patient Data records: 2
Total Incorrect Medicine records:   2
Total Incorrect Dosage records:     2
```

**Take care**: a naive, brute-force approach *will not work*.

### Instructions

Write a program that accepts two input files as command line arguments,
processes the two files, and outputs the reports above to the standard
output.  Two input examples have been provided for you to troubleshoot
and debug your program.  Your output should provide the same information
as the output in this handout, but the *exact* formatting does not need
to match.  

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
