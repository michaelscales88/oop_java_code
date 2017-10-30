#!/bin/bash

javac -d "$PWD/class files/" NumbersDriver.java Numbers.java Increase.java Binary.java FileHandler.java
cd ..
java -cp "$PWD/numbers/class files/" numbers.NumbersDriver ./numbers/input.txt ./numbers/output.txt
