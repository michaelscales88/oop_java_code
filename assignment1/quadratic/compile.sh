#!/bin/bash

javac -d "$PWD/class files/" Complex.java Quadratic.java QuadTest.java FileHandler.java
cd ..
java -cp "$PWD/quadratic/class files/" quadratic.QuadTest ./quadratic/quadratic.in ./quadratic/quadratic.out
