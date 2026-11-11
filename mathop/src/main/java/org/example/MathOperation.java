package org.example;

@FunctionalInterface
public interface MathOperation {
    int calculate(int a, int b);
}

//Napisz interfejs funkcyjny MathOperation, który przyjmie dwa argumenty int i zwróci int.
// Następnie:
//utworzyć lambdy dodawania mnożenia odejmowania dzielenia(z obsługą zera)
//przetestować działanie, stworzyć funkcje która przyjmuje dwie liczby i MathOperation,
//
//dodać enum który na podstawie znaku pozwoli na wykonanie odpowiedniej operacji
// (enum z polem MathOperation