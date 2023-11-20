# Computer Science II
## Project Overview
### Spring 2024
---

> If you don't have the time to do it right, then you'll have to find
> the time to do it over.

# Introduction

Over the course of this semester, you will incrementally build a
substantial database-backed application in Java. In each phase of the
project you will focus on a particular component, which will have
*deliverables* that you must hand in by a certain date. These
deliverables may include a Java Archive (JAR) file, source code,
non-trivial test cases, database schemas and a well-written technical
design document.

Each phase builds upon prior phases and may also require updates and
modifications to prior phases. It is important that you understand the
entire scope of the project. You should read all of the assignments to
get a better understanding of where the project will be going.

The iterative nature of this project means that it is *vital* that you
do not fall behind. In each phase it is also important that you have a
good, well-thought design to make subsequent phases easier to design,
extend and implement. Poor designs, bad implementations, bugs and broken
code will mean subsequent phases of this project will suffer. Investing
your time and resources upfront will minimize your *technical debt* and
mitigate the need to update or refactor your design later on. Remember
one of the Golden Rules of coding: only code that which you would not
mind having to maintain.

# Problem Statement

LSP Holdings is an investment group that has purchased several
small-to-regional cell phone companies and stores and is in the process
of consolidating all of their business interests to form a new larger
company called YRLess.  As part of that process, several brand new
systems are being developed for marketing, inventory, billing, etc.
Each system will be independently developed; it is your team's
responsibility to develop the sales subsystem that will be responsible
for managing sales data in a database-backed system.  The system
will also be responsible for producing several different sales reports.

It will be your responsibility to design a new system from scratch that
is Object-Oriented, written in Java, and supports YRLess's business model
by implementing their business rules and providing the functionality as
stated below.

## Business Model

YRLess (YRL) stores will sell various items including products (phones, phone
accessories, etc.), services (phone repair, delivery), and voice and
data plans.  Each type of item will be identified by a unique alphanumeric
code, a human-readable name/description and a *base cost* that will have a
different meaning for each specific type.

-   **Products** can either be purchased or leased.  When purchased,
    the customer simply pays the entire cost of the product all at once
    in a sale.  As an alternative, the customer can *lease* a product
    over a certain time period (defined by a start/end date).  A
    50% markup is charged for leases and then a monthly cost is calculated.
    On a sale, only the first month is charged (the billing subsystem will
    be responsible for all future charges).  

-   **Services** are things such as phone repair or delivery.  Each
    service has a per-hour rate.  On a sale, a certain number of hours
    are charged and an individual employee (person) is assigned to provide the
    service for the customer.  

-   **Plans** are pay-as-you go plans; both voice/text and data plans are
    offered.  Data plans are sold by the gigabyte (GB) and the cost is per-GB.
    When a customer buys a data plan, they buy a certain number of GB.

    Voice plans provide unlimited talk/text and are billed based on 30-day
    periods.  The base cost is the cost per 30-day period.  When sold, the
    customer buys a certain number of days but do not necessarily have to
    purchase 30-day blocks.  The charge is prorated based on the 30-day
    period.

The sales system will keep track of *sales* which are a collection of
items purchased by a particular customer.  Each sale includes:

-   A unique identifying alphanumeric code

-   The date that the sale was made

-   The customer (and their info) that made the purchase

-   The store (and its info) that the sale was made at

-   The salesperson that made the sale

-   The item(s) that were purchased

Depending on the items and how they were purchased, various taxes
may also applied.

-   All products have a 6.5% sales tax when purchased.  However,
    there are *no* taxes when leased.

-   Services have a 3.5% service tax applied.

-   Voice plans have a 6.5% sales tax while data plans only have a
    5.5% sales tax.

**Note**: for all dollar values, the system will need to round to the
nearest cent.

# Project Outline

Over the course of this semester you will iteratively design an
application to support this business model. Development has been broken
down into 6 phases:

-   Phase I: Data Representation & Electronic Data Interchange (EDI) --
    in the first phase you will design and implement the objects that
    will form a basis for the system and create parsers to read data
    from flat files, generate instances of your objects and export them
    to an interchange format (XML and/or JSON).

-   Phase II: Summary Report -- In this phase you will further refine
    your objects and define relationships between them to generate a
    summary report that aggregates the data together.

-   Phase III: Database Design -- This phase focuses on designing a
    relational database to model your objects and support your
    application

-   Phase IV: Database Connectivity -- You will refactor your code to
    load your objects to your database rather than from flat files

-   Phase V: Database Persistence -- You will implement and use an API
    to persist (save) data to your database.

-   Phase VI: Sorted List ADT -- In this phase you design and implement
    a sorted list ADT and integrate it into your application

# Project Setup Requirements

To ensure that your projects will run on the grader you *must* adhere
to the following requirements and procedures. Failure to do so may make
it impossible to grade your project and you will not receive credit. All
instructions are for the Eclipse IDE.  You may use any alternative IDE
you like, but *you* are responsible for building the JAR file correctly.

A full video walkthrough of the project setup and export process has been
provided here:

https://www.youtube.com/watch?v=lfGVthy2A14&list=PL4IH6CVPpTZXOMCZRaFy_WRc-GvANOZfk&index=4

## Setup Requirements (Eclipse)

-   You *must* include a `readme.md` (a markdown file) file at
    the root of your project with your name(s), canvas username(s), NUIDs and
    school email. If you choose to work in pairs, **both** names/contact
    info should be included.

-   All data files *must* be included in a directory named `data`
    at the root of your project.

-   Any external JAR libraries should be placed in a directory named
    `lib` at the root of your project. Your project should look
    something like the following.

    ![Your project setup should look something like this
    figure.](images/organization.png)

    To add external JAR files to your project do the following.

    1.  Drag and drop your JAR file to this folder, be sure to select
        "copy files"

    2.  Right click the new JAR file in your `lib` folder and
        select `Build Path` then `Add to Build Path`

-   Your `main` method *must* be in the package and class name
    specified by **each** assignment.

## Exporting Your Project (Eclipse)

To export your project for submission to grader, do the following:

1.  Run your program at least once, this creates a "Launch
    Configuration" in Eclipse

2.  Right click your project and select `Export...`

3.  Under the Java folder, select `JAR file`, click `Next`

4.  Be sure to check `Export Java source files and resources` and
    select the location where you want the JAR file saved. It should
    look something like the following.

    ::: center
    ![image](export.png)
    :::

5.  You can now click `Finish` and it should save the project as
    a JAR file which you will then turn in. The JAR file should contain
    all libraries, classes, source files and other data files necessary,
    but you should be sure it works by running the grader and
    addressing any issues.

# Partner Policy & Procedure

You may choose to work alone or with a single partner (i.e. *pairs*) for
each phase of the project. You may change partners between each phase if
you choose. If you do choose to work in pairs, **you must adhere** to the
following guidelines.

-   All work must be the result of an equal collaborative effort by each
    partner. You may not simply partition the work between you.

-   In order to work in pairs, you *must* join a group together in
    Canvas under "People" and then "Project Partners" group set. **Do not** create
    your own group set, use an existing one.

-   Turn in only one copy of the design document with both of your names
    on it.

-   Both of you *should* turn in an electronic copy of all artifacts using
    the webhandin, but ***we will grade based on the submission of the
    partner whose last name comes first alphabetically.***

-   You are *highly encouraged* to use some sort of revision control
    system such as git. However, you must ensure that your team's
    codebase and artifacts are not publicly accessible. Failure to do so
    will be considered a violation of the department's academic
    integrity policy.
