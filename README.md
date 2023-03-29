Author: Alper Ozturk

GitHub Repo Link:
https://github.com/aozturk1/SER316Assignment5Farm

Screencast Link:
...

## Description
A simple farming simulation with multiple design patterns implemented. This is an automated program that simulates a farm
with text/command-line outputs.

## Basic design pattern idea
3 design patterns from the Gang of Four:

a) Design Pattern: Creational / Prototype(Clone)
Requirement:
    "Up to 6 farmers may start on a single farm with more farmers being hired every few
    cycles (this is your choice). Once a farm reaches its capacity of 10 farmers, then a
    new farm must be created by 3 of those farmers." 
Implementation: 
    Since I don't want to recreate the farm every time, I would use a farmer and a farm object witch
    would be cloned when a new farmer is hired or a new farm is added to the world.

b) Design Pattern: Creational / Builder 
NOTE: Factory DP could also work here.
Requirement: 
    "Farms can be of different types, such as an animal farm, a crop farm, a hybrid farm
    and so on. You can choose to make something up too."
Implementation: 
    When creating a farm, there are variations to what kind of farm it can be so here is an
    opportunity to use the builder DP which means that a class farm would have different possible ways
    of cloning or in this case building a farm.

c) Design Pattern: Behavioral / Iterator
Requirement:
    "The simulation should run on cycles. A cycle is considered to be of 2 parts - 1 day
    time and 1 night time."
Implementation:
    When going through the cycles of the day and night, I could simply use the java iterator
    class to iterate through all the farms to make sure that all the farms did what they could
    do that day such as leveling up or selling crops.

## How to run the program
### Terminal
Base Code, please use the following commands:
```
    For Main, run "gradle run"
```   
```
    For test, run "gradle test"
```
```
    For jacoco, run "gradle jacocoTestReport"
```
```
    For CheckStyle and SpotBug, run "gradle build"
```

## Requirements that I think I fulfilled
-Clean Git repo
-Gradle works correctly
-Checkstyle and Spotbugs included
-GitHub Action setup and passes
-JUNIT included and test runs and passes
-Readme has basic idea explained
