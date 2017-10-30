#!/bin/bash

javac -d "$PWD/class files/" MatrixMath.java Matrix.java MyException.java MatrixTest.java FileHandler.java
cd ..
java -cp "$PWD/matrix/class files/" matrix.MatrixTest ./matrix/matrix.in
