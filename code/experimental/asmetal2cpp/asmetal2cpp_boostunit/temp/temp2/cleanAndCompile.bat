rm *.o
rm *.exe
g++ -c -o MVMcontroller03.o MVMcontroller03.cpp
g++ -c -o TimeLibrary.o TimeLibrary.cpp
g++ -c -o test.o test.cpp
g++ *.o