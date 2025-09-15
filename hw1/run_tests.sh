#!/bin/bash

javac *.java || exit 1

for i in 1 2 3 4
    do
        java Driver < test${i}.txt > test${i}_out.txt
    done