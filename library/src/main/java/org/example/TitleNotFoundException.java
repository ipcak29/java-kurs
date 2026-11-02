package org.example;

public class TitleNotFoundException extends Exception {
    public TitleNotFoundException(String message) {
        super(message);
    }
}

//Do biblioteki dodajemy 3 exceptiony w 2 checked i unchecked, błędny tytuł ksiązki (TitleNotFOundException),
//ksiązke już została zwrócona,  ksiązka już jest wypożyczona
// Ps. Rzucić złapać w odpowienim miejscu i obsłużyć